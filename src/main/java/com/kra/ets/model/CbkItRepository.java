package com.kra.ets.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CbkItRepository extends JpaRepository<CBKIT, Long> {
    Object deleteAllByUploadIdEquals(String uploadId);
}
