package com.website.qlts.repository;

import com.website.qlts.entity.RevokeHistories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RevokeHistoryRepository extends JpaRepository<RevokeHistories, Long> {
    @Query(value = "SELECT * FROM revoke_histories c WHERE   c.is_deleted = 0", nativeQuery = true)
    public List<RevokeHistories> getAll();

    @Query(value = "SELECT * FROM revoke_histories c WHERE   c.is_deleted = 0 AND revoke_date >= ? AND revoke_date <= ?", nativeQuery = true)
    public List<RevokeHistories> getByDate(Date fromDate, Date toDate);

    @Query(value = "SELECT * FROM revoke_histories c WHERE   c.is_deleted = 0 AND asset_id = ?", nativeQuery = true)
    public List<RevokeHistories> getById(long id);
}
