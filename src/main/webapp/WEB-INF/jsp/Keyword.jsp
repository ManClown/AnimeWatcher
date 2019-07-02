<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/5/9
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AnimeWatcher</title>

    <link rel="stylesheet" href="<%=basePath%>css/reset.css">
    <link rel="stylesheet" href="<%=basePath%>css/index.css">
    <link rel="stylesheet" href="<%=basePath%>font/iconfont.css">
</head>
<body style=" height: 100%; ">

<!--默认主页面，网站首页-->
<!-- 顶部页面 -->
<div id="header">

    <!-- 最顶部 -->
    <div class="header-top">
        <div class="auto-width">
            <h1 class="logo fl"><a href="#"><img src="<%=basePath%>images/logo.png" alt="#"></a></h1>
            <div class="search-box fl">
                <form action="<%=basePath%>KeywordVideoAction">
                    <input type="text" class="fl search-text" placeholder="Search here..." name="keyword">
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
                    <s:if test="%{#session.user != null}">
                        <a href="<%=basePath%>HistoryAction">
                            <i class="iconfont icon-history"></i>
                        </a>
                    </s:if>
                    <s:else>
                        <a>
                            <i class="iconfont icon-history"></i>
                        </a>
                    </s:else>
                </li>
                <li class="guide-item upload">
                    <a href="#">
                        <i class="iconfont icon-upload"></i>
                    </a>
                    <div class="guide-hover">
                        <ul>
                            <s:if test="%{#session.user != null}">
                                <li><a href="<%=basePath%>VideoUpload">投视频</a></li>
                                <li><a href="<%=basePath%>VideoManager_Query">视频管理</a></li>
                            </s:if>
                            <s:else>
                                <li>请先登录</li>
                            </s:else>
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
    <div class="header-nav">
        <div class="nav-wrap auto-width clearfix">
            <a href="<%=basePath%>AllVideoAction" class="nav-item nav-cur">全部</a>
        </div>
    </div>

</div>

<!---------- 主体内容 ---------->
<div id="main">
    <div class="auto-width clearfix">

        <!-- 动画 -->
        <section class="area clearfix">
            <div class="area-cont">
                <div class="area-main fl">
                    <ul class="area-menu clearfix">
                        <s:iterator value="#request.display" var="video" status="vd">
                            <li class="area-menu__item">
                                <a href="<%=basePath%>PlayerAction?videoNumber=<s:property value="#video.videoNumber"/>" class="img">
                                    <img src="<%=basePath%><s:property value="#video.cover"/>" alt="#">
                                    <span class="mask">
                      <em class="time">4:47</em>
                  </span>
                                    <span class="icon-recommend">推荐</span>
                                </a>
                                <div class="info">
                                    <a href="<%=basePath%>PlayerAction?videoNumber=<s:property value="#video.videoNumber"/>" class="change-title"> <s:property value="#video.title"/> </a>
                                    <span class="play-info clearfix">
                    <i class="iconfont icon-play fl"></i>
                    <i class="iconfont icon-collect fr"></i>
                  </span>
                                </div>
                            </li>
                        </s:iterator>
                    </ul>
                </div>

            </div>
        </section>

        <div align="center">
            <span style="font-size: larger">共<s:property value="#request.pageNum"/>页面</span>
            <input type="text" id="page" name="page" style="border: 5px solid #def; width: 40px; color: #3BD9FF"/>
            <input type="button" onclick="goto()" value="跳转" style="font-size: larger; width: auto; border:  5px solid #def;"/>
        </div>
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
                        <a href="#">微信公众号<img src="<%=basePath%>images/footer-arcode.jpg" class="footer-orcode" alt="#"></a>
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
                <img src="<%=basePath%>images/footer-logo.gif" alt="#">
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
            <img src="<%=basePath%>images/logo-gray.png" alt="#">
            <p>本站不提供任何视听上传服务，所有内容均来自视频分享站点所提供的公开引用资源。********</p>
        </div>
    </div>
</div>

<a href="javascript:;" id="back_top" class="iconfont icon-up"></a>
<script>
    function goto() {
        var page= document.getElementById("page");
        window.location.href = "<%=basePath%>KeywordVideoAction?page="+page.value;
    }
</script>
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>js/script.js"></script>
<script src="<%=basePath%>js/sliderbox.js"></script>
<script src="<%=basePath%>js/tab.js"></script>

</body>
</html>
