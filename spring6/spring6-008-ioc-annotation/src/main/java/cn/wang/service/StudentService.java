package cn.wang.service;

import cn.wang.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    //如果@Resource后面没有指定名字 会根据属性名注入 找不到再根据类型
    private StudentDao studentDao;
    public void deleteStudent(){
        studentDao.deleteStudent();

    }

    @Resource(name = "studentDaoForMysql")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
