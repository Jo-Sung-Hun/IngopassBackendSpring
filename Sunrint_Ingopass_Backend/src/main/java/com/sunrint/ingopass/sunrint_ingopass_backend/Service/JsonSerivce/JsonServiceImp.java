package com.sunrint.ingopass.sunrint_ingopass_backend.Service.JsonSerivce;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsonServiceImp implements JsonService
{
    private static final Logger logger = LoggerFactory.getLogger(JsonServiceImp.class);
    private static final ObjectMapper objectMapper;
    static {
            objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE,false);
    }
    @Override
    public Object getObject(String json, Class<?> clazz) throws Exception {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public String getJson(Object object) throws IOException {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonMappingException exception){
            exception.printStackTrace();
        }
        return null;
    }
}
