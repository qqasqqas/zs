package com.answer;

import com.answer.dao.UserMapper;
import com.answer.pojo.Person;
import com.answer.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

//    @Value("${person.name}")
//    private String name;
//    @Value("${person.age}")
//    private Integer age;

    @Autowired
    UserMapper userMapper;
    @RequestMapping("/hello")
    public String hello()
    {
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userMapper.getUserList();
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    }
}
