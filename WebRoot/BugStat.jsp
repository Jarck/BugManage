<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Bug管理系统</title>
    
    <link href="./css/style.css" rel="stylesheet" type="text/css"/>
    <script src="./js/common.js" type="text/javascript"></script>
    <!--[if IE 6]>

<script src="/Content/data/DD_belatedPNG_0.0.8a-min.js" mce_src="/Content/data/DD_belatedPNG_0.0.8a-min.js"></script>

<script type="text/javascript">DD_belatedPNG.fix('.Content ,.Content div.Right ,ul.Menu li a.menu1 ,ul.Menu li a.menu2 ,ul.Menu li a.menu3 ,ul.Menu li a.menu4,ul.Menu li a.menu5');</script>

<![endif]-->
</head>
<body>
    <!-- start of wrapper-->
    <div class=" Wrapper">
        <!-- start of top-->
        <div class="Top">
            <div class="left White">
    <a class="DLine light-yellow" href="">主页</a> 欢迎<span class="username">${loginUser.name}</span>
    <a class="DLine light-yellow" href="loginOut">退出</a>
    
</div>

        </div>
        <!--end of top-->
        
    <link href="./css/calendar_style.css" rel="stylesheet" type="text/css">

    <script src="./js/ShowCalendar.js" type="text/javascript"></script><div id="calendarPanel"></div>

    <script src="./js/swfobject.js" type="text/javascript"></script>

    
<!-- start of subheader-->
<div class="SubHeader">
    <span class="left">
        
        <img src="./image/nopic.jpg" class="BlueBorder icon_biger user-logo-define"/>
        
        <select id="s_prj" class="Select" onchange="ChangePrj();">
            
            <option value="5766" selected="selected">
                CTIA</option>
            
        </select>
    </span>

    <ul class="Menu">
        
        <li><a href="projectInfo.action" class="menu1 Activity"> 项目概况</a></li>
        <li><a href="myBug.action" class="menu2 Activity"> 分配给我的Bug</a></li>
        <li><a href="myFindBug.action" class="menu3 Activity">我创建的Bug</a></li>
        <li><a href="bugList.action" class="menu4 Activity"> 所有Bug</a></li>
        
    </ul>
</div>
<!-- end of subheader-->

    <!-- start of content -->
    <div class="Content">
        <div class="Right">
            <div class="Bugicon Midbox">
                Bug统计</div>
            <div class="relative CenterBox Sub">
                <form method="post" id="_form" action="">
                <div class="SearchBox left">
                    <span class="left icon_biger">
                        <label>
                            日期</label>
                        <input name="time_from" type="text" value="2013-03-10" onclick="new TSCalendar(0).show(this);">
                        至
                        <input name="time_to" type="text" value="2013-04-10" onclick="new TSCalendar(0).show(this);">
                    </span><a href="javascript:SubmitForm('_form');" class=" Buttom  "><span>
                        提交</span></a>
                </div>
                </form>
                <a href="" class="button-create"><span>
                    提交新Bug</span></a>
                <div class="clear">
                    <!-- -->
                </div>
            </div>
            <p class="clear">
            <!-- -->
            </p>
            
            <!--end of solution-->
        </div>
        <div class="clear">
            <!-- -->
        </div>
    </div>
    <!-- start of content -->
    <div class="clear">
        <!-- -->
    </div>
    <br>

    </div>
    <!-- end of wrapper-->
    
<div class="Footer">
    <span class="left copyright">
        版权所有
        </span> <span class="left"><a href="" target="_blank">
            法律声明</a> | <a href="" target="_blank">
                服务条款</a> | <a href="" target="_blank">
                    隐私声明</a> | <a href="" target="_blank">
                        联系我们</a> | 
                        </span><span class="right">
                         
                            </span>
</div>

</body></html>