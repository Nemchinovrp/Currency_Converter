package com.nemchin.springjwt.service;

import com.nemchin.springjwt.generated.ValCurs;
import com.nemchin.springjwt.mapper.ValuteMapper;
import com.nemchin.springjwt.model.Valute;
import com.nemchin.springjwt.repository.ValuteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ValuteService {
    private final ValuteRepository valuteRepository;
    private final ValuteMapper valuteMapper;

    public boolean saveValute(ValCurs valCurs) throws ParseException {
        List<Valute> valutes = valuteMapper.valueCursToValute(valCurs);
        valutes.forEach(System.out::println);
        List<Valute> savedСurrencies = valuteRepository.saveAll(valutes);
        return !savedСurrencies.isEmpty();
    }
}