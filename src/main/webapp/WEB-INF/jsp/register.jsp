<%--
  Created by IntelliJ IDEA.
  User: 张斌伟
  Date: 2019/4/6
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>AnimeWatcher</title>
    <style type="text/css">
        body,input{
            margin: 0;
            padding: 0;
            background: #555555;
        }
        input{
            display: inline-block;
            background: #fff;
        }
        .xiao-container{
            width: 100%;
        }
        .xiao-register-box{
            position: relative;
            height: 800px;
            width: 800px;
            top: 50px;
            margin: 0 auto;
            z-index: 99999;
            background:#ffffff;
            border: 7px solid #ccc;
        }
        .xiao-title-box{
            position: absolute;
            width: 300px;
            height: 50px;
            margin-left: 250px;
            margin-top: 5px;
            text-align: center;
            font-size: 28px;
            font-weight: 800;
            color: #ff5000;
            line-height: 50px;
        }
        .xiao-username-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:100px;
            margin-left:80px;
            font-weight: 700;
        }
        .xiao-username-input{
            display: inline-block;
            margin-left: 63px;
            /*background: green;*/
        }
        #username{
            height: 35px;
            width: 290px;
            border: 2px solid #ccc;
            border-radius: 5px;
        }
        .xiao-userPassword-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:180px;
            margin-left:80px;
            font-weight: 700;
        }
        .xiao-userPassword-input{
            display: inline-block;
            margin-left: 61px;
        }
        #userPassword{
            height: 35px;
            width: 290px;
            border: 2px solid #ccc;
            border-radius: 5px;
        }
        .xiao-userRePassword-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:260px;
            margin-left:80px;
            font-weight: 700;
        }
        .xiao-userRePassword-input{
            display: inline-block;
            margin-left: 28px;
        }
        #userRePassword{
            height: 35px;
            width: 290px;
            border: 2px solid #ccc;
            border-radius: 5px;
        }

        .xiao-userEmail-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:340px;
            margin-left:80px;
            font-weight: 700;
        }
        .xiao-userEmail-input{
            display: inline-block;
            margin-left: 61px;
        }
        #userEmail{
            height: 35px;
            width: 290px;
            border: 2px solid #ccc;
            border-radius: 5px;
        }

        .xiao-userGender-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:500px;
            margin-left:82px;
            font-weight: 700;
        }
        .xiao-userGender-input{
            display: inline-block;
            margin-left: 62px;
        }
        .xiao-require{
            color: red;
        }
        .xiao-submit-box{
            position:absolute;
            width: 80px;
            height: 40px;
            line-height: 40px;
            margin-top: 580px;
            margin-left:200px;
            border-radius: 5px;
            background: grey;
        }
        #xiao-submit-button{
            display: inline-block;
            width: 80px;
            height: 40px;
            border-radius: 5px;
            background: red;
        }
        .xiao-goLogin-box{
            position:absolute;
            width: 150px;
            height: 20px;
            margin-top: 600px;
            margin-left:320px;

        }

    </style>
</head>
<body>
<div class="xiao-container">
    <div class="xiao-register-box">
        <div class="xiao-title-box">
            <span>用户注册</span>
        </div>
        <form action="<%=basePath%>AddUserAction" method="post" onsubmit="return judge();">

            <div class="xiao-userEmail-box">
                <span class="xiao-require">*</span>
                <label for="userEmail">邮箱</label>
                <div class="xiao-userEmail-input">
                    <input type="text" id="userEmail" name="user.username" placeholder="请输入您的邮箱（账号），如：123@qq.com" />
                </div>
            </div>

            <div class="xiao-username-box">
                <span class="xiao-require">&nbsp</span>
                <label for="username">昵称</label>
                <div class="xiao-username-input">
                    <input type="text" id="username" name="user.nickname" placeholder="请输入用户昵称" />
                </div>
            </div>

            <div class="xiao-userPassword-box">
                <span class="xiao-require">*</span>
                <label for="userPassword">密码</label>
                <div class="xiao-userPassword-input">
                    <input type="password" id="userPassword" name="user.password" placeholder="请输入密码 长度:6-12个字符" />
                </div>
            </div>

            <div class="xiao-userRePassword-box">
                <span class="xiao-require">*</span>
                <label for="userRePassword">确认密码</label>
                <div class="xiao-userRePassword-input">
                    <input type="password" id="userRePassword"  placeholder="请重复输入密码" />
                </div>
            </div>

            <div class="xiao-submit-box">
                <input id = "xiao-submit-button" type="submit" value="注册" />
            </div>

            <div class="xiao-goLogin-box">
                <a href="login" style="text-decoration: none;">已有账号？去登录</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="js/register.js"></script>
<script>
    function judge(){
        var userEmail = document.getElementById("userEmail");
        if(userEmail == null || userEmail.value == ""){
            alert("邮箱号不能为空!");
            return false;
        }
        var reg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+.com$/;
        if(!reg.test(userEmail.value)){
            alert("邮箱格式不对!");
            return false;
        }
        var userPassword = document.getElementById("userPassword");
        if(userPassword == null || userPassword.value == ""){
            alert("密码不能为空!");
            //console.info(document.getElementById("userPassword"));
            return false;
        }
        var userRePassword = document.getElementById("userRePassword");
        if(userRePassword == null || userRePassword.value == ""){
            alert("密码确认不能为空!");
            return false;
        }
        if(userPassword.value != userRePassword.value){
            alert("密码不一致");
            return false;
        }
        return true;
    }
</script>
