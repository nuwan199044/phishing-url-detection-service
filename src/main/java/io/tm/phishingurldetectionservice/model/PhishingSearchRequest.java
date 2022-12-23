package io.tm.phishingurldetectionservice.model;

import lombok.Data;

@Data
public class PhishingSearchRequest {

    private String url;

    @Override
    public String toString() {
        return "PhishingSearchRequest{" +
                "url='" + url + '\'' +
                '}';
    }
}
