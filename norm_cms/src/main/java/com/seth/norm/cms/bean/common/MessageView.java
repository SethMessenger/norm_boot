package com.seth.norm.cms.bean.common;


import com.seth.norm.cms.common.ErrorCodeEnum;

/**
 * @author  xunbo.xu
 * @desc    用于封装简易的消息响应
 * @date 18/8/15
 */
public class MessageView extends BaseView{

    private String msg;

    public MessageView(ErrorCodeEnum code, String msg) {
        super(code);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
