package help_sove.pojo;

import lombok.Data;

@Data
public class R<T>{

    private Integer code;// 200表示成功，400表示失败
    private String msg;// 成功或失败的提示信息
    private T data;//传递的数值

    public static <T> R<T> success(T object,String msgx,Integer codex){
        R<T> r=new R<T>();
        r.data=object;
        r.code=codex;
        r.msg=msgx;
        return r;
    }

    public static <T> R<T> success(T object){
        R<T> r=new R<T>();
        r.data=object;
        r.code=200;
        r.msg="成功";
        return r;
    }

    public static <T> R<T> error(String msg){
        R<T> r=new R<T>();
        r.msg=msg;
        r.code=200;
        return r;
    }

    public static <T> R<T> error(){
        R<T> r=new R<T>();
        r.msg="失败";
        r.code=400;
        return r;
    }
}