<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>norm+ 后台主题UI框架 - 登录</title>
    <meta name="keywords" content="norm+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="norm+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <script src="js/jquery.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet">
    <link href="css/login.min.css" rel="stylesheet">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>[ norm+ ]</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>norm+ 后台主题UI框架</strong></h4>
                    <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一 轻量级，一个项目，多种功能，最大限度集成微信发布的公开内容</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二 更新及时，依赖微信及时更新最新功能管理</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三 提供滚动导航栏，顶部固定导航栏，盒式布局，滚动页脚，固定页脚等等布局</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四 基础表格, DataTables, jqGrid, FooTables, bootstrap tables等表单组件</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五 支持ECharts,Flot,Morris.js,Rickshaw,Peity,Spartline,图标组合等等统计支持</li>
                    </ul>
                    <#--<strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>-->
                </div>
            </div>
            <div class="col-sm-5">
                <form action="">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录到norm+后台主题UI框架</p>
                    <input id="loginname" type="text" class="form-control uname" placeholder="用户名" />
                    <input id="loginpwd" type="password" class="form-control pword m-b" placeholder="密码" />
                    <a href="">忘记密码了？</a>
                    <button class="btn btn-success btn-block" href="javascript:void(0)" onclick="login()">登录</button>

                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2018 All Rights Reserved. norm+
            </div>
        </div>
    </div>
</body>

    <script type="text/javascript">
        function login() {
            var loginname = $("#loginname").val();
            var loginpwd = $("#loginpwd").val();
            $.ajax({
                url : "/login.json?userName=" + loginname + "&password=" + loginpwd,
                async : true,
                type : "get",
                // 成功后开启模态框
                success : function(data){
                    if(null != data && data.error == 0){
                        $.href="/freemarker?path=index"
                    }else {
                        $.href="/freemarker?path=index"
                    }
                },
                error : function() {
                    alert("请检查您的网络");
                }
            });
        }
    </script>

</html>