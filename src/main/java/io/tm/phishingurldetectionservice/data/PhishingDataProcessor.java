package io.tm.phishingurldetectionservice.data;

import com.google.gson.Gson;
import io.tm.phishingurldetectionservice.model.PhishingURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@Component
public class PhishingDataProcessor implements CommandLineRunner {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    @Transactional
    public void run(String... args) {

        try {

            Resource resource = resourceLoader.getResource("classpath:URLs.json");
            String json = new String(Files.readAllBytes(Paths.get(resource.getFile().getAbsolutePath())));
            Gson gson = new Gson();

            PhishingURLInput[] urls = gson.fromJson(json, PhishingURLInput[].class);

            Arrays.stream(urls).forEach(url -> {
                PhishingURL phishingURL = new PhishingURL(
                        Long.parseLong(url.getPhish_id()),
                        url.getUrl(),
                        url.getPhish_detail_url(),
                        url.getSubmission_time(),
                        url.getVerified(),
                        url.getVerification_time(),
                        url.getOnline(),
                        url.getTarget()
                );
                entityManager.persist(phishingURL);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
