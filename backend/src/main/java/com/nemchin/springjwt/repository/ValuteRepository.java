package com.nemchin.springjwt.repository;

import com.nemchin.springjwt.model.Valute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ValuteRepository extends JpaRepository<Valute, Long> {

    List<Valute> getAllByDate(Date date);

}
