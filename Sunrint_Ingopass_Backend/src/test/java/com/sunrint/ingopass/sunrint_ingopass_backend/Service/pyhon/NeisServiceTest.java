package com.sunrint.ingopass.sunrint_ingopass_backend.Service.pyhon;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis.Meal.NeisServerMealResponseEntitiy;
import com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis.Meal.NeisServerMealResponseEntitiyRowMeal;
import com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis.NeisDate;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@EnableAsync
public class NeisServiceTest {



    private static final String ATPT_OFCDC_SC_CODE;
    private static final String SD_SCHUL_CODE;
    private static final ObjectMapper objectMapper;
    private static final RestTemplate restTemplate = new RestTemplate();
    static {
        ATPT_OFCDC_SC_CODE = "B10";
        SD_SCHUL_CODE = "7010536";
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE,false);
    }

    @Test
    public void getMeal() {
        ObjectMapper objectMapper = new ObjectMapper();
        LocalDateTime today = LocalDateTime.now();
        int a = Integer.parseInt(today.format(DateTimeFormatter.ofPattern("yyyyMM")));
        String NEIS_API_HOST_URL = "https://open.neis.go.kr/hub/mealServiceDietInfo?KEY=bdecb19803854391b3071b3b4fdd8096&" +
                "Type=json&pIndex=1&pSize=100&ATPT_OFCDC_SC_CODE=B10&SD_SCHUL_CODE=7010536&" +
                "MLSV_YMD=" + a;
        System.out.println(NEIS_API_HOST_URL);

        String date = "20200101";
        if (date.isEmpty() || date.isBlank() || date.length() != 8){
            if ((date.length() < 8)) {
                throw new IllegalArgumentException("date is not valid");
            }
            throw new NullPointerException("date is null");
        }
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6, 8);
        NeisDate neisDate = null;
        try {
            neisDate = NeisDate.builder().day(Integer.valueOf(day)).month(Integer.valueOf(month)).year(Integer.valueOf(year)).build();
        }catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (Objects.isNull(neisDate)){
            throw new NullPointerException("date is null");
        }
        String result = restTemplate.getForObject(NEIS_API_HOST_URL , String.class);
        System.out.println(result);
        String jsonResult = null;
        try {
            try {
                jsonResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            } catch (JsonMappingException exception){
                exception.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // make test vaild assertEqual
        NeisServerMealResponseEntitiyRowMeal result2 = null;
        NeisServerMealResponseEntitiy neisServerMealResponseEntitiy = null;
        try  {

            result2 = objectMapper.readValue(jsonResult, NeisServerMealResponseEntitiyRowMeal.class);
        } catch (JsonProcessingException ignore) {
        }
        assertThat(Objects.requireNonNull(result2).getMLSV_YMD()).isNotEmpty();
    }
    private Integer getThisWeek(){
        LocalDateTime now = LocalDateTime.of(2023, 5, 21, 12, 0, 0);
        int resultDayOfWeek = now.getDayOfWeek().getValue();
        if (resultDayOfWeek > 1) {
            throw new IllegalArgumentException("date is not valid");
        } else {
            LocalDateTime beforeWeek = now.minusDays(7);
            return beforeWeek.getDayOfWeek().getValue();
        }
    }

    @Test
    public void getNotice() {

    }
}

