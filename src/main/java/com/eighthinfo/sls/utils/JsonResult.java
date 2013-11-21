package com.eighthinfo.sls.utils;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM4:58
 */
public class JsonResult {
    private boolean success;
    private String msg;

    public JsonResult() {
        this.success = true;
    }

    public JsonResult(String msg){
        this.success = false;
        this.msg = msg;
    }

    public JsonResult(String msg, boolean success) {
        this.msg = msg;
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
