<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/4/21
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>AnimeWatcher</title>

    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/index.css">
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


</div>

<!---------- 主体内容 ---------->
<div id="main">
    <div class="auto-width clearfix">

        <!-- 动画 -->
        <section class="area clearfix">
            <div class="area-cont" id="playerArea">
                <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
                        codebase="http://fpdownload.macromedia.com/pub/shockwave
                        /cabs/flash/swflash.cab#version=6,0,0,0" width="100%" height="100%">
                    <param name="movie" value="<%=basePath%>tool/vcastr2.swf"/>
                    <param name="quality" value="high"/>
                    <param name="menu" value="false"/>
                    <param name="play" value="true"/>
                    <param name=wmode value="opaque"/>
                    <param name="FlashVars" value="vcastr_file=<%=basePath%><s:property
                    value="video.location"/>&vcastr_title=<s:property value="video.title"/>
                    &vcastr_config=0:自动播放|1:连续播放|100:默认音量|0:控制栏位置|2:控制栏显示|0x000033:主体颜色|60:主体透明度|0x66ff00:光晕颜色|0xffffff:图标颜色|0xffffff:文字颜色|:logo文字|:logo地址|:结束swf地址&LogoUrl=<%=basePath%><s:property value="video.cover"/>">
                    <embed src="<%=basePath%>tool/vcastr2.swf" wmode="opaque"
                           FlashVars="vcastr_file=<%=basePath%><s:property value="video.location"/>&
                           vcastr_title=<s:property value="video.title"/>
                           &vcastr_config=0:自动播放|1:连续播放|100:默认音量|0:控制栏位置|2:控制栏显示|0x000033:主体颜色|60:主体透明度|0x66ff00:光晕颜色|0xffffff:图标颜色|0xffffff:文字颜色|:logo文字|:logo地址|:结束swf地址&LogoUrl=<%=basePath%><s:property value="video.cover"/>"
                           menu="false" quality="high" width="100%" height="100%"
                           type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer"/>
                </object>
            </div>
        </section>

        <section class="area clearfix">
                <div hidden="hidden">
                    <textarea id="videoNumber"><s:property value="video.videoNumber"/></textarea>
                    <s:if test="%{#session.user == null}">
                        <textarea id="judge">0</textarea>
                    </s:if>
                    <s:else>
                        <textarea id="judge">1</textarea>
                    </s:else>
                </div>
                <div align="center">
                    <textarea id="comment" name="comment" placeholder="用户评论" cols="180" rows="5" style="resize: none"></textarea>
                </div>
                <div style="border: 5px solid #def; width: 35px; height: 20px; color: #ddeeff; margin-left: 1120px;">
                    <input type="button" value="评论" onclick="comment();"/>
                </div>

        </section>
        <section class="area clearfix">
                <s:if test="%{ #request.commentList == null||#request.commentList.size() == 0}">
                    <div align="center">
                        <textarea name="comment" placeholder="暂无评论" cols="180" rows="5" style="resize: none" readonly="readonly" disabled="disabled"></textarea>
                    </div>
                </s:if>
                <s:else>
                    <s:iterator value="#request.commentList" var="commentRecord">
                        <div style="background-color: #ddeeff; margin-top: 10px;">
                            <textarea name="comment"  cols="180" rows="1" style="resize: none; margin-left: 0px;" readonly="readonly" disabled="disabled">用户<s:property value="#commentRecord.userName"/>:     <s:property value="#commentRecord.comment"/>
                            </textarea>
                        </div>
                    </s:iterator>
                </s:else>
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
        window.location.href = "<%=basePath%>VideoAction?page="+page.value;
    }
    function comment() {
        var judge = document.getElementById("judge");
        if(judge.value === "0"){
            alert("请先登录！");
        }else {
            var comment = document.getElementById("comment");
            var videoNumber = document.getElementById("videoNumber");
            var form = document.createElement("form");
            form.action = "<%=basePath%>CommentAction";
            form.method = "post";
            form.style.display = "none";
            var elementComment = document.createElement("textarea");
            elementComment.name = "comment";
            elementComment.value = comment.value;
            form.appendChild(elementComment);
            var elementVideoNumber = document.createElement("textarea");
            elementVideoNumber.name = "videoNumber";
            elementVideoNumber.value = videoNumber.value;
            form.appendChild(elementVideoNumber);
            document.body.appendChild(form);
            form.submit();
        }
    }
</script>
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>js/script.js"></script>
<script src="<%=basePath%>js/sliderbox.js"></script>
<script src="<%=basePath%>js/tab.js"></script>
</body>
</html>