package org.java.dao;

import org.java.entity.Find;
import org.java.uitl.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.Serializable;
import java.util.List;

public class AjaxDao implements Serializable {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtil.getDataSource());
    public List<Find> getList(String name){
      //通过拼接名字来查找

        String sql = "select * from find where name like '%"+name+"%'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Find>(Find.class));
    }
}
