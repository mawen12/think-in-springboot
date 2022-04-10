package com.mawen.demo.mapper;

import com.mawen.demo.bean.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {

    @Update("UPDATE student SET sname=#{name}, ssex=#{sex} WHERE sno = #{sno}")
    int update(Student student);

    @Delete("DELETE FROM student WHERE sno = #{sno}")
    void deleteBySno(String sno);

    @Select("SELECT * FROM student WHERE sno = #{sno}")
    @Results(id = "student", value = {
            @Result(property = "sno", column = "sno", javaType = String.class),
            @Result(property = "name", column = "sname", javaType = String.class),
            @Result(property = "sex", column = "ssex", javaType = String.class),
    })
    Student selectBySno(String sno);
}
