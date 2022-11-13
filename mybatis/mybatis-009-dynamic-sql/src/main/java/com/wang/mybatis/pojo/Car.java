package com.wang.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:wsz
 * @Date: 2022/11/12 11:26
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Long id;
    private String carNum;
    private String brand;
    private Double guidePrice;
    private String produceTime;
    private String carType;
}