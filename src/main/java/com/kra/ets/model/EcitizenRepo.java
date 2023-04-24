package com.kra.ets.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EcitizenRepo extends JpaRepository<ECITIZEN, Long> {
    Object deleteAllByUploadIdEquals(String uploadId);
}
