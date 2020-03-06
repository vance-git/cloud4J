package org.vance.goods.model;

public class Result {
    private int resultCode;
    private String resultMsg;
    private Object data;

    public Result(int resultCode, String resultMsg, Object data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public static Result success(String resultMsg, Object data){
        return new Result(200, resultMsg, data);
    }

    public static Result fail(int errorCode, String errorMsg){
        return new Result(errorCode, errorMsg, null);
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
