package com.kra.ets.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "KRA_INT.ECITIZEN_DATA")
public class ECITIZEN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txnNumber;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "service")
    private String service;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "applications")
    private String applications;

    @Column(name = "currency")
    private String currency;

    @Column(name = "net")
    private String net;

    @Column(name = "commission")
    private String commission;

    @Column(name = "mpesa_206206")
    private String mpesa206206;

    @Column(name = "visa_mastercard")
    private String visaMastercard;

    @Column(name = "equitel_206206")
    private String equitel206206;

    @Column(name = "pesaflow")
    private String pesaflow;

    @Column(name = "cash_kcb")
    private String cashKCB;

    @Column(name = "rtgs_kcb")
    private String rtgsKCB;

    @Column(name = "airtel_206206")
    private String airtel206206;

    @Column(name = "status")
    private String status;

    @Column(name = "date_settled")
    private String dateSettled;

    @Column(name = "date_submitted")
    private Date dateSubmitted;

    @Column(name = "upload_id")
    private String uploadId;

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public Long getTxnNumber() {
        return txnNumber;
    }

    public void setTxnNumber(Long txnNumber) {
        this.txnNumber = txnNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getApplications() {
        return applications;
    }

    public void setApplications(String applications) {
        this.applications = applications;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getMpesa206206() {
        return mpesa206206;
    }

    public void setMpesa206206(String mpesa206206) {
        this.mpesa206206 = mpesa206206;
    }

    public String getVisaMastercard() {
        return visaMastercard;
    }

    public void setVisaMastercard(String visaMastercard) {
        this.visaMastercard = visaMastercard;
    }

    public String getEquitel206206() {
        return equitel206206;
    }

    public void setEquitel206206(String equitel206206) {
        this.equitel206206 = equitel206206;
    }

    public String getPesaflow() {
        return pesaflow;
    }

    public void setPesaflow(String pesaflow) {
        this.pesaflow = pesaflow;
    }

    public String getCashKCB() {
        return cashKCB;
    }

    public void setCashKCB(String cashKCB) {
        this.cashKCB = cashKCB;
    }

    public String getRtgsKCB() {
        return rtgsKCB;
    }

    public void setRtgsKCB(String rtgsKCB) {
        this.rtgsKCB = rtgsKCB;
    }

    public String getAirtel206206() {
        return airtel206206;
    }

    public void setAirtel206206(String airtel206206) {
        this.airtel206206 = airtel206206;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateSettled() {
        return dateSettled;
    }

    public void setDateSettled(String dateSettled) {
        this.dateSettled = dateSettled;
    }


    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }
}
