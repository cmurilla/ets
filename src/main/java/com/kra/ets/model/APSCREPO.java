package com.kra.ets.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface APSCREPO extends JpaRepository<APSC,Long> {
    Object deleteAllByUploadIdEquals(String uploadId);
}
