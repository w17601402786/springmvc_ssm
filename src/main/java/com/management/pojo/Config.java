package com.management.pojo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Schema(title = "系统配置信息", description = "配置信息")
public class Config {

    @Schema(title = "当前学年",description = "当前学年")
    int year;

    @Schema(title = "当前学期",description = "当前学期")
    int term;

    @Schema(title = "当前周数",description = "当前周数")
    int week;

    @Schema(title = "本学期开学日期",description = "用于计算周数")
    LocalDate fromDay;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public LocalDate getFromDay() {
        return fromDay;
    }

    public void setFromDay(LocalDate fromDay) {
        this.fromDay = fromDay;
        // 计算当前周数
        LocalDate today = LocalDate.now();
        long days = ChronoUnit.DAYS.between(fromDay, today);
        setWeek((int) (days / 7) + 1);

    }
}
