package io.tm.phishingurldetectionservice.data;

import lombok.Data;

import java.util.List;

@Data
public class PhishingURLInput {

    private String phish_id;
    private String url;
    private String phish_detail_url;
    private String submission_time;
    private String verified;
    private String verification_time;
    private String online;
    private PhishingURLDetail[] details;
    private String target;

    @Override
    public String toString() {
        return "PhishingURLInput{" +
                "phish_id='" + phish_id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
