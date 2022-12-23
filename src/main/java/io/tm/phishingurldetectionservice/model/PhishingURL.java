package io.tm.phishingurldetectionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PhishingURL {

    @Id
    private Long phishId;
    @Column(name = "url", length = 6000)
    private String url;
    private String phishDetailURL;
    private String submissionTime;
    private String verified;
    private String verificationTime;
    private String online;
    private String target;

    @Override
    public String toString() {
        return "PhishingURL{" +
                "phishId=" + phishId +
                ", test='" + url + '\'' +
                ", phishDetailURL='" + phishDetailURL + '\'' +
                ", submissionTime='" + submissionTime + '\'' +
                ", verified='" + verified + '\'' +
                ", verificationTime='" + verificationTime + '\'' +
                ", online='" + online + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
