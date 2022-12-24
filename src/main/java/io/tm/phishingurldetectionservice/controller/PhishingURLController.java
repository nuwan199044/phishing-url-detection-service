package io.tm.phishingurldetectionservice.controller;

import com.google.gson.Gson;
import io.tm.phishingurldetectionservice.model.APIResponse;
import io.tm.phishingurldetectionservice.model.PhishingSearchRequest;
import io.tm.phishingurldetectionservice.model.PhishingURL;
import io.tm.phishingurldetectionservice.repository.PhishingURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PhishingURLController {

    @Autowired
    PhishingURLRepository phishingURLRepository;

    @Autowired
    Gson gson;

    @PostMapping(value = "/search", produces = "application/json")
    public @ResponseBody
    ResponseEntity isPhishingUrl(@RequestBody PhishingSearchRequest request) {

        System.out.println("phishing url >>>> " + request.toString());
        PhishingURL phishingURL = null;
        ResponseEntity responseEntity = null;
        APIResponse apiResponse = new APIResponse();

        try {
            phishingURL = phishingURLRepository.findByUrl(request.getUrl());

            if (phishingURL == null) {
                apiResponse.setResponse_status("SUCCESS");
                apiResponse.setData(null);
                responseEntity = new ResponseEntity<>(gson.toJson(apiResponse), HttpStatus.OK);
            } else {
                apiResponse.setResponse_status("FAIL");
                apiResponse.setData(phishingURL);
                responseEntity = new ResponseEntity<>(gson.toJson(phishingURL), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseEntity;
    }
}
