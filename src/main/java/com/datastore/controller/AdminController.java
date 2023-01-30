package com.datastore.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {
	
	@GetMapping("")
	public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView("index");
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8081/DataStoreApplication/users", Object[].class);
        List<Object> listUsers = Arrays.asList(responseEntity.getBody());
        modelAndView.addObject("listUsers", listUsers);
        return modelAndView;
    } 
}
