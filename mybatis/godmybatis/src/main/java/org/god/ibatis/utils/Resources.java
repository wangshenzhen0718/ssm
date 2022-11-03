package org.god.ibatis.utils;

import java.io.InputStream;

/**
 * @Author:wsz
 * @Date: 2022/11/2 22:27
 * @Description:godbatis 提供的一个工具类 这个工具类专门完成“类路径”中资源的加载
 * @Version: 1.0
 * @Since: 1.0
 */
public class Resources {

    private Resources() {
    }

    /**
     * 从类路径中获取资源
     *
     * @param resource 放在类路径中的资源
     * @Date: 2022/11/2 22:31
     * @return 指向资源文件的输入流
     */
    public InputStream getResourceAsStream(String resource) {
        return ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
    }
}
