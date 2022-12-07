package com.wang.spring6.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.wang.spring6")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Configuration {
}