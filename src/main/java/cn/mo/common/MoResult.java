package cn.mo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * desc:
 * @author: mozhihang
 * @date: 2020/3/11 23:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public static MoResult succeed(){
        return new MoResult(200, "ok", null);
    }

    public static MoResult fail(){
        return new MoResult(400, "error", null);
    }

    public MoResult(T data){
        this(200, "ok", data);
    }

}
