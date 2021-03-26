package com.website.qlts.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "suppliers")
public class Suppliers implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String name;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String address;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String phoneNumber;
    //    private long supplier_category_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "supplier_category_id", unique = false)
    private long supplier_category_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_category_id", updatable = false, insertable = false, unique = false)
    private CategoriesSuppliers categoriesSupplier;
    private int is_deleted;

    public Suppliers() {
    }

    public Suppliers(String name, String address, String phoneNumber, long supplier_category_id, int is_deleted) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.supplier_category_id = supplier_category_id;
        this.is_deleted = is_deleted;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public long getSupplier_category_id() {
        return supplier_category_id;
    }

    public void setSupplier_category_id(long supplier_category_id) {
        this.supplier_category_id = supplier_category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoriesSuppliers getCategoriesSupplier() {
        return categoriesSupplier;
    }

    public void setCategoriesSupplier(CategoriesSuppliers categoriesSupplier) {
        this.categoriesSupplier = categoriesSupplier;
    }

//    public long getSupplier_category_id() {
//        return supplier_category_id;
//    }
//
//    public void setSupplier_category_id(long supplier_category_id) {
//        this.supplier_category_id = supplier_category_id;
//    }
}
