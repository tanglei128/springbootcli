package com.tyy.springbootcli.result;

import lombok.Data;

@Data
public class ResponseResult<T> {
    private String code;
    private String msg;
    private T data;

    public ResponseResult success(T data){
        ResponseResult resp = new ResponseResult();
        resp.setCode("200");
        resp.setMsg("成功");
        resp.setData(data);
        return resp;
    }
}
