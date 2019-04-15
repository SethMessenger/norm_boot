package com.seth.norm.cms.bean.common;

import com.seth.norm.cms.common.ErrorCodeEnum;

/**
 * @author  xunbo.xu
 * @desc    用于封装API响应对象
 * @date 18/7/10
 */
public class ObjectView<T> extends BaseView{

    public ObjectView(ErrorCodeEnum code) {
        super(code);
    }

    public ObjectView(T data){
        super(ErrorCodeEnum.SUCCESS);
        this.data = data;
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
