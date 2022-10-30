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

    insert into t_car(id,car_num,brand,guide_price,produce_time,car_type)
            values (null,#{car_num},#{brand},#{guide_price},#{produce_time},#{car_type})

    注意:#{这里写什么?写map集合的key，如果key不存在，获取的是null}


