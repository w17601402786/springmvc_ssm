package com.management.tools;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ApiCollection<T> {

    @ApiModelProperty(value = "数据集合",name = "data",dataType = "array",example = "200")
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
