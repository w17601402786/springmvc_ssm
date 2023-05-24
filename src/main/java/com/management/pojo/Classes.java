package com.management.pojo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "班级信息", description = "班级信息")
public class Classes {
    @Schema(title = "班级ID", description = "班级ID")
    private Integer id;

    @Schema(title = "班级名", description = "班级名")
    private String name;

    @Schema(title = "专业", description = "专业")
    private String major;

    @Schema(title = "班级人数", description = "班级人数")
    private Integer num;

    @Schema(title = "入学年份", description = "入学年份")
    private Integer year;

    @Schema(title = "辅导员", description = "辅导员")
    private String counsellor;

    @Schema(title = "班级编号", description = "班级编号")
    private String classId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCounsellor() {
        return counsellor;
    }

    public void setCounsellor(String counsellor) {
        this.counsellor = counsellor;
    }


    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", num=" + num +
                ", year=" + year +
                ", counsellor='" + counsellor + '\'' +
                ", classId='" + classId + '\'' +
                '}';
    }
}
