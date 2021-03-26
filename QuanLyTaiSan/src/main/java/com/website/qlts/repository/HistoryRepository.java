package com.website.qlts.repository;

import com.website.qlts.entity.TransferHistories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<TransferHistories,Long> {
}
