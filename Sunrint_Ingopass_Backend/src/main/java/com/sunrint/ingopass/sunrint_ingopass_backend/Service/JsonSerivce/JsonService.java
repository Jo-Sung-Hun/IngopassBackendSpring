package com.sunrint.ingopass.sunrint_ingopass_backend.Service.JsonSerivce;

import java.io.IOException;

public interface JsonService {

    Object getObject(String json, Class<?> clazz) throws Exception;
    String getJson(Object object) throws IOException;
}
