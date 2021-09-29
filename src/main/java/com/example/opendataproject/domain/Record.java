package com.example.opendataproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Record {

    @JsonProperty("Datums")
    private Timestamp datums;

    @JsonProperty("Valsts")
    private String valsts;

    @JsonProperty("14DienuKumulativaIncidence")
    private String kumulativa;

    @JsonProperty("Izcelosana")
    private String izcelosana;

    @JsonProperty("Pasizolacija")
    private String pasizolacija;

    @JsonProperty("PersIrVakcParslSert_PasizolacijaLatvija")
    private String pasizolacijaJaSert;

    @JsonProperty("PersIrVakcParslSert_TestsPirmsIebrauksanasLV")
    private String testsPirmsJaSert;

    @JsonProperty("PersIrVakcParslSert_TestsPecIebrauksanasLV")
    private String testsPecJaSert;

    @JsonProperty("CitasPersonas_PasizolacijaLatvija")
    private String pasizolacijaNavSert;

    @JsonProperty("CitasPersonas_TestsPirmsIebrauksanasLV")
    private String testsPirmsNavSert;

    @JsonProperty("CitasPersonas_TestsPecIebrauksanasLV")
    private String testsPecNavSert;

    public Record() {
    }

    public Timestamp getDatums() {
        return datums;
    }

    public void setDatums(Timestamp datums) {
        this.datums = datums;
    }

    public String getValsts() {
        return valsts;
    }

    public void setValsts(String valsts) {
        this.valsts = valsts;
    }

    public String getKumulativa() {
        return kumulativa;
    }

    public void setKumulativa(String kumulativa) {
        this.kumulativa = kumulativa;
    }

    public String getIzcelosana() {
        return izcelosana;
    }

    public void setIzcelosana(String izcelosana) {
        this.izcelosana = izcelosana;
    }

    public String getPasizolacija() {
        return pasizolacija;
    }

    public void setPasizolacija(String pasizolacija) {
        this.pasizolacija = pasizolacija;
    }

    public String getPasizolacijaJaSert() {
        return pasizolacijaJaSert;
    }

    public void setPasizolacijaJaSert(String pasizolacijaJaSert) {
        this.pasizolacijaJaSert = pasizolacijaJaSert;
    }

    public String getTestsPirmsJaSert() {
        return testsPirmsJaSert;
    }

    public void setTestsPirmsJaSert(String testsPirmsJaSert) {
        this.testsPirmsJaSert = testsPirmsJaSert;
    }

    public String getTestsPecJaSert() {
        return testsPecJaSert;
    }

    public void setTestsPecJaSert(String testsPecJaSert) {
        this.testsPecJaSert = testsPecJaSert;
    }

    public String getPasizolacijaNavSert() {
        if (pasizolacijaNavSert.equals("10 dienas pēc izbraukšanas no attiecīgās valsts***")) {
            pasizolacijaNavSert = "10 dienas pēc izbraukšanas no attiecīgās valsts";
        }
        return pasizolacijaNavSert;
    }

    public void setPasizolacijaNavSert(String pasizolacijaNavSert) {
        this.pasizolacijaNavSert = pasizolacijaNavSert;
    }

    public String getTestsPirmsNavSert() {
        return testsPirmsNavSert;
    }

    public void setTestsPirmsNavSert(String testsPirmsNavSert) {
        this.testsPirmsNavSert = testsPirmsNavSert;
    }

    public String getTestsPecNavSert() {
        return testsPecNavSert;
    }

    public void setTestsPecNavSert(String testsPecNavSert) {
        this.testsPecNavSert = testsPecNavSert;
    }

    public Boolean over75(){
        if(!kumulativa.isEmpty()){
            return Float.parseFloat(kumulativa) > 75;
        }
        return false;
    }
}
