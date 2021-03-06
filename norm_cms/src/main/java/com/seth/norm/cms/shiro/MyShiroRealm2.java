package com.seth.norm.cms.shiro;

import com.seth.norm.cms.common.temp.PermissionEnum;
import com.seth.norm.cms.common.temp.UserEnum;
import com.seth.norm.cms.service.PermissionService;
import com.seth.norm.cms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/12/18
 */
//@Configuration
public class MyShiroRealm2 extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public String getName() {
        return "myShiroRealm2";
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("doGetAuthenticationInfo2");
        MyUsernamePasswordToken myToken=(MyUsernamePasswordToken)token;
        //获取用户的输入的账号.
        String username = (String)myToken.getPrincipal();
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserEnum user = userService.findByUsername(username);
        System.out.println(user.toString());
        if(user==null){
            throw new UnknownAccountException();
        }

        //此处使用的是user对象，不是username
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getUserPwd(), getName());
        return authenticationInfo;
    }


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("doGetAuthorizationInfo2");
        //User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
        UserEnum user= (UserEnum) SecurityUtils.getSubject().getPrincipal();

        List<PermissionEnum> permissions = permissionService.findPermissionAndRoleNameByUserId(user.getId());
        System.out.println("permissions:"+permissions.size());
        //List<Role> roles=permissionService.findPermissionByUserId(user.getUserId());
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for(PermissionEnum permission: permissions){
            info.addStringPermission(permission.getPermistionName());
            info.addRole(permission.getPermistionName());
        }
        return info;
    }

}