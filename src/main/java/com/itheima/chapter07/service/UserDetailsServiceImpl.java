package com.itheima.chapter07.service;


import com.itheima.chapter07.dao.UserDao;
import com.itheima.chapter07.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserDao userDao;

    //根据 账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //将来连接数据库根据账号查询用户信息
        UserDto userDto = userDao.getUserByUsername(username);
        if(userDto == null){
            //如果用户查不到，返回null，会抛出异常
            return null;
        }
        //根据用户的id查询用户的权限
        List<String> privileges = userDao.findPrivilegesByUserId(userDto.getId());
        //将privileges转成数组
        String[] privilegeArray = new String[privileges.size()];
        privileges.toArray(privilegeArray);
        UserDetails userDetails = User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities(privilegeArray).build();
        return userDetails;
    }
}
