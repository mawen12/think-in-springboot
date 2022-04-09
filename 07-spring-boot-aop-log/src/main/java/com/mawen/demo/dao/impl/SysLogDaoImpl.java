package com.mawen.demo.dao.impl;

import com.mawen.demo.dao.SysLogDao;
import com.mawen.demo.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SysLogDaoImpl implements SysLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveSysLog(SysLog sysLog) {
        StringBuffer sql = new StringBuffer("INSERT INTO sys_log");
        sql.append("(username,operation,time,method,params,ip,create_time) ");
        sql.append("values(:username,:operation,:time,:method,");
        sql.append(":params,:ip,:createTime)");

        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        npjt.update(sql.toString(), new BeanPropertySqlParameterSource(sysLog));
    }
}
