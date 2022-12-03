package com.wang.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author:wsz
 * @Date: 2022/12/3 15:08
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Component
public class Product {

    private String brand;
    private Integer price;

    public Product(@Value("apple")String brand,@Value("100") Integer price) {
        this.brand = brand;
        this.price = price;
    }
    //@Value可以用在方法上
/*    @Value("apple")
    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Value("100")
    public void setPrice(Integer price) {
        this.price = price;
    }*/

    @Override
    public String toString() {
        return "Product{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
