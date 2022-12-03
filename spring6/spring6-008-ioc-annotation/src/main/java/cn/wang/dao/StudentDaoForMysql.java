package cn.wang.dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoForMysql implements StudentDao{
    @Override
    public void deleteStudent() {
        System.out.println("mysql正在删除学生！！！");
    }
}
