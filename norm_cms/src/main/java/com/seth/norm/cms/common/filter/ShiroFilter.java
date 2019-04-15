package com.seth.norm.cms.common.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author  xunbo.xu
 * @desc    shiro权限过滤器
 * @date 18/12/18
 */
public class ShiroFilter extends AccessControlFilter{

    /** 登录页 */
    static final String LOGIN_URL = "http://www.sojson.com/user/open/toLogin.shtml";
    /** 权限限制提醒页 */
    static final String UNAUTHORIZED_URL = "http://www.sojson.com/unauthorized.html";

    /**
     * 权限验证通过
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        //取到参数[2008,2009] ，强制转换判断。
        String[] arra = (String[])mappedValue;
        Subject subject = getSubject(request, response);
        for (String role : arra) {
            //判断是否有拥有当前权限，有则返回true
            if(subject.hasRole("role:" + role)){
                return true;
            }
        }
        return false;
    }

    /**
     * 权限验证失败
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            //表示没有登录，重定向到登录页面
            saveRequest(request);
            WebUtils.issueRedirect(request, response, LOGIN_URL);
        } else {
            if (StringUtils.hasText(UNAUTHORIZED_URL)) {
                //如果有未授权页面跳转过去
                WebUtils.issueRedirect(request, response, UNAUTHORIZED_URL);
            } else {//否则返回401未授权状态码
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        return false;
    }
}
