package com.management.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {


    @PreAuthorize("hasAuthority('teacher')")
    @ApiOperation("测试当前用户具有的权限")
    @RequestMapping(value = "/auth")
    public Map<String,Object> auth(Principal principal){


        System.out.println(principal.getName());


        System.out.println(SecurityContextHolder.getContext());


        Map<String,Object> resultMap = new HashMap<>();

        // 获取当前用户所具有的所有权限
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        // 判断当前用户是否拥有某些权限
        for (GrantedAuthority authority : authorities) {
            resultMap.put(authority.getAuthority(),true);
        }

        //返回json对象
        resultMap.put("code",200);

        return resultMap;

    }

}
