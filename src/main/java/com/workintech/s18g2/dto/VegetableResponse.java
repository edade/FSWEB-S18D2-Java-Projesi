package com.workintech.s18g2.dto;

import com.workintech.s18g2.entity.Vegetable;
import org.springframework.http.HttpStatus;

public record VegetableResponse(String message, Vegetable vegetable) {
}
