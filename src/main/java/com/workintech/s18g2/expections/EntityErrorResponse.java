package com.workintech.s18g2.expections;

import lombok.AllArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
public class EntityErrorResponse {

    private Integer status;
    private String message;
    private LocalDateTime dateTime;




}
