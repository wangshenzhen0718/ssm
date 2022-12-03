package cn.wang.dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoForOracle implements StudentDao {
    @Override
    public void deleteStudent() {
        System.out.println("oracle正在删除学生！！！");
    }
}
