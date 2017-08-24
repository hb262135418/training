package han.test.training.service.service;

import han.test.training.service.dto.StudentDto;

import java.util.HashMap;
import java.util.List;


public interface StudentService {
    void addStudent(StudentDto studentDto) throws Exception;

    void modifyStudent(StudentDto studentDto) throws Exception;

    void removeStudent(String studentID) throws Exception;

    public StudentDto getStudentByKey(String studentID) throws Exception;

    public StudentDto querySingle(HashMap<String, Object> param) throws Exception;

    public int queryCount(HashMap<String, Object> param) throws Exception;

    public List<StudentDto> queryList(HashMap<String, Object> param) throws Exception;
}
