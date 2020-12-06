package com.nemchin.springjwt.controllers;

import com.nemchin.springjwt.generated.ValCurs;
import com.nemchin.springjwt.service.RestTemplateService;
import com.nemchin.springjwt.service.ValuteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final ValuteService valuteService;
    private final RestTemplateService restTemplateService;


    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/rest_template")
    public boolean restTemplate() throws ParseException {
        ValCurs valutesFromCbr = restTemplateService.getValutesFromCbr(new Date());
        return valuteService.saveValute(valutesFromCbr);
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

