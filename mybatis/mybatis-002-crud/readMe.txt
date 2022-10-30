使用mybatis完成CRUD
    1．什么是CRUD
    C: create增
    R: Retrieve查（检索>U: Update改
    D: Delete删
2. insert
    <insert id="insertCar">
    insert into t_car(id , car_num, brand , guide_price,produce_time,car_type)values(null, '1003'，'丰田霸道'，30.0, '2000-10-11'，"燃油车');
    </insert>
    这样写的问题是?
    值显然是写死到配置文件中的。这个在实际开发中是不存在的。
    一定是前端的form表单提交过来数据。然后将值传给sql语句。
    例如:JDBC的代码是怎么写的?
    String sql = "insert into t_car(id,car_num , brand ,guide_price , produce_time,car_type) values(null,?,2,?,?,?)";
    ps.setString(1,xxx);
    ps.setString(2,yyy);
    ....
    在JDBC当中占位符采用的是?，在mybatis当中是什么呢?
    和?等效的写法是:#{}
    在mybatis当中不能使用?占位符，必须使用#(}来代替JDBC当中的?#(}和JDBC当中的?是等效的

    java程序中使用Map可以给SQL语句的占位符传值:
    MHashMap<String, Object> map = new HashMap<>();
             map.put("car_num", "1111");
             map.put("brand", "比亚迪汉");
             map.put("guide_price", 10.0);
             map.put("produce_time", "2022-10-30");
             map.put("car_type", "电动车");
             sqlSession.insert("insertCar", map);
    java程序中使用实体类可以给SQL语句的占位符传值:
             Car car = new Car();
             car.setCarNum("2222");
             car.setBrand("比亚迪 plus");
             car.setGuidePrice(20.0);
             car.setProduceTime("2022-10-30");
             car.setCarType("电动车");
             sqlSession.insert("insertCar", car);

    注意:#{这里写什么?写map集合的key，如果key不存在，获取的是null}
        使用map传参 参数使用map名
        insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values (null,#{car_num},#{brand},#{guide_price},#{produce_time},#{car_type})
        使用实体类传参 参数使用实体属性名
        insert into t_car(id,car_num,brand,guide_price,produce_time,car_type) values (null,#{carNum},#{brand},#{guidePrice},#{produceTime},#{carType})

    把SQL语句写成这个德行:
    insert into t_car(id, car_num, brand , guide_price, produce_time, car_type)
    values(null,#{xyz} , #{brand} , #{guidePrice},#{produceTime} , #{carType})
    出现了什么问题呢?
    There is no getter for property named 'xyz' in 'class com.wang.mybatis.pojo.Car
    mybatis去找:Car类中的getXyz()方法去了。没找到。报错了。
    怎么解决的?
    可以在Car类中提供一个getXyz()方法。这样问题就解决了。
    通过这个测试，得出一个结论:
    严格意义上来说:如果使用POJ0对象传递值的话，#这个大括号中到底写什么?
    写的是get方法的方法名去掉get，然后将剩下的单词首字母小写，然后放进去。
    例如: getUsername() -->#{username}
    例如: getEmail() --> #{email}
       也就是说mybatis在底层给?传值的时候，先要获取值
       怎么获取的?
       调用了pojo对象的get方法。例如:car.getCarNum()

