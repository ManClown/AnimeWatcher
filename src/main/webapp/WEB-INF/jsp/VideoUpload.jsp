<%--
  Created by IntelliJ IDEA.
  User: 张斌伟
  Date: 2019/4/9
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AnimeWatcher</title>

    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="font/iconfont.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
</head>
<body style=" height: 100%; ">

<!-- 顶部页面 -->
<div id="header">

    <!-- 最顶部 -->
    <div class="header-top">
        <div class="auto-width">
            <h1 class="logo fl"><a href="#"><img src="images/logo.png" alt="#"></a></h1>
            <div class="search-box fl">
                <form action="#">
                    <input type="text" class="fl search-text" placeholder="Search here...">
                    <button class="fl search-btn">
                        <i class="iconfont icon-search"></i>
                    </button>
                </form>
                <div class="search-feedback">
                    <span class="search-hot">今日热搜</span>
                    <div class="search-menu">
                        <a href="#" class="item item-cur">
                            <span>1</span>
                            <em>OverWatch</em>
                        </a>
                        <a href="#" class="item item-cur">
                            <span>2</span>
                            <em>电影知道答案</em>
                        </a>
                        <a href="#" class="item item-cur">
                            <span>3</span>
                            <em>S6</em>
                        </a>
                        <a href="#" class="item">
                            <span>4</span>
                            <em>夏目友人帐</em>
                        </a>
                        <a href="#" class="item">
                            <span>5</span>
                            <em>微小而确实的幸福</em>
                        </a>
                        <a href="#" class="item">
                            <span>6</span>
                            <em>神盾局特工</em>
                        </a>
                        <a href="#" class="item">
                            <span>7</span>
                            <em>天凉好个秋</em>
                        </a>
                    </div>
                </div>
            </div>
            <ul class="header-guide fr">
                <li class="guide-item login">
                    <s:if test="%{#session.user == null}">
                        <a href="<%=basePath%>login">登录/注册</a>
                    </s:if>
                    <s:else>
                        <a href="<%=basePath%>LogoutAction"><s:property value="#session.user.nickname"/>退出</a>
                    </s:else>
                </li>
                <li class="guide-item history">
                    <a href="#">
                        <i class="iconfont icon-history"></i>
                    </a>
                </li>
                <li class="guide-item upload">
                    <a href="#">
                        <i class="iconfont icon-upload"></i>
                    </a>
                    <div class="guide-hover">
                        <ul>
                            <li><a href="<%=basePath%>VideoUpload">投视频</a></li>
                            <li><a href="<%=basePath%>VideoManager_Query">视频管理</a></li>
                        </ul>
                    </div>
                </li>

            </ul>
        </div>
    </div>

    <!-- 焦点图 -->
    <div class="header-banner">
        <a href="#" class="bg"></a>
        <span class="text">这辆车……到底能不能上啊！！！</span>
        <a href="#" class="link"></a>
    </div>
    <!-- 导航 -->


</div>

<!---------- 主体内容 ---------->
<div id="main" style="background-image: url('/AnimeWatcher/images/login/12345.jpeg'); background-repeat: no-repeat; background-size: 100% 100%;">
    <div class="auto-width clearfix">
        <section class="area clearfix area-slider" >
            <s:form action="UploadVideo" method="post" enctype="multipart/form-data">

                <div style="margin: 100px">
                    <span style="font-size: large; color: #ddeeff;">标题:</span>
                    <input type="text" id="title" name="title" style="margin-left: 50px;border: 5px solid #def; width: 280px; color: #3BD9FF"/>
                </div>
                <div style="margin: 100px">
                    <span style="font-size: large; color: #ddeeff;">封面(160*90):</span>
                    <input type="file" id="cover" name="fileUpload" style="margin-left: 100px; border: 5px solid #def"/>
                </div>
                <div style="margin: 100px">
                    <span style="font-size: large; color: #ddeeff;">类别:</span>
                    <select id="type" style="margin-left: 50px;" name="type">
                        <option value="Boold">热血</option>
                        <option value="Campus">校园</option>
                        <option value="Sports">运动</option>
                        <option value="Youth">青春</option>
                        <option value="Romantic">恋爱</option>
                        <option value="Game">竞技</option>
                        <option value="Parentkid">亲子</option>
                        <option value="Harem">后宫</option>
                        <option value="War">战争</option>
                        <option value="Magic">魔幻</option>
                        <option value="Adventure">冒险</option>
                        <option value="Resoning">推理</option>
                    </select>

                </div>
                <div style="margin: 100px">
                    <span style="font-size: large; color: #ddeeff;">视频文件:</span>
                    <!--  -->
                    <input type="file" id="video" name="fileUpload" style="margin-left: 100px;border: 5px solid #def"/>
                </div>


                <div style="margin: 100px">
                    <span style="font-size: large; color: #ddeeff;">简介:</span>
                    <textarea id="descriptor" name="introduction" cols="30" rows="10" style="margin-left: 50px; border: 5px solid #def"></textarea>
                </div>
                <input type="submit" value="上传" />
                <s:submit value="上传" style="border: 5px solid #def; width: 88px; height: 30px; color: #ddeeff; margin-left: 888px;"/>
            </s:form>
        </section>
    </div>
</div>

<!---------- 底部内容 ---------->
<div id="footer">
    <div class="container auto-width">
        <div class="footer-top clearfix">
            <div class="footer-nav fl">
                <div class="item">
                    <h4>合作</h4>
                    <p>
                        <a href="#">关于我们</a>
                        <a href="#">联系我们</a>
                        <br>
                        <a href="#">AC招聘</a>
                    </p>
                </div>
                <span class="line"></span>
                <div class="item">
                    <h4>官方</h4>
                    <p>
                        <a href="#">新浪微博</a>
                        <a href="#">官方网店</a>
                        <br>
                        <a href="#">微信公众号<img src="images/footer-arcode.jpg" class="footer-orcode" alt="#"></a>
                    </p>
                </div>
                <span class="line"></span>
                <div class="item">
                    <h4>下载</h4>
                    <p>
                        <a href="#" class="mg-0">移动客户端</a>
                        <span class="new">new</span>
                        <br>
                        <a href="#">AC娘表情包</a>
                    </p>
                </div>
                <span class="line"></span>
                <div class="item">
                    <h4>友情链接</h4>
                    <p>
                        <a href="#">斗鱼直播</a>
                        <a href="#">匿名版</a>
                        <br>
                        <a href="#">AC大逃杀</a>
                    </p>
                </div>
                <span class="line"></span>
                <div class="item">
                    <h4>反馈</h4>
                    <p>
                        <a href="#">意见反馈</a>
                        <a href="#">举报</a>
                        <a href="#">帮助中心</a>
                        <br>
                        <a href="#">免责声明</a>
                        <a href="#">用户协议</a>
                    </p>
                </div>
            </div>
            <div class="footer-img fr">
                <img src="images/footer-logo.gif" alt="#">
            </div>
        </div>
        <div class="footer-middle clearfix">
            <div class="item">
                <a href="#"><i class="icon icon-1"></i>中国互联网举报中心</a>
                <a href="#"><i class="icon icon-2"></i>网络文化经营单位</a>
            </div>
            <div class="item">
                <span>京8888888888号</span>
            </div>
            <div class="item">
                <span>节目制作经营许可证66666666666号</span>

            </div>
        </div>
        <div class="footer-bottom">
            <img src="images/logo-gray.png" alt="#">
            <p>本站不提供任何视听上传服务，所有内容均来自视频分享站点所提供的公开引用资源。********</p>
        </div>
    </div>
</div>

<a href="javascript:;" id="back_top" class="iconfont icon-up"></a>

<script src="js/jquery.min.js"></script>
<script src="js/script.js"></script>
<script src="js/sliderbox.js"></script>
<script src="js/tab.js"></script>
<script type="text/javascript">
    $('input[id=lefile]').change(function() {
        $('#photoCover').val($(this).val());
    });
    $('input[id=lefile_video]').change(function () {
        $('#photoCover_v').val($(this).val());
    })
</script>

</body>
</html>