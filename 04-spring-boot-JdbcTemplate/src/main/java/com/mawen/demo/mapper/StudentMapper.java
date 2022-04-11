package com.mawen.demo.mapper;

import com.mawen.demo.bean.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setSno(rs.getString("SNO"));
        student.setName(rs.getString("SNAME"));
        student.setSex(rs.getInt("SSEX"));
        return student;
    }
}
