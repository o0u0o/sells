package com.o0u0o.sell.vo;

import com.o0u0o.sell.enums.ResponseEnum;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author aiuiot
 * @Date 2020/2/5 4:58 下午
 * @Descripton: http请求返回对象
 **/
@Data
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
        return new ResultVo(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
    }

    public static <T> ResultVo<T> success(String msg){
        return new ResultVo<>(ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static <T> ResultVo success(T data){
        return new ResultVo(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), data);
    }

    public static ResultVo error(){
        return new ResultVo(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
    }

}
