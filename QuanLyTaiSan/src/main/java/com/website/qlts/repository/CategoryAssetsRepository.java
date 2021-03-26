package com.website.qlts.repository;

import com.website.qlts.entity.CategoryAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryAssetsRepository extends JpaRepository<CategoryAssets,Long>{

    @Query(value = "SELECT * FROM category_assets c WHERE c.name LIKE %:name%",nativeQuery=true)
    public List<CategoryAssets> getByName(@Param("name") String name);

    @Query(value = "SELECT * FROM category_assets c WHERE  c.is_deleted = 0", nativeQuery = true)
    public List<CategoryAssets> getAll();
}
