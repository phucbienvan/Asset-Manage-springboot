package com.website.qlts.repository;

import com.website.qlts.entity.TransferHistories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransferRepository  extends JpaRepository<TransferHistories,Long> {
    @Query(value = "SELECT * FROM transfer_histories c WHERE  c.is_deleted = 0 ORDER BY c.asset_id", nativeQuery = true)
    public List<TransferHistories> getAll();

    @Query(value = "SELECT * FROM transfer_histories c WHERE  c.is_deleted = 0 AND c.status = 1", nativeQuery = true)
    public List<TransferHistories> getAllByDepartment();

    @Query(value = "SELECT * FROM transfer_histories c WHERE  c.is_deleted = 0 AND c.status = 2", nativeQuery = true)
    public List<TransferHistories> getAllByStaff();

    @Query(value = "SELECT * FROM transfer_histories c WHERE  c.is_deleted = 0 AND c.start_date >= ? AND c.end_date <= ?", nativeQuery = true)
    public List<TransferHistories> getAllByDate(Date fromDate, Date toDate);

    @Query(value = "SELECT * FROM transfer_histories c WHERE  c.is_deleted = 0 AND c.start_date >= ? AND c.end_date <= ?", nativeQuery = true)
    public List<TransferHistories> getByName(String name);

    @Query(value = "SELECT * FROM transfer_histories c WHERE  c.is_deleted = 0 AND c.asset_id = ?", nativeQuery = true)
    public List<TransferHistories> getListById(long id);
}
