package com.workintech.s18g2.controller;


import com.workintech.s18g2.dto.FruitResponse;
import com.workintech.s18g2.entity.Fruit;
import com.workintech.s18g2.services.FruitService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @GetMapping
    public List<Fruit> findAll(){
        return  fruitService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> getDesc(){
        return  fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public FruitResponse get(@Positive @PathVariable long id){
        return new FruitResponse("find by id is succesfull" , fruitService.getById(id));
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }
    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@Size(min = 2,max = 45) @PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id){
        return fruitService.delete(id);
    }

}
