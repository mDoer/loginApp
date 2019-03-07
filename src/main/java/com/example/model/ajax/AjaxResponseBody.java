package com.example.model.ajax;

import java.util.List;

/**
 * The interface Ajax response body.
 *
 * @param <T> the type parameter
 */
public interface AjaxResponseBody<T> {

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() ;

    /**
     * Sets msg.
     *
     * @param msg the msg
     */
    public void setMsg(String msg);

    /**
     * Gets result.
     *
     * @return the result
     */
    public List<T> getResult();

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(List<T> result) ;


}
