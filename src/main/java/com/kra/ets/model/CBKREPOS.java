package com.kra.ets.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CBKREPOS extends JpaRepository<CBK_OTHERS, Long> {
    Object deleteAllByUploadIdEquals(String uploadId);
}
