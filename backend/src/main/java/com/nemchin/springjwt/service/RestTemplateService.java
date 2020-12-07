package com.nemchin.springjwt.service;

import com.nemchin.springjwt.generated.ValCurs;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestTemplateService {
    private final RestTemplate restTemplate;

    public ValCurs getValutesFromCbr() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        String dateString = dateFormat.format(new Date());
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + dateString;
        ResponseEntity<ValCurs> response = restTemplate.postForEntity(url, null, ValCurs.class);
        return response.getBody();
    }
}
