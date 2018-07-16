package com.example.model.ajax;

import com.example.jsonview.Views;
import com.example.model.Privilege;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class PrivilegeAjaxResponseBody implements AjaxResponseBody<Privilege> {
    @JsonView(Views.Public.class)
    private String msg;
    @JsonView(Views.Public.class)
    private List<Privilege> result;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Privilege> getResult() {
        return result;
    }

    public void setResult(List<Privilege> result) {
        this.result = result;
    }
}
