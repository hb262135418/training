package han.test.training.service.dto;

import java.util.Date;

public class StudentDto {
    //Student 数据传输模型
    private String StudentID;
    private String StuName;
    private int Age;
    private String Sex;
    private Date Birthday;

    private Date CreateTime;
    private String Creator;
    private Date ModifyTime;
    private String Modifier;
    private String IsDel;

    public String getStudentID() {
        return StudentID;
    }
    public void setStudentID(String studentid) {
        this.StudentID = studentid == null ? null : studentid.trim();
    }
    public String getStuName() {
        return StuName;
    }
    public void setStuName(String stuname) {
        this.StuName = stuname;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        this.Age = age;
    }
    public String getSex() {
        return Sex;
    }
    public void setSex(String sex) {
        this.Sex = sex;
    }
    public Date getBirthday() {
        return Birthday;
    }
    public void setBirthday(Date birthday) {
        this.Birthday = birthday;
    }
    public Date getCreateTime() {
        return CreateTime;
    }
    public void setCreateTime(Date createtime) {
        this.CreateTime = createtime;
    }
    public String getCreator() {
        return Creator;
    }
    public void setCreator(String creator) {
        this.Creator = creator;
    }
    public Date getModifyTime() {
        return ModifyTime;
    }
    public void setModifyTime(Date modifytime) {
        this.ModifyTime = modifytime;
    }
    public String getModifier() {
        return Modifier;
    }
    public void setModifier(String modifier) {
        this.Modifier = modifier;
    }
    public String getIsDel() {
        return IsDel;
    }
    public void setIsDel(String isdel) {
        this.IsDel = isdel;
    }
}