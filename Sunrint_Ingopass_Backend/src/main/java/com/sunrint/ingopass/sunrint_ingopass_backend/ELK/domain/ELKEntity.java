package com.sunrint.ingopass.sunrint_ingopass_backend.ELK.domain;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ELKEntity {
    String timestamp;
    String hostname;
    String hostIp;
    String clientIp;
    String clientUrl;
    String callFunction;
    String type;
    String parameter;
}
