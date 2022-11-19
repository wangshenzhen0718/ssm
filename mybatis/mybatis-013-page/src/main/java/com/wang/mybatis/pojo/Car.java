package com.wang.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Long id;

    private String brand;

    private String carNum;

    private BigDecimal guidePrice;

    private String produceTime;

    private String carType;


}