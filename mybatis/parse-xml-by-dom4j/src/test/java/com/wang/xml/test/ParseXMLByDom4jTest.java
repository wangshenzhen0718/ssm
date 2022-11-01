package com.wang.xml.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ParseXMLByDom4jTest {
    @Test
    public void testParseSqlMapperXml() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("CarMapper.xml");
        Document document = saxReader.read(is);
        String xpath = "/mapper";
        Element mapper = (Element) document.selectSingleNode(xpath);
        String namespace = mapper.attributeValue("namespace");
        //获取mapper节点下所有子节点
        List<Element> elements = mapper.elements();
        elements.forEach(e -> {
            //获取sqlId
            String id = e.attributeValue("id");
            System.out.println(id);
            //获取resultMap
            String resultMap = e.attributeValue("resultMap");
            System.out.println(resultMap);
            //获取标签中的sql语句 并且去掉前后空格
            String sql = e.getTextTrim();
            System.out.println(sql);
            //insert into t_car(id, car_num, brand, guide_price, produce_time, car_type) values (null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})
            //insert into t_car values(?,?,?,?)
            //将所有占位符转换为?
            String newSql = sql.replaceAll("#\\{[a-zA-Z0-9_$]*}", "?");
            System.out.println(newSql);

        });
    }

    @Test
    public void testParseMybatisConfig() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        Document document = saxReader.read(is);
        String xpath = "/configuration/environments";
        //Element是Node的子类
        Element node = (Element) document.selectSingleNode(xpath);
        String aDefault = node.attributeValue("default");
        xpath = "/configuration/environments/environment[@id='" + aDefault + "']";
        Element environment = (Element) document.selectSingleNode(xpath);
        System.out.println(xpath);
        System.out.println(environment);
        Element transactionManager = environment.element("transactionManager");
        System.out.println(transactionManager);
        String type = transactionManager.attributeValue("type");
        System.out.println(type);

        Element dataSource = environment.element("dataSource");
        String type1 = dataSource.attributeValue("type");
        System.out.println(type1);
        List<Element> elements = dataSource.elements();
        elements.forEach(element -> {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            System.out.println(name + "=" + value);

        });
        xpath = "//mapper";
        List<Node> mappers = document.selectNodes(xpath);
        mappers.forEach(mapper -> {
            Element element = (Element) mapper;
            String resource = element.attributeValue("resource");
            System.out.println(resource);
        });


    }
}
