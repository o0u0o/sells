package com.o0u0o.sell.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.o0u0o.sell.enums.ResultEnum;
import lombok.Data;

/**
 * @Author aiuiot
 * @Date 2020/2/5 4:58 下午
 * @Descripton: http请求返回对象
 * 使用 @JsonInclude(JsonInclude.Include.NON_NULL) 注解
 *  结果为 null的字段 则不返回给前端
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVo<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体数据. */
    private T data;

    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultVo success(){
        return new ResultVo(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
    }

    public static <T> ResultVo<T> success(String msg){
        return new ResultVo<>(ResultEnum.SUCCESS.getCode(), msg);
    }

    public static <T> ResultVo success(T data){
        return new ResultVo(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static ResultVo error(){
        return new ResultVo(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage());
    }

}
