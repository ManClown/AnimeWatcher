
function login() {

    var username = document.getElementById("username");
    var pass = document.getElementById("password");

    if (username.value == "") {

        alert("请输入用户名");

    } else if (pass.value == "") {

        alert("请输入密码");

    } else  {
        //请求到登录操作
        window.location.href = "LoginAction";

    }

}