package com.management.service.impl;

import com.management.mapper.ClassesMapper;
import com.management.service.ClassesService;
import com.management.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClassInfoImpl implements ClassesService {


    @Autowired
    ClassesMapper classesMapper;

    @Override
    public int addClasses(Classes classes, String userType) {

        if (!userType.equals("admin")) {
            return 0;
        }

        classesMapper.addClasses(classes);

        return 1;

    }

    @Override
    public int updateClasses(Classes classes, String userType) {
        classesMapper.updateClasses(classes);
        return 0;
    }

    @Override
    public int deleteClassesById(Integer classId, String userType) {

        classesMapper.deleteClasses(classId);
        return 0;
    }

    @Override
    public List<Classes> getClasses(Classes classes) {
        return classesMapper.getClasses(classes);
    }
}
