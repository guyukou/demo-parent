package org.guyu.jackson.controller;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.guyu.jackson.model.NumberDTO;
import org.guyu.jackson.req.PunishCollection;
import org.guyu.jackson.req.PunishDetail;
import org.springframework.validation.annotation.Validated;
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
    public String submit(@Validated @RequestBody PunishCollection punishCollection) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(punishCollection);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> collect = punishCollection.getDetails().stream()
                .map(punishDetail -> validator.validate(punishDetail.getParam()))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        collect.forEach(punishDetailConstraintViolation -> System.out.println(punishDetailConstraintViolation.getMessage()));
        return "ok";
    }

    @PostMapping("/submit2")
    public String submit2(@Validated @RequestBody NumberDTO param) {
        return "ok";
    }
}
