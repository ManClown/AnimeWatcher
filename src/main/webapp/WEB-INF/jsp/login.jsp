<%--
  Created by IntelliJ IDEA.
  User: 张斌伟
  Date: 2019/4/6
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AnimeWatcher</title>

    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css"/>
    <script type="text/javascript" src="<%=basePath%>js/login.js"></script>
</head>

<body>
<div id="login_frame">

    <form method="post" action="<%=basePath%>LoginAction">

        <p><label class="label_input">用户名</label><input type="text" name="username" class="text_field" placeholder="输入邮箱号"/></p>
        <p><label class="label_input">密码</label><input type="password" name="password" class="text_field" placeholder="输入密码"/></p>

        <div id="login_control">
            <input type="submit" id="btn_login" value="登录"/> <!--请求loginAction.action-->
            <a id="btn_register" href="<%=basePath%>register">注册</a><!--需要转向注册界面-->

        </div>
    </form>
</div>

</body>

</html>
