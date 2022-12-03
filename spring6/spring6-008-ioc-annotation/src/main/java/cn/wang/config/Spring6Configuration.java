package cn.wang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:wsz
 * @Date: 2022/12/3 20:51
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Configuration
@ComponentScan({"cn.wang.dao","cn.wang.service"})
public class Spring6Configuration {
}
