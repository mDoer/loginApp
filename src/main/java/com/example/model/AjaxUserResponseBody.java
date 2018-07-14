package com.example.model;


import com.example.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class AjaxUserResponseBody {

    @JsonView(Views.Public.class)
    private String msg;
    @JsonView(Views.Public.class)
    private List<User> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }
}
