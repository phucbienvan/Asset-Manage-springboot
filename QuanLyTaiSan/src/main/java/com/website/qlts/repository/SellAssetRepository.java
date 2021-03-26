package com.website.qlts.repository;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.SellAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellAssetRepository  extends JpaRepository<SellAsset,Long> {
    @Query(value = "SELECT * FROM sell_asset c WHERE   c.is_deleted = 0", nativeQuery = true)
    public List<SellAsset> getAll();
}
