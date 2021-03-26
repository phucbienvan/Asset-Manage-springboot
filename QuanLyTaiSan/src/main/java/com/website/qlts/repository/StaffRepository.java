package com.website.qlts.repository;

import com.website.qlts.entity.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface StaffRepository extends JpaRepository<Staffs,Long> {
    @Query(value = "SELECT * FROM staffs c WHERE c.name LIKE %:name%",nativeQuery=true)
    public List<Staffs> getByName(@Param("name") String name);

    @Query(value = "SELECT * FROM staffs c WHERE  c.is_deleted = 0", nativeQuery = true)
    public List<Staffs> getAll();

    @Query(value = "SELECT * FROM staffs c WHERE  c.is_deleted = 0 AND c.id = ?", nativeQuery = true)
    public Staffs getById(long id);
}
