package com.workintech.s18g2.services;

import com.workintech.s18g2.dao.VegetableRepository;
import com.workintech.s18g2.entity.Fruit;
import com.workintech.s18g2.entity.Vegetable;
import com.workintech.s18g2.expections.EntityException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VegetableServiceImpl implements VegetableService {

    private  final VegetableRepository vegetableRepository;
    @Override
    public Vegetable getById(long id) {
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);

        return vegetableOptional.orElseThrow(()-> new EntityException("the data with given id is not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(long id) {
        Vegetable vegetable = getById(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}
