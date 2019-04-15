package com.seth.norm.cms.bean;


import com.seth.norm.cms.bean.common.BaseView;
import com.seth.norm.cms.common.ErrorCodeEnum;
import com.seth.norm.cms.utils.DateUtil;
import java.util.Date;

/**
 * @author  xunbo.xu
 * @desc    应用部署信息
 * @date 18/9/18
 */
public class DeployView extends BaseView {

    public DeployView(String version, Date date) {
        super(ErrorCodeEnum.SUCCESS);
        this.version = version;
        this.lastTime = DateUtil.COMMON_FULL.getDateText(date);
    }

    private String lastTime;
    private String version;

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
