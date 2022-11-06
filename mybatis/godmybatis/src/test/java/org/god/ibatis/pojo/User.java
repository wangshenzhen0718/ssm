package org.god.ibatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:wsz
 * @Date: 2022/11/5 22:36
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String carNum;
    private String brand;
    private String guidePrice;
    private String produceTime;
    private String carType;
}