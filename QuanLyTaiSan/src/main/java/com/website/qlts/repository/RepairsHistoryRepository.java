package com.website.qlts.repository;

import com.website.qlts.entity.RepairHistories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepairsHistoryRepository extends JpaRepository<RepairHistories,Long> {
    @Query(value = "SELECT * FROM repair_histories c WHERE   c.is_deleted = 0", nativeQuery = true)
    public List<RepairHistories> getAll();
}
