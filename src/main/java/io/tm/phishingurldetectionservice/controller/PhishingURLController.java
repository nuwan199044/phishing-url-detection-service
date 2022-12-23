package io.tm.phishingurldetectionservice.controller;

import com.google.gson.Gson;
import io.tm.phishingurldetectionservice.model.PhishingSearchRequest;
import io.tm.phishingurldetectionservice.model.PhishingURL;
import io.tm.phishingurldetectionservice.repository.PhishingURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PhishingURLController {

    @Autowired
    PhishingURLRepository phishingURLRepository;

    @Autowired
    Gson gson;

    @PostMapping(value = "/search", produces = "application/json")
    public String isPhishingUrl(@RequestBody PhishingSearchRequest request) {

        System.out.println("phishing url >>>> " + request.toString());
        PhishingURL phishingURL = null;

        try {
            phishingURL = phishingURLRepository.findByUrl(request.getUrl());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return gson.toJson(phishingURL);
    }
}
