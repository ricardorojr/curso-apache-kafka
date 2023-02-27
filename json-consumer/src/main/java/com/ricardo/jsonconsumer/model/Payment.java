package com.ricardo.jsonconsumer.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Payment implements Serializable {

    private Long id;
    private Long user;
    private Long idProduct;
    private String cardNumber;



}
