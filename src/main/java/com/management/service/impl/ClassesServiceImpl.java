package com.management.service.impl;

import com.management.mapper.ClassesMapper;
import com.management.service.ClassesService;
import com.management.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {


    @Autowired
    ClassesMapper classesMapper;

    @Override
    public int addClasses(Classes classes, String userType) {

        if (!userType.equals("admin")) {
            return 0;
        }

        return classesMapper.addClasses(classes);

    }

    @Override
    public int updateClasses(Classes classes, String userType) {

        if (!userType.equals("admin")) {
            return 0;
        }

        return classesMapper.updateClasses(classes);
    }

    @Override
    public int deleteClassesById(Integer classId, String userType) {

        if (!userType.equals("admin")) {
            return 0;
        }

        return classesMapper.deleteClasses(classId);
    }

    @Override
    public List<Classes> getClasses(Classes classes) {
        return classesMapper.getClasses(classes);
    }
}
