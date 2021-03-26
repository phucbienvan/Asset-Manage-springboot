package com.website.qlts.repository;

import com.website.qlts.entity.GroupAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupAssetsRepository extends JpaRepository<GroupAssets,Long> {
    @Query(value = "SELECT * FROM group_assets c WHERE c.group_name LIKE %:name%", nativeQuery = true)
    public List<GroupAssets> getByName(@Param("name") String name);

    @Query(value = "SELECT * FROM group_assets c WHERE  c.is_deleted = 0", nativeQuery = true)
    public List<GroupAssets> getAll();
}
