package com.itheima.chapter07.dao;

import com.itheima.chapter07.entity.Privilege;
import com.itheima.chapter07.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //根据账号查询用户信息
    public UserDto getUserByUsername(String username){
        String sql = "SELECT * FROM user WHERE username = ?";
        //连接数据库查询用户
        List<UserDto> list = jdbcTemplate.query(sql,  new BeanPropertyRowMapper<>(UserDto.class),username);
        if(list !=null && list.size()==1){
            return list.get(0);
        }
        return null;
    }
    //根据用户id查询用户权限
    public List<String> findPrivilegesByUserId(Integer userId){
        String sql = "SELECT u.username,p.authority " +
                "FROM user u,priv p,user_priv up " +
                "WHERE up.user_id=u.id AND up.priv_id=p.id and u.id =?";
        List<Privilege> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Privilege.class), userId);
        List<String> privileges = new ArrayList<>();
        list.forEach(p -> privileges.add(p.getAuthority()));
        return privileges;
    }
}
