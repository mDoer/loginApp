package com.example.model.ajax;

import com.example.jsonview.Views;
import com.example.model.Role;
import com.example.model.ajax.AjaxResponseBody;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class RoleAjaxResponseBody implements AjaxResponseBody<Role> {
    @JsonView(Views.Public.class)
    private String msg;
    @JsonView(Views.Public.class)
    private List<Role> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Role> getResult() {
        return result;
    }

    public void setResult(List<Role> result) {
        this.result = result;
    }
}
