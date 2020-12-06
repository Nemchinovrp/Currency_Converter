package com.nemchin.springjwt.generated;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "valute"
})
@XmlRootElement(name = "ValCurs")
public class ValCurs {

    @XmlElement(name = "Valute", required = true)
    private List<ValCurs.Valute> valute;
    @XmlAttribute(name = "Date", required = true)
    private String date;
    @XmlAttribute(name = "name", required = true)
    private String name;

    public List<ValCurs.Valute> getValute() {
        if (valute == null) {
            valute = new ArrayList<ValCurs.Valute>();
        }
        return this.valute;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String value) {
        this.date = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "numCode",
            "charCode",
            "nominal",
            "name",
            "value"
    })
    public static class Valute {

        @XmlElement(name = "NumCode")
        @XmlSchemaType(name = "unsignedShort")
        protected int numCode;
        @XmlElement(name = "CharCode", required = true)
        protected String charCode;
        @XmlElement(name = "Nominal")
        @XmlSchemaType(name = "unsignedInt")
        protected long nominal;
        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "Value", required = true)
        protected String value;
        @XmlAttribute(name = "ID", required = true)
        protected String id;

        public int getNumCode() {
            return numCode;
        }

        public void setNumCode(int value) {
            this.numCode = value;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String value) {
            this.charCode = value;
        }

        public long getNominal() {
            return nominal;
        }

        public void setNominal(long value) {
            this.nominal = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String value) {
            this.name = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getID() {
            return id;
        }

        public void setID(String value) {
            this.id = value;
        }

    }

}
