package com.workintech.s18g2.services;

import com.workintech.s18g2.entity.Fruit;
import com.workintech.s18g2.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    Vegetable getById(long id);
    List<Vegetable> getByPriceAsc();
    List<Vegetable> getByPriceDesc();
    Vegetable save(Vegetable Vegetable);

    Vegetable delete(long id);

    List<Vegetable> searchByName(String name);
}
