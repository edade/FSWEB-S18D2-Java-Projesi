package com.workintech.s18g2.controller;

import com.workintech.s18g2.dto.FruitResponse;
import com.workintech.s18g2.dto.VegetableResponse;
import com.workintech.s18g2.entity.Fruit;
import com.workintech.s18g2.entity.Vegetable;
import com.workintech.s18g2.services.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private final VegetableService vegetableService;

    @GetMapping
    public List<Vegetable> findAll(){
        return  vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getDesc(){
        return  vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public VegetableResponse get(@Positive @PathVariable long id){
        return new VegetableResponse("find by id is succesfull" , vegetableService.getById(id));
    }


    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }
    @GetMapping("/name/{name}")
    public List<Vegetable> getByName(@Size(min = 2,max = 45) @PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id){
        return vegetableService.delete(id);
    }
}
