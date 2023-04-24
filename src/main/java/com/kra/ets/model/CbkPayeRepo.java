package com.kra.ets.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CbkPayeRepo extends JpaRepository<CBKPAYE,Long> {
    Object deleteAllByUploadIdEquals(String uploadId);
}
