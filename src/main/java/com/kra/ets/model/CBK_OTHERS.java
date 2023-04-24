package com.kra.ets.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "KRA_INT.CBKIT_OTHERS" )
public class CBK_OTHERS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txnNumber;

    @Column(name = "txn_date")
    private Date txnDate;

    @Column(name = "value_date")
    private Date valueDate;

    @Column(name = "reference_no")
    private String referenceNo;

    @Column(name = "txn_details")
    private String txnDetails;

    @Column(name = "dr_amount")
    private String drAmount;

    @Column(name = "cr_amount")
    private String crAmount;

    @Column(name = "created_date")
    private Date createdDate;


    @Column(name = "upload_id")
    private String uploadId;

    @Column(name = "accounts")
    private String acc;



    public Long getTxnNumber() {
        return txnNumber;
    }

    public void setTxnNumber(Long txnNumber) {
        this.txnNumber = txnNumber;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getTxnDetails() {
        return txnDetails;
    }

    public void setTxnDetails(String txnDetails) {
        this.txnDetails = txnDetails;
    }

    public String getDrAmount() {
        return drAmount;
    }

    public void setDrAmount(String drAmount) {
        this.drAmount = drAmount;
    }

    public String getCrAmount() {
        return crAmount;
    }

    public void setCrAmount(String crAmount) {
        this.crAmount = crAmount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }
}
