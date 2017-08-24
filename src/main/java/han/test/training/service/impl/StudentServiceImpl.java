package han.test.training.service.impl;

import han.test.training.dal.dao.StudentDao;
import han.test.training.service.dto.StudentDto;
import han.test.training.dal.entity.Student;
import han.test.training.service.service.StudentService;
import han.test.training.util.GsonUtil;
import han.test.training.util.ModelMapperUtil;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao _IStudentDao;

    private final static Logger logger = Logger.getLogger(StudentServiceImpl.class);

    public void addStudent(StudentDto studentDto) throws Exception {
        try{
            logger.info("Method:addStudent|studentDto:" + GsonUtil.getGsonInstance().toJson(studentDto));
            ModelMapper modelMapper = ModelMapperUtil.getModelMapperInstance();
            Student student = modelMapper.map(studentDto, Student.class);
            _IStudentDao.insert(student);
        }catch(Exception exp){
            logger.error("Method:addStudent|" +  exp.getMessage());
            throw exp;
        }
    }

    public void modifyStudent(StudentDto studentDto) throws Exception {
        try{
            ModelMapper modelMapper = ModelMapperUtil.getModelMapperInstance();
            Student student = modelMapper.map(studentDto, Student.class);
            _IStudentDao.update(student);
        }catch(Exception exp){
            //TUDO:加日志
            throw exp;
        }
    }

    public void removeStudent(String studentID) throws Exception {
        try{
            _IStudentDao.delete(studentID);
        }catch(Exception exp){
            //TUDO:加日志
            throw exp;
        }
    }

    public StudentDto getStudentByKey(String studentID) throws Exception {
        try{
            Student student = _IStudentDao.selectByPrimaryKey(studentID);
            ModelMapper modelMapper = ModelMapperUtil.getModelMapperInstance();
            return modelMapper.map(student,StudentDto.class);
        }catch(Exception exp){
            //TUDO:加日志
            throw exp;
        }
    }

    public StudentDto querySingle(HashMap<String,Object> param) throws Exception {
        try{
            Student student = _IStudentDao.querySingle(param);
            ModelMapper modelMapper = ModelMapperUtil.getModelMapperInstance();
            return modelMapper.map(student,StudentDto.class);
        }catch(Exception exp){
            //TUDO:加日志
            throw exp;
        }
    }

    public int queryCount(HashMap<String,Object> param) throws Exception {
        try{
            return  _IStudentDao.queryCount(param);
        }catch(Exception exp){
            //TUDO:加日志
            throw exp;
        }
    }

    public List<StudentDto> queryList(HashMap<String,Object> param) throws Exception {
        try{
            List<Student> list = _IStudentDao.queryList(param);
            List<StudentDto> resultList = new ArrayList<StudentDto>();
            ModelMapper modelMapper = ModelMapperUtil.getModelMapperInstance();
            for (Student s:list) {
                resultList.add(modelMapper.map(s,StudentDto.class));
            }
            return resultList;
        }catch(Exception exp){
            //TUDO:加日志
            throw exp;
        }
    }

}
