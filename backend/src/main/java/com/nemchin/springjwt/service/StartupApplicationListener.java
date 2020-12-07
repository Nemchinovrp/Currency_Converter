package com.nemchin.springjwt.service;

import com.nemchin.springjwt.generated.ValCurs;
import com.nemchin.springjwt.model.Valute;
import com.nemchin.springjwt.repository.ValuteRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StartupApplicationListener implements
        ApplicationListener<ApplicationStartedEvent> {
    private final ValuteRepository valuteRepository;
    private final RestTemplateService restTemplateService;
    private final ValuteService valuteService;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        Date date = new Date();
        List<Valute> lastListValute = valuteRepository.getLastValutes();
        if (lastListValute.isEmpty()) {
            fillValute();
            return;
        }
        Valute valute = lastListValute.get(0);
        if (date.after(valute.getDate())) {
            fillValute();
        }
    }

    @SneakyThrows
    private void fillValute() {
        ValCurs valCurs = restTemplateService.getValutesFromCbr();
        valuteService.saveValute(valCurs);
    }
}