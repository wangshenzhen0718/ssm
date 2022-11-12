mybatis小技巧
1．#{}和${}的区别

#{}
[main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@5a2d131d]
[main] DEBUG com.wang.mybatis.mapper.CarMapper.getCarByType - ==>  Preparing: select * from t_car where car_type = ?
[main] DEBUG com.wang.mybatis.mapper.CarMapper.getCarByType - ==> Parameters: 电动车(String)
[main] DEBUG com.wang.mybatis.mapper.CarMapper.getCarByType - <==      Total: 2


${}

[main] DEBUG com.wang.mybatis.mapper.CarMapper.getCarByType - ==>  Preparing: select * from t_car where car_type = 电动车
[main] DEBUG com.wang.mybatis.mapper.CarMapper.getCarByType - ==> Parameters:

org.apache.ibatis.exceptions.PersistenceException:
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column '电动车' in 'where clause'
### The error may exist in CarMapper.xml
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select *         from t_car         where car_type = 电动车
### Cause: java.sql.SQLSyntaxErrorException: Unknown column '电动车' in 'where clause'

	at org.apache.ibatis.exceptions.ExceptionFactory.wrapException(ExceptionFactory.java:30)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:153)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:145)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:140)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:147)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:80)
	at org.apache.ibatis.binding.MapperProxy$PlainMethodInvoker.invoke(MapperProxy.java:145)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:86)
	at jdk.proxy2/jdk.proxy2.$Proxy8.getCarByType(Unknown Source)
	at com.wang.mybatis.test.CarMapperTest.testSelectByType(CarMapperTest.java:14)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:59)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:56)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
	at org.junit.runners.BlockJUnit4ClassRunner$1.evaluate(BlockJUnit4ClassRunner.java:100)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:366)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:103)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:63)
	at org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)
	at org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)
	at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:413)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:69)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater$1.execute(IdeaTestRunner.java:38)
	at com.intellij.rt.execution.junit.TestsRepeater.repeat(TestsRepeater.java:11)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:35)
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:235)
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:54)
    拼接查询
    List<Car> cars = carMapper.getCarByType("'电动车' or id=1");
    结果：
        [main] DEBUG com.wang.mybatis.mapper.CarMapper.getCarByType - ==>  Preparing: select * from t_car where car_type = '电动车' or id=1
        [main] DEBUG com.wang.mybatis.mapper.CarMapper.getCarByType - ==> Parameters:
        [main] DEBUG com.wang.mybatis.mapper.CarMapper.getCarByType - <==      Total: 3
        Car(id=1, carNum=1001, brand=宝马520Li, guidePrice=10.0, produceTime=2020-10-11, carType=燃油车)
        Car(id=27, carNum=1111, brand=比亚迪汉, guidePrice=10.0, produceTime=2022-10-30, carType=电动车)
        Car(id=28, carNum=1000, brand=比亚迪 plus, guidePrice=20.0, produceTime=2022-10-31, carType=电动车)


    #{}和${}的区别
        #{}:底层使用PreparedStatement。特点:先进行SQL语句的编译，然后给SQL语句的占位符问号?传值。可以避免SQL注入的风险。
        ${}:底层使用Statement。特点:先进行SQL语句的拼接，然后再对SQL语句进行编译。存在SQL注入的风险。



    如果需要SQL语句的关键字放到SQL语句中，只能使用$争，因为#{}是以值的形式放到SQL语句当中的。
        #{}:
        [main] DEBUG c.wang.mybatis.mapper.CarMapper.getAllByAscOrDesc - ==>  Preparing: select * from t_car order by produce_time ?
        [main] DEBUG c.wang.mybatis.mapper.CarMapper.getAllByAscOrDesc - ==> Parameters: asc(String)

        ${}:
        [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@39a2bb97]
        [main] DEBUG c.wang.mybatis.mapper.CarMapper.getAllByAscOrDesc - ==>  Preparing: select * from t_car order by produce_time asc
        [main] DEBUG c.wang.mybatis.mapper.CarMapper.getAllByAscOrDesc - ==> Parameters:
        [main] DEBUG c.wang.mybatis.mapper.CarMapper.getAllByAscOrDesc - <==      Total: 5
        Car(id=1, carNum=1001, brand=宝马520Li, guidePrice=10.0, produceTime=2020-10-11, carType=燃油车)
        Car(id=2, carNum=1002, brand=奔驰E00L, guidePrice=55.0, produceTime=2020-10-11, carType=新能源)
        Car(id=27, carNum=1111, brand=比亚迪汉, guidePrice=10.0, produceTime=2022-10-30, carType=电动车)
        Car(id=28, carNum=1000, brand=比亚迪 plus, guidePrice=20.0, produceTime=2022-10-31, carType=电动车)
        Car(id=30, carNum=100, brand=红旗111, guidePrice=100.0, produceTime=2022-10-31, carType=混合动力)

2．向SQL语句当中拼接表名，就需要使用${}
        现实业务当中，可能会存在分表存储数据的情况。因为一张表存的话，数据量太大。查询效率比较低。可以将这些数据有规律的分表存储，这样在查询的时候效率就比较高。因为扫描的数据量变少了。
        日志表:专门存储日志信息的。如果t_log只有一张表，这张表中每一天都会产生很多log，慢慢的，这个表中数据会很多。怎么解决问题?
        可以每天生成一个新表。每张表以当天日期作为名称，例如:
        t_log_20220901
        t_log_20220902
        你想知道某一天的日志信息怎么办?
        假设今天是20220901，那么直接查:t_log_20220901的表即可。
    如：
        select * from t_log_${date}
