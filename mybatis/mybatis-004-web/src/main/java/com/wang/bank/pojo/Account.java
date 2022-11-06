package com.wang.bank.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:wsz
 * @Date: 2022/11/6 19:02
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private String name;
    private Double balance;
}
