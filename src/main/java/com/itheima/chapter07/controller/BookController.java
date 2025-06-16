package com.itheima.chapter07.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("book")

public class BookController {
    @RequestMapping("list")
    public String findList() {
        return "book_list";
    }
    @RequestMapping("admin/manag")
    @Secured("ROLE_ADMIN")
    public String findManagList() {
        return "book_manag";
    }

    @RequestMapping("admin/coal")
    @Secured("ROLE_ADMIN") // 需要管理员权限
    public String findCoalList() {
        return "coal_campany"; // 对应 templates/book_coal.html
    }

    @RequestMapping("admin/record")
    @Secured("ROLE_ADMIN") // 需要管理员权限
    public String findrecordList() {
        return "transport-record"; // 对应 templates/book_coal.html
    }

    @RequestMapping("admin/fenbu")
    @Secured("ROLE_ADMIN") // 需要管理员权限
    public String coalcampanyfenbu() {
        return "coal_campany_fenbu"; // 对应 templates/book_coal.html
    }
}
