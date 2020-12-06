package com.nemchin.springjwt.service;

import com.nemchin.springjwt.generated.ValCurs;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestTemplateService {
    private final RestTemplate restTemplate;

    public String test() {
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=05/03/2019";
        ResponseEntity<ValCurs> response = restTemplate.postForEntity(url, null, ValCurs.class);
        System.out.println(response.toString());
        return response.toString();
    }
}
