package com.website.qlts.repository;

import com.website.qlts.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    @Query(value = "SELECT * FROM departments c WHERE c.department_name LIKE %:name%", nativeQuery = true)
    public List<Departments> getByName(@Param("name") String name);

    @Query(value = "SELECT * FROM departments c WHERE  c.is_deleted = 0", nativeQuery = true)
    public List<Departments> getAll();

    @Query(value = "SELECT * FROM departments WHERE  parent_id = ?", nativeQuery = true)
    public List<Departments> getParentId(long parentId);
}
