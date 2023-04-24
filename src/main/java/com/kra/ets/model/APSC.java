package com.kra.ets.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KRA_INT.currency_exchange")
public class APSC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dates")
    private Date dates;

    @Column(name = "usd")
    private String usd;

    @Column(name = "acc")
    private String acc;

    @Column(name = "exchange_rate")
    private String exchangeRate;

    @Column(name = "ksh")
    private String ksh;


    @Column(name = "upload_id")
    private String uploadId;

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh;
    }


    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }
}
