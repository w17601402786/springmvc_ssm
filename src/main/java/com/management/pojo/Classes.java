package com.management.pojo;

public class Classes {
    private Integer id;
    private String name;
    private String major;

    /**
     * 班级人数
     */
    private Integer num;
    private Integer year;
    private String counsellor;

    /**
     * 班级编号
     */
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