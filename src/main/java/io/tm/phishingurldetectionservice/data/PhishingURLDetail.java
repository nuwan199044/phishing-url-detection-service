package io.tm.phishingurldetectionservice.data;

import lombok.Data;

@Data
public class PhishingURLDetail {

    private String ip_address;
    private String cidr_block;
    private String announcing_network;
    private String rir;
    private String country;
    private String detail_time;

}
