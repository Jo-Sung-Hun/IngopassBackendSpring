package com.sunrint.ingopass.sunrint_ingopass_backend.Service.NeisService;


import com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis.NeisDate;
import com.sunrint.ingopass.sunrint_ingopass_backend.Service.JsonSerivce.JsonServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.util.Objects;

@Service
public class NeisServiceImpl implements NeisService{
    private static final Logger logger = LoggerFactory.getLogger(NeisServiceImpl.class);
    @Value("${neis.api.host.url}")
    private String NEIS_API_HOST_URL;
    private static final String ATPT_OFCDC_SC_CODE;
    private static final String SD_SCHUL_CODE;
    private final JsonServiceImp jsonService;

    private final RestTemplate restTemplate;
    static {
        ATPT_OFCDC_SC_CODE = "B10";
        SD_SCHUL_CODE = "7010536";
    }
    @Autowired
    public NeisServiceImpl(JsonServiceImp jsonService, RestTemplate restTemplate) {
        this.jsonService = jsonService;
        this.restTemplate = restTemplate;
    }

    @Override
    public String getMeal(NeisDate date) {
        if (Objects.isNull(date)){
            throw new NullPointerException("date is null");
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Object result = restTemplate.getForObject(NEIS_API_HOST_URL ,Object.class);
        String resultresult = String.valueOf(result).replace("/\\s\\s\\([^)]*\\)/gi", "").replace("</br>", "");
        logger.info(resultresult);
        try {
            return jsonService.getJson(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String getNotice() {
        return null;
    }
}
