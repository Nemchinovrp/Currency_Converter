package com.nemchin.springjwt.controllers;

import com.nemchin.springjwt.generated.ValCurs;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final RestTemplate restTemplate;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/rest_template")
    public String restTemplate() {
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=05/03/2019";
        ResponseEntity<ValCurs> response = restTemplate.postForEntity(url, null, ValCurs.class);
        System.out.println(response.toString());
        ValCurs valCurs = response.getBody();
        System.out.println("----------------------------");
        System.out.println(valCurs.getDate());
        System.out.println(valCurs.getName());
        System.out.println("----------------------------");
        List<ValCurs.Valute> valutes = valCurs.getValute();
        valutes.stream().forEach(valute -> {
            System.out.println(valute.getID() + " - " + valute.getName() + " - " + valute.getValue() + " -  " +
                    valute.getCharCode() + " - " + valute.getNominal() + " - " + valute.getNumCode());
        });
        return response.toString();
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}

