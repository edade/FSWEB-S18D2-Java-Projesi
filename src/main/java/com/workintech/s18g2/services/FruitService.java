package com.workintech.s18g2.services;

import com.workintech.s18g2.entity.Fruit;

import java.util.List;

public interface FruitService {

    Fruit getById(long id);

    List<Fruit> getByPriceAsc();
    List<Fruit> getByPriceDesc();
    Fruit save(Fruit fruit);

    Fruit delete(long id);

    List<Fruit> searchByName(String name);

}
