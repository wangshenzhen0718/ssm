package org.god.ibatis.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.god.ibatis.utils.Resources;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:wsz
 * @Date: 2022/11/2 22:49
 * @Description:sqlSessionFactory构建器对象。 通过SqlSessionFactoryBuilder build方法来解析
 * godbatis-config.xml文件，然后创SqlSessionFactory对象。
 * @Version: 1.0
 * @Since: 1.0
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactoryBuilder() {
    }

    /**
     * 解析godbatis-config.xml文件，来构建SqlSessionFactory对象。
     *
     * @param in 指向godbatis-config.xml文件的一个输入流。
     * @return sqlSessionFactory 对象。
     */
    public SqlSessionFactory build(InputStream in) {
        SqlSessionFactory sqlSessionFactory=null;

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(in);
            Element environments = (Element) document.selectSingleNode("/configuration/environments");
            String defaultId = environments.attributeValue("default");
            Element environment = (Element) document.selectSingleNode("/configuration/environments/environment[@id='"+defaultId+"']");
            Element transactionManagerElt = environment.element("transactionManager");
            Element dataSourceElt = environment.element("dataSource");
            DataSource dataSource=getDataSource(dataSourceElt);
            Transaction transaction=getTransactionManager(dataSource,transactionManagerElt);
            ArrayList<String> sqlMapperXmlPathList = new ArrayList<>();
            List<Node> nodes = document.selectNodes("//mapper");
            nodes.forEach(node ->{
                Element mapper = (Element) node;
                String resource = mapper.attributeValue("resource");
                sqlMapperXmlPathList.add(resource);
            });
            Map<String,MappedStatement> mappedStatements=getMappedStatements(sqlMapperXmlPathList);
            sqlSessionFactory = new SqlSessionFactory(transaction,mappedStatements);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

        return sqlSessionFactory;
    }

    private Map<String, MappedStatement> getMappedStatements(ArrayList<String> sqlMapperXmlPathList) {
        Map<String, MappedStatement> mappedStatements=new HashMap<>();
        sqlMapperXmlPathList.forEach(node -> {
            try {
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(Resources.getResourceAsStream(node));
                Element mapper = (Element) document.selectSingleNode("mapper");
                String namespace = mapper.attributeValue("namespace");
                List<Element> elements = mapper.elements();
                for (Element element : elements) {
                    String id = element.attributeValue("id");
                    String resultType = element.attributeValue("resultType");
                    String sqlId=namespace+"."+ id;
                    String sql=element.getTextTrim();
                    MappedStatement mappedStatement = new MappedStatement(sql, resultType);
                    mappedStatements.put(sqlId,mappedStatement);
                }

            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }

        });

        return mappedStatements;

    }

    private Transaction getTransactionManager(DataSource dataSource, Element transactionManagerElt) {
        Transaction transaction=null;
        String type = transactionManagerElt.attributeValue("type").trim().toUpperCase();
        switch (type){
            case Const.JDBC_TRANSACTION:transaction=new JdbcTransaction(dataSource,false);
                break;
            case Const.MANAGED_TRANSACTION:transaction=new ManagedTransaction();
                break;
        }
        return transaction;

    }

    private DataSource getDataSource(Element dataSourceElt) {
        HashMap<String, String> map = new HashMap<>();
        DataSource dataSource=null;
        String type = dataSourceElt.attributeValue("type").trim().toUpperCase();
        List<Element> propertyElts = dataSourceElt.elements("property");
        propertyElts.forEach(e->{
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            map.put(name,value);

        });
        switch (type){
            case Const.UN_POOLED_DATASOURCE:dataSource=new UnpooledDataSource(map.get("driver"),map.get("url"),map.get("username"),map.get("password"));
            break;
            case Const.POOLED_DATASOURCE:dataSource=new PooledDataSource();
            break;
            case Const.JNDI_DATASOURCE:dataSource=new JNDIDataSource();
            break;
        }
        return dataSource;
    }
}
