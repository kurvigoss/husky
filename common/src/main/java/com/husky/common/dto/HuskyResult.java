package com.husky.common.dto;

import com.husky.common.enums.SysExceptionEnum;
import com.husky.common.exception.HuskyException;
import com.husky.common.exception.IExceptionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by gexiaobing on 2019-04-19
 *
 * @description 统一返回对象
 */
@ApiModel("统一返回对象")
public class HuskyResult<T> implements Serializable {

    /**
     * 是否成功
     */
    @ApiModelProperty(value = "是否成功",example = "true")
    private boolean success;

    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码",example = "000")
    private String code;

    /**
     * 信息
     */
    @ApiModelProperty(value = "信息",example = "成功了")
    private String message;

    /**
     * 数据
     */
    @ApiModelProperty("数据")
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 组装数据获取成功结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> HuskyResult<T> doSuccess(T data){
        HuskyResult<T> huskyResult = new HuskyResult<>();
        huskyResult.setSuccess(true);
        huskyResult.setData(data);
        huskyResult.setCode("000");
        huskyResult.setMessage("成功了");
        return huskyResult;
    }

    /**
     * 获取成功结果
     * @return
     */
    public static HuskyResult doSuccess(){
        return doSuccess(null);
    }

    /**
     * 根据异常枚举获取错误结果
     * @param exceptionEnum
     * @return
     */
    public static HuskyResult doError(IExceptionEnum exceptionEnum){
        return doError(exceptionEnum.get());
    }

    /**
     * 根据异常获取错误结果
     * @param huskyException
     * @return
     */
    public static HuskyResult doError(HuskyException huskyException){
        HuskyResult huskyResult = new HuskyResult();
        huskyResult.setSuccess(false);
        huskyResult.setCode(huskyException.getCode());
        huskyResult.setMessage(huskyException.getMessage());
        return huskyResult;
    }

    /**
     * 获取错误结果
     * @return
     */
    public static HuskyResult doError(){
        return doError(SysExceptionEnum.UNKNOW_ERROR);
    }
}
