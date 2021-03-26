package com.website.qlts.repository;

import com.website.qlts.entity.CategoriesSuppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorySuppliersRepository extends JpaRepository<CategoriesSuppliers, Long> {
    @Query(value = "SELECT * FROM categories_suppliers c WHERE c.name LIKE %:name%", nativeQuery = true)
    public List<CategoriesSuppliers> getByName(@Param("name") String name);

    @Query(value = "SELECT * FROM categories_suppliers c WHERE  c.is_deleted = 0", nativeQuery = true)
    public List<CategoriesSuppliers> getAll();
}
