package io.tm.phishingurldetectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhishingUrlDetectionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhishingUrlDetectionServiceApplication.class, args);
//        String json = null;
//        Gson gson = new Gson();
//        try {
//            json = readFile("E://URLs.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        PhishingURLInput[] urls = gson.fromJson(json, PhishingURLInput[].class);
//        System.out.println(urls.length);
    }

//    private static String readFile(String fileName) throws IOException {
//        return new String(Files.readAllBytes(Paths.get(fileName)));
//    }

}
