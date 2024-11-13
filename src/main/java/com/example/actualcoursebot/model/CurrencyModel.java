package com.example.actualcoursebot.model;

import lombok.Data;

@Data
public class CurrencyModel {
    String symbol;
    Double price;
    Long timestamp;
}