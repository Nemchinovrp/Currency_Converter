package com.nemchin.springjwt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "valute")
public class Valute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String idValute;
    private String charCode;
    private String name;
    private String value;
    private String nominal;

    public Valute(Date date, String idValute, String charCode, String name, String value, String nominal) {
        this.date = date;
        this.idValute = idValute;
        this.charCode = charCode;
        this.name = name;
        this.value = value;
        this.nominal = nominal;
    }

    public Valute(String idValute, String charCode, String name, String value, String nominal) {
        this.idValute = idValute;
        this.charCode = charCode;
        this.name = name;
        this.value = value;
        this.nominal = nominal;
    }
}