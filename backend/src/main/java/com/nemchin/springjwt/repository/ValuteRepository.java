package com.nemchin.springjwt.repository;

import com.nemchin.springjwt.model.Valute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValuteRepository extends JpaRepository<Valute, Long> {
}
