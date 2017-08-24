package han.test.training.dal.dao;

import han.test.training.dal.entity.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentDao {
    void insert(Student student);

    void update(Student student);

    void delete(String studentID);

    Student selectByPrimaryKey(String studentID);

    Student querySingle(HashMap<String, Object> param);

    int queryCount(HashMap<String, Object> param);

    List<Student> queryList(HashMap<String, Object> param);

    List<Student> queryPagedList(HashMap<String, Object> param);
}