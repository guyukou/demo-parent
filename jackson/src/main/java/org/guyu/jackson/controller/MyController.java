package org.guyu.jackson.controller;

import org.guyu.jackson.req.PunishCollection;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-27
 */
@RestController
@RequestMapping("/")
public class MyController {

    @PostMapping("/submit")
    public String submit(@RequestBody PunishCollection punishCollection) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(punishCollection);
        System.out.println(json);
        PunishCollection punishCollection1 = objectMapper.readValue(json, PunishCollection.class);
        return punishCollection.toString();
    }
}
