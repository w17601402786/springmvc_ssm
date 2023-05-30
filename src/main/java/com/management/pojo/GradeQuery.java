package com.management.pojo;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "成绩信息查询方法", description = "封装成绩查询所需的成绩信息和最大最小值信息")
public class GradeQuery {

    @Schema(title = "成绩信息", description = "成绩")
    Grade grade;

    @Schema(title = "最小成绩", description = "最小成绩")
    Integer min;

    @Schema(title = "最大成绩", description = "最大成绩")
    Integer max;


    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
