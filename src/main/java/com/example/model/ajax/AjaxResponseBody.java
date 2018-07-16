package com.example.model.ajax;

import java.util.List;

public interface AjaxResponseBody<T> {

    public String getMsg() ;
    public void setMsg(String msg);

    public List<T> getResult();
    public void setResult(List<T> result) ;


}
