package com.example.model.ajax;

import com.example.jsonview.Views;
import com.example.model.Privilege;
import com.example.model.Role;
import com.example.model.RolePrivilege;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class RolePrivilegeResponseBody implements AjaxResponseBody<RolePrivilege> {


        @JsonView(Views.Public.class)
        private String msg;
        @JsonView(Views.Public.class)
        private List<RolePrivilege> result;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<RolePrivilege> getResult() {
            return result;
        }

        public void setResult(List<RolePrivilege> result) {
            this.result = result;
        }
}
