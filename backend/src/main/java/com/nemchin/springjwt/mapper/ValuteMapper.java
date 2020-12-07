package com.nemchin.springjwt.mapper;

import com.nemchin.springjwt.generated.ValCurs;
import com.nemchin.springjwt.model.Valute;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
public class ValuteMapper {
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

    public List<Valute> valueCursToValute(ValCurs valCurs) throws ParseException {
        List<Valute> valutes = new ArrayList<>();
        Date date = formatter.parse(valCurs.getDate());
        valCurs.getValute().stream().forEach(val -> {
            valutes.add(new Valute(date, val.getID(), val.getCharCode(), val.getName(), val.getValue(), Long.toString(val.getNominal())));
        });
        return valutes;
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
