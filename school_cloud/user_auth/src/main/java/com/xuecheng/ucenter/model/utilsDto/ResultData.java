package com.xuecheng.ucenter.model.utilsDto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * @Classname ResultData
 * @Description TODO
 * @Date 2023/4/6 9:40
 * @Created by wang
 */
@Data
@Getter
@ToString
public class ResultData {

    String code;
    String msg;
    Object data;
    public ResultData(){

    }
    public ResultData(String code , String msg , Object date){
        this.code = code;
        this.msg = msg;
        this.data = date;
    }
    public static ResultData success(){
        return new ResultData(Constants.CODE_200,"",null);
    }
    /*
       返回一个200状态码,并且携带参数,无返回信息
    */
    public static ResultData success(Object data){
        return new ResultData(Constants.CODE_200,"",data);
    }
    /*
       返回一个固定带有500状态码的错误信息
    */
    public static ResultData error(){
        return new ResultData(Constants.CODE_500,"业务异常",null);
    }
    /*
       返回一个自定义返回状态码以及错误信息
    */
    public static ResultData error(String code, String msg){
        return new ResultData(code,msg,null);
    }
}
