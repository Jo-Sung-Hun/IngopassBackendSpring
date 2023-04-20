package com.sunrint.ingopass.sunrint_ingopass_backend.Controller.basic;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis.NeisDate;
import com.sunrint.ingopass.sunrint_ingopass_backend.Service.NeisService.NeisServiceImpl;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasicController {
    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private final NeisServiceImpl neisService;
    @Autowired
    public BasicController(NeisServiceImpl neisService) {
        this.neisService = neisService;
    }

    @RequestMapping(value = "/meal", method = RequestMethod.GET)
    public Object getMeal(@RequestParam("date") String date){
        // example 20220521
        if (date.isEmpty() || date.isBlank() || date.length() != 8){
            if ((date.length() < 8)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        NeisDate mealApiNeisDate = NeisDate.builder()
                .year(Integer.parseInt(date.substring(0, 4)))
                .month(Integer.parseInt(date.substring(4, 6)))
                .day(Integer.parseInt(date.substring(6, 8)))
                .build();

        String mealResultJson = neisService.getMeal(mealApiNeisDate);
        logger.info("meal request info \n" +
                " {}", mealResultJson);
        return new ResponseEntity<>(mealResultJson, HttpStatus.OK);
    }
    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    private String saveNotice(@RequestBody String noticeJson){
        return "";
    }
    @RequestMapping(value = "/timetable", method = RequestMethod.GET)
    public Object getTimetable(@NotNull @RequestParam("date") String date,
                               @NotNull @RequestParam("grade") String grade,
                               @NotNull @RequestParam("class") String classNum){
        if (date.isEmpty() || date.isBlank() || date.length() != 8) {

        }
        return "";
    }
}

