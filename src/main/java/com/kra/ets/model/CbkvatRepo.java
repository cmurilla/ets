package com.kra.ets.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CbkvatRepo extends JpaRepository<CBKVAT,Long> {
    Object deleteAllByUploadIdEquals(String uploadId);
}
