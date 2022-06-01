package com.mawen.demo.dao.impl;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import com.mawen.demo.bean.Student;
import com.mawen.demo.dao.StudentDao;
import com.mawen.demo.mapper.StudentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Student student) {
        String sql = "INSERT INTO STUDENT(sno, sname, ssex) VALUES(:sno, :name, :sex)";
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        return npjt.update(sql, new BeanPropertySqlParameterSource(student));
    }

    @Override
    public int update(Student student) {
        String sql = "UPDATE STUDENT SET sname = ?, ssex = ? WHERE sno = ?";
        Object[] args = {student.getName(), student.getSex(), student.getSno()};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public int deleteBySno(String sno) {
        String sql = "DELETE FROM STUDENT WHERE sno = ?";
        Object[] args = {sno};
        int[] argTypes = {Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public List<Map<String, Object>> queryStudentsListMap() {
        String sql = "SELECT * FROM STUDENT";
        return this.jdbcTemplate.queryForList(sql);
    }

    @Override
    public Student queryBySno(String sno) {
        String sql = "SELECT * FROM STUDENT WHERE sno = ?";
        Object[] args = {sno};
        int[] argTypes = {Types.VARCHAR};
        List<Student> studentList = this.jdbcTemplate.query(sql, args, argTypes, new StudentMapper());
        if (studentList != null && studentList.size() > 0) {
            return studentList.get(0);
        } else {
            return null;
        }
    }
}
