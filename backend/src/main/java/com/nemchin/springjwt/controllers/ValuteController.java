package com.nemchin.springjwt.controllers;

import com.nemchin.springjwt.model.Valute;
import com.nemchin.springjwt.service.ValuteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/valute")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ValuteController {
    private final ValuteService valuteService;

    @GetMapping("/all_valute")
    private List<Valute> getAllValute() {
        return valuteService.getLastValutes();
    }
}