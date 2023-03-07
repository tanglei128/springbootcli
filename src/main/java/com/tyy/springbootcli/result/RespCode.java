package com.tyy.springbootcli.result;


public enum RespCode implements IErrorCode{
    SUCCESS("200", "操作成功"),
    VALIDATE_FAILED("404", "参数检验失败"),
    FAILED("500", "操作失败");
    private String code;
    private String message;

    private RespCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
