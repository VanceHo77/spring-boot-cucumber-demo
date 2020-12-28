package com.vance.springbootcucumber.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class PanInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String cardNumber;
}
