package com.nemchin.springjwt.service;

import com.nemchin.springjwt.generated.ValCurs;
import com.nemchin.springjwt.mapper.ValuteMapper;
import com.nemchin.springjwt.model.Valute;
import com.nemchin.springjwt.repository.ValuteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ValuteService {
    private final ValuteRepository valuteRepository;
    private final ValuteMapper valuteMapper;

    public boolean saveValute(ValCurs valCurs) throws ParseException {
        List<Valute> valutes = valuteMapper.valueCursToValute(valCurs);
        List<Valute> savedСurrencies = valuteRepository.saveAll(valutes);
        return !savedСurrencies.isEmpty();
    }

    public List<Valute> getLastValutes() {
        return valuteRepository.getLastValutes();
    }
}