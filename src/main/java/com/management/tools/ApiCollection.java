package com.management.tools;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class ApiCollection<T> {

    @Schema(description = "数据集合",name = "data")
    private List<T> data;

    public ApiCollection() {
    }

    public ApiCollection(List<T> data) {
        this.data = data;
    }

    public static <T> ApiCollection<T> success(List<T> data){
        return new ApiCollection<T>(data);
    }

    public static <T> ApiCollection<T> fail(List<T> data){
        return new ApiCollection<T>(data);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
