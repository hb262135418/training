package han.test.training.controller;

import han.test.training.service.dto.StudentDto;
import han.test.training.service.service.StudentService;
import han.test.training.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by han on 2017/6/8.
 */

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService _IStudentService;

    @RequestMapping(value="/studenteditview")
    public String StudentEditView(){
        return "student/studenteditview";
    }


    @RequestMapping(value="/addstudent")
    @ResponseBody
    public HashMap<String,Object> addStudent(HttpServletRequest request, HttpSession session){
        HashMap<String,Object> result = new HashMap<String,Object>();
        String message = "OK";
        try{
            String studentJson = request.getParameter("studentDtoJson");
            StudentDto studentDto = GsonUtil.getGsonInstance().fromJson(studentJson,StudentDto.class);

            if(studentDto==null){
                studentDto=new StudentDto();
                UUID uuid = UUID.randomUUID();
                studentDto.setStudentID(uuid.toString());
                studentDto.setAge(17);
                SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
                Date date=format.parse("2001-04-03");
                Date now = new Date();
                studentDto.setBirthday(date);
                studentDto.setSex("F");
                studentDto.setCreateTime(now);
                studentDto.setCreator("admin1");
                studentDto.setIsDel("F");
                studentDto.setModifier("admin1");
                studentDto.setModifyTime(now);
                studentDto.setStuName("韩贝");
            }else{
                Date now = new Date();
                studentDto.setCreateTime(now);
                studentDto.setCreator("admin");
                studentDto.setIsDel("F");
                studentDto.setModifier("admin");
                studentDto.setModifyTime(now);
            }

            _IStudentService.addStudent(studentDto);
        }catch(Exception exp){
            message = exp.getMessage();
        }
        result.put("message",message);
        return result;
    }

    @RequestMapping(value="/modifystudent")
    @ResponseBody
    public HashMap<String,Object> modifyStudent(HttpServletRequest request, HttpSession session){
        HashMap<String,Object> result = new HashMap<String,Object>();
        String message = "OK";
        try{
            StudentDto dto = new StudentDto();
            dto.setStudentID("dfge234f");
            dto.setAge(10);
            SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
            Date date=format.parse("2001-04-03");
            dto.setBirthday(date);
            dto.setSex("F");
            dto.setStuName("韩贝");
            _IStudentService.modifyStudent(dto);
        }catch(Exception exp){
            message = exp.getMessage();
        }
        result.put("message",message);
        return result;
    }
    @RequestMapping(value="/removestudent")
    @ResponseBody
    public HashMap<String,Object> removeStudent(HttpServletRequest request, HttpSession session){
        HashMap<String,Object> result = new HashMap<String,Object>();
        String message = "OK";
        try{
            String studnetID = "ertsbvb";
            _IStudentService.removeStudent(studnetID);
        }catch(Exception exp){
            message = exp.getMessage();
        }
        result.put("message",message);
        return result;
    }


    @RequestMapping(value="/tests")
    @ResponseBody
    public HashMap<String,Object> tests(HttpServletRequest request, HttpSession session){
        HashMap<String,Object> result = new HashMap<String,Object>();
        String message = "OK";
        try{
            String studentid = "sdfasdfawer";
            StudentDto studentDto = _IStudentService.getStudentByKey(studentid);

            HashMap<String,Object> param = new HashMap<String,Object>();
            param.put("StuName","韩贝");
            StudentDto studentDto1 = _IStudentService.querySingle(param);


            HashMap<String,Object> param1 = new HashMap<String,Object>();
            param1.put("StuName","han1");
            param1.put("Age","18");
            List<StudentDto> list = _IStudentService.queryList(param1);




            String a = "sdf";
        }catch(Exception exp){
            message = exp.getMessage();
        }
        result.put("message",message);
        return result;
    }
}
