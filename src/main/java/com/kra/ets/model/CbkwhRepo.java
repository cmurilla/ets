package com.kra.ets.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CbkwhRepo extends JpaRepository<CBKWH,Long> {
    Object deleteAllByUploadIdEquals(String uploadId);
}
