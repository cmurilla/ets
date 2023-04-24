package com.kra.ets.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kra.ets.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@RestController
@RequestMapping("/uploads")
public class UploadController {

     @Autowired
     com.kra.ets.model.CbkItRepository cbkItRepository;

    @Autowired
    com.kra.ets.model.CbkPayeRepo cbkPayeRepo;

    @Autowired
    com.kra.ets.model.CbkwhRepo cbkwhRepo;

    @Autowired
    com.kra.ets.model.CbkvatRepo cbkvatRepo;

    @Autowired
    EcitizenRepo ecitizenRepo;

    @Autowired
            APSCREPO apscrepo;

    @Autowired
    CBKREPOS cbkrepos;

    Date currentDate = new Date();

    @PostMapping(value = "/cbkit", produces = "application/json")
    public ResponseEntity<String> find(@RequestBody List<LinkedHashMap> data, @RequestHeader("Authorization") Optional<String> token) {

        for (LinkedHashMap bio : data) {
            String ref = bio.get("reference_no").toString();
            if (ref == null) {
                continue;
            }

            CBKIT it = new CBKIT();
            it.setCrAmount(bio.get("cr_amount").toString());
            it.setDrAmount(bio.get("dr_amount").toString());
            it.setReferenceNo(bio.get("reference_no").toString());
            it.setTxnDate(convertToDate(bio.get("txn_date").toString()));
            it.setValueDate(convertToDate(bio.get("value_date").toString()));
            it.setTxnDetails(bio.get("txn_details").toString());
            it.setUploadId((String) bio.get("uploadId"));
            it.setCreatedDate(currentDate);
            cbkItRepository.save(it);
        }
        return new ResponseEntity<>("Data received and stored successfully.", HttpStatus.OK);
    }


    @PostMapping("/cbkvat")
    public ResponseEntity<String> uploadCbkvat(@RequestBody List<LinkedHashMap> data) {

        for (LinkedHashMap bio : data) {

            String ref = bio.get("reference_no").toString();
            if (ref == null) {
                continue;
            }

            CBKVAT it = new CBKVAT();
            it.setCrAmount(bio.get("cr_amount").toString());
            it.setDrAmount(bio.get("dr_amount").toString());
            it.setReferenceNo(bio.get("reference_no").toString());
            it.setTxnDate(convertToDate(bio.get("txn_date").toString()));
            it.setValueDate(convertToDate(bio.get("value_date").toString()));
            it.setTxnDetails(bio.get("txn_details").toString());
            it.setUploadId((String) bio.get("uploadId"));
            it.setCreatedDate(currentDate);
            cbkvatRepo.save(it);
        }

        return new ResponseEntity<>("Data received and stored successfully.", HttpStatus.OK);
    }

    @PostMapping("/others")
    public ResponseEntity<String> uploadCbkOthers(@RequestBody List<LinkedHashMap> data) {

        for (LinkedHashMap bio : data) {

            String ref = bio.get("reference_no").toString();
            if (ref == null) {
                continue;
            }

            CBK_OTHERS it = new CBK_OTHERS();
            it.setCrAmount(bio.get("cr_amount").toString());
            it.setDrAmount(bio.get("dr_amount").toString());
            it.setReferenceNo(bio.get("reference_no").toString());
            it.setTxnDate(convertToDate(bio.get("txn_date").toString()));
            it.setValueDate(convertToDate(bio.get("value_date").toString()));
            it.setTxnDetails(bio.get("txn_details").toString());
            it.setUploadId((String) bio.get("uploadId"));
            it.setAcc((String) bio.get("account"));
            it.setCreatedDate(currentDate);
            cbkrepos.save(it);
        }

        return new ResponseEntity<>("Data received and stored successfully.", HttpStatus.OK);
    }


    @PostMapping("/cbkwvat")
    public ResponseEntity<String> uploadCbkwvat(@RequestBody List<LinkedHashMap> data) {

        for (LinkedHashMap bio : data) {

            String ref = bio.get("reference_no").toString();
            if (ref == null) {
                continue;
            }


            CBKWH it = new CBKWH();
            it.setCrAmount(bio.get("cr_amount").toString());
            it.setDrAmount(bio.get("dr_amount").toString());
            it.setReferenceNo(bio.get("reference_no").toString());
            it.setTxnDate(convertToDate(bio.get("txn_date").toString()));
            it.setValueDate(convertToDate(bio.get("value_date").toString()));
            it.setTxnDetails(bio.get("txn_details").toString());
            it.setUploadId((String) bio.get("uploadId"));
            it.setCreatedDate(currentDate);
            cbkwhRepo.save(it);
        }

        return new ResponseEntity<>("Data received and stored successfully.", HttpStatus.OK);
    }

    @PostMapping("/cbkpaye")
    public ResponseEntity<String> uploadCbkpaye(@RequestBody List<LinkedHashMap> data) {

        for (LinkedHashMap bio : data) {

            String ref = bio.get("reference_no").toString();
            if (ref == null) {
                continue;
            }

            CBKPAYE it = new CBKPAYE();
            it.setCrAmount(bio.get("cr_amount").toString());
            it.setDrAmount(bio.get("dr_amount").toString());
            it.setReferenceNo(bio.get("reference_no").toString());
            it.setTxnDate(convertToDate(bio.get("txn_date").toString()));
            it.setValueDate(convertToDate(bio.get("value_date").toString()));
            it.setTxnDetails(bio.get("txn_details").toString());
            it.setUploadId((String) bio.get("uploadId"));
            it.setCreatedDate(currentDate);
            cbkPayeRepo.save(it);
        }

        return new ResponseEntity<>("Data received and stored successfully.", HttpStatus.OK);
    }


    @PostMapping("/ecitizen")
    public ResponseEntity<String> uploadEcitizen(@RequestBody List<LinkedHashMap> data) {

        for (LinkedHashMap bio : data) {

            String ref = bio.get("account_number").toString();
            if (ref == null) {
                continue;
            }

            ECITIZEN transaction = new ECITIZEN();
            transaction.setStartDate(convertToDate(bio.get("dates").toString()));
            transaction.setEndDate((String) bio.get("end_date"));
            transaction.setService((String) bio.get("service"));
            transaction.setAccountName((String) bio.get("account_name"));
            transaction.setAccountNumber((String) bio.get("account_number"));
            transaction.setApplications((String) bio.get("applications"));
            transaction.setCurrency((String) bio.get("currency"));
            transaction.setNet((String) bio.get("net"));
            transaction.setCommission((String) bio.get("commission"));
            transaction.setMpesa206206((String) bio.get("mpesa_206206"));
            transaction.setVisaMastercard((String) bio.get("visa_mastercard"));
            transaction.setEquitel206206((String) bio.get("equitel_206206"));
            transaction.setPesaflow((String) bio.get("pesaflow"));
            transaction.setCashKCB((String) bio.get("cash_kcb"));
            transaction.setRtgsKCB((String) bio.get("rtgs_kcb"));
            transaction.setAirtel206206((String) bio.get("airtel_206206"));
            transaction.setStatus((String) bio.get("status"));
            transaction.setDateSettled((String) bio.get("date_settled"));
            transaction.setDateSubmitted(convertToDate(bio.get("date_submitted").toString()));
            transaction.setUploadId((String) bio.get("uploadId"));
            ecitizenRepo.save(transaction);
        }

        return new ResponseEntity<>("Data received and stored successfully.", HttpStatus.OK);
    }





    @PostMapping("/apsc")
    public ResponseEntity<String> uploadApsc(@RequestBody List<LinkedHashMap> data) {

        for (LinkedHashMap bio : data) {

            String ref = bio.get("dates").toString();
            if (ref == null) {
                continue;
            }

            APSC transaction = new APSC();
            transaction.setDates(convertToDate(bio.get("dates").toString()));
            transaction.setExchangeRate((String) bio.get("exchange_rate"));
            transaction.setKsh((String) bio.get("ksh"));
            transaction.setUsd((String) bio.get("usd"));
            transaction.setAcc((String) bio.get("acc"));
            transaction.setUploadId((String) bio.get("uploadId"));

            apscrepo.save(transaction);
        }

        return new ResponseEntity<>("Data received and stored successfully.", HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> uploadDelete(@RequestBody LinkedHashMap data) {

       String uploadId = data.get("data").toString();
       apscrepo.deleteAllByUploadIdEquals(uploadId);
       cbkItRepository.deleteAllByUploadIdEquals(uploadId);
       cbkPayeRepo.deleteAllByUploadIdEquals(uploadId);
       cbkrepos.deleteAllByUploadIdEquals(uploadId);
       cbkvatRepo.deleteAllByUploadIdEquals(uploadId);
       cbkwhRepo.deleteAllByUploadIdEquals(uploadId);
       ecitizenRepo.deleteAllByUploadIdEquals(uploadId);

        return new ResponseEntity<>("Data received and stored successfully.", HttpStatus.OK);
    }



    private static final List<String> DATE_FORMAT_PATTERNS = Arrays.asList(
            "dd/MM/yyyy", "dd-MMM-yyyy", "dd-M-yyyy", "dd-MM-yyyy",
            "yyyy-MM-dd", "yyyy/MM/dd", "MM/dd/yyyy", "MM-dd-yyyy"
    );

    public static Date convertToDate(String dateString) {
        Date date = null;
        for (String formatPattern : DATE_FORMAT_PATTERNS) {
            try {
                DateFormat dateFormat = new SimpleDateFormat(formatPattern);
                dateFormat.setLenient(false);
                date = dateFormat.parse(dateString);
                break;
            } catch (ParseException e) {
                // Try the next format pattern
            }
        }
        if (date == null) {
            try {
                // Try parsing as LocalDate using the default format
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
                LocalDate localDate = LocalDate.parse(dateString, formatter);
                date = java.sql.Date.valueOf(localDate);
            } catch (DateTimeParseException e) {
                // Convert the input string to the nearest resembling date
                LocalDate localDate = LocalDate.now();
                String[] parts = dateString.split("\\W");
                for (String part : parts) {
                    try {
                        int value = Integer.parseInt(part);
                        if (value > 0 && value <= 31) {
                            localDate = localDate.withDayOfMonth(value);
                        } else if (value > 0 && value <= 12) {
                            localDate = localDate.withMonth(value);
                        } else if (value > 1900 && value <= 2100) {
                            localDate = localDate.withYear(value);
                        }
                    } catch (NumberFormatException ex) {
                        // Ignore non-numeric parts
                    }
                }
                date = java.sql.Date.valueOf(localDate);
            }
        }
        return date;
    }

}

