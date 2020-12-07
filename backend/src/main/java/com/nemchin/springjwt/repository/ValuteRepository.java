package com.nemchin.springjwt.repository;

import com.nemchin.springjwt.model.Valute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ValuteRepository extends JpaRepository<Valute, Long> {

    List<Valute> getAllByDate(Date date);

    @Query("SELECT DISTINCT new Valute(v.date, v.idValute, v.charCode, v.name, v.value, v.nominal)\n" +
            "FROM Valute v\n" +
            "WHERE v.date=(\n" +
            "SELECT MAX(v.date) FROM v)")
    List<Valute> getLastValutes();

}
