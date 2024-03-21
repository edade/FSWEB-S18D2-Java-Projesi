package com.workintech.s18g2.dao;

import com.workintech.s18g2.entity.Fruit;
import com.workintech.s18g2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query(value = "SELECT v.id,v.name,v.price,v.grownOnTree from s18g2.Vegetable as v ORDER BY v.price DESC" , nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value = "SELECT v.id,v.name,v.price,v.grownOnTree from s18g2.Vegetable as v ORDER BY v.price ASC" , nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    @Query("SELECT v from Vegetable v where v.name ILIKE %:name%")
    List<Vegetable> searchByName(String name);
}
