<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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
        
    <script src="./js/jquery-1.3.2.min.js" type="text/javascript"></script>
    
<!-- start of subheader-->
<div class="SubHeader">
    <span class="left">
        
        <img src="./image/nopic.jpg" class="BlueBorder icon_biger user-logo-define">
        
        <select id="s_prj" class="Select" onchange="ChangePrj();">
            
            <option value="5766" selected="selected">
                ${projectName}</option>
            
        </select>
    </span>

    <ul class="Menu">
        
        <li><a href="projectInfo.action?projectID=${projectID}" class="menu1 Activity"> 项目概况</a></li>
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
                分配给我的Bug
            </div>
            <!-- 
             <form id="_form" action="myBugSearch.action" method="post">
              -->
            <input id="pid" type="hidden" value="5766" name="pid">
            <input id="pageIndex" type="hidden" value="1" name="pageIndex">
            <div class="relative CenterBox">
                <div class="SearchBox left">
                <s:form action="mybugSearch" method="post">
                <table>
                	</table>
                    <span class="icon_big left">
                        优先级
                        <s:select list="#{'0':'全部','1':'低','2':'中','3':'高','4':'紧急','5':'严重'}" name="bugSearchInfo.bugType" cssStyle="width:150px"></s:select>
                    </span>
                    <span class="icon_big left">关键<input type="text" name="bugSearchInfo.bugName" id="keyWord"></span>
                    <span><input type="submit" value="搜索"/></span>
                    <input type="hidden" name="bugSearchInfo.projectID" value="${projectID}"/>
                    </s:form>
                </div>
                <br class="clear">
            </div>
            <!-- </form> -->
            
           
            <p class="clear">
                <!-- -->
            </p>
            <!--start of solution-->
            <div class="Solution">
                <a href="userList.action" class="button-create"><span> 提交新Bug</span></a>
                <div class="gantan">
                    <b>未解决的Bug</b></div>
                <div id="page1">
                	<input type="hidden" value="" name="orderBy" id="OrderBy">


<table border="0" width="100%" cellpadding="10" cellspacing="0" class="Bug box">
    <tbody><tr class="BlueBackground Black  BugTitle TableTop">
        <td width="40%">
            <b>标题</b>
        </td>
        <td width="10%">
            <b>优先级</b> <a title="按照优先级正序排列" href=""><img src="./image/grayarrow.gif"></a>
        </td>
        <td width="10%">
            <b>状态</b> <a title="按照状态正序排列" href=""><img src="./image/grayarrow.gif"></a>
        </td>
        <td width="10%">
            <b>分配人</b> <a title="按照分配人正序排列" href=""><img src="./image/grayarrow.gif"></a>
        </td>
        <td width="10%">
            <b>日期</b> <a title="按照日期正序排列" href=""><img src="./image/grayarrow.gif"></a>
        </td>
    </tr>
    <s:if test='0 == unclosedBugList.size()'>
    	<tr class="GrayBackGround"><td>暂无数据</td></tr>
    </s:if>
    				
    <s:iterator value="unclosedBugList" id="bugInfo">
    	<tr class="GrayBackground">
        <td><a target="_blank" href="bugDetail.action?id=${bugInfo.bugID}" class="Blue BiggerFont"><b>${bugInfo.bugID}#${bugInfo.bugName}</b></a></td>
        <s:if test=' #bugInfo.bugType == "1" '><td class="Green">低</td></s:if>
        <s:if test=' #bugInfo.bugType == "2" '><td class="ThinGreen">中</td></s:if>
        <s:if test=' #bugInfo.bugType == "3" '><td class="Orange">高</td></s:if>
        <s:if test=' #bugInfo.bugType == "4" '><td class="Red">紧急</td></s:if>
        <s:if test=' #bugInfo.bugType == "5" '><td class="Pink">严重</td></s:if>
        <s:if test=' #bugInfo.bugState == "1" '><td><span class="RedBox">新&nbsp;&nbsp;&nbsp;&nbsp;建</span></td></s:if>
        <s:if test=' #bugInfo.bugState == "2" '><td><span class="OrangeBox">修复中</span></td></s:if>
        <s:if test=' #bugInfo.bugState == "3" '><td><span class="BlueBox">已修复</span></td></s:if>
        <s:if test=' #bugInfo.bugState == "4" '><td><span class="GreenBox">关闭</span></td></s:if>
        <td>${bugInfo.bugDealer}</td>
        <td><s:date name=" #bugInfo.bugBeginTime" format="yyyy-MM-dd"/></td>
    </tr>
    </s:iterator>
    
</tbody></table>
                </div>
            </div>
            <!--end of solution-->
            <p class="box">
                <!-- -->
            </p>
            <!--start of solution-->
            <div class="Solution">
                <div class="gantan Resolved">
                    <b>
                        已解决的Bug</b></div>
                <div id="page2">
<input type="hidden" value="" name="orderBy" id="OrderBy">

<table border="0" width="100%" cellpadding="10" cellspacing="0" class="Bug box">
    <tbody><tr class="BlueBackground Black  BugTitle TableTop">
        <td width="40%">
            <b>标题</b>
        </td>
        <td width="10%">
            <b>优先级</b> <a title="按照优先级正序排列" href=""><img src="./image/grayarrow.gif"></a>
        </td>
        <td width="10%">
            <b>状态</b> <a title="按照状态正序排列" href=""><img src="./image/grayarrow.gif"></a>
        </td>
        <td width="10%">
            <b>分配人</b> <a title="按照分配人正序排列" href=""><img src="./image/grayarrow.gif"></a>
        </td>
        <td width="10%">
            <b>日期</b> <a title="按照日期正序排列" href=""><img src="./image/grayarrow.gif"></a>
        </td>
    </tr>
    
    <s:if test='0 == closedBugList.size()'>
    	<tr class="GrayBackGround"><td>暂无数据</td></tr>
    </s:if>
    
    <s:iterator value="closedBugList" id="bugInfo">
    	<tr class="GrayBackground">
        <td><a target="_blank" href="bugDetail.action?id=${bugInfo.bugID}" class="Blue BiggerFont"><b>${bugInfo.bugID}#${bugInfo.bugName}</b></a></td>
        <s:if test=' #bugInfo.bugType == "1" '><td class="Green">低</td></s:if>
        <s:if test=' #bugInfo.bugType == "2" '><td class="ThinGreen">中</td></s:if>
        <s:if test=' #bugInfo.bugType == "3" '><td class="Orange">高</td></s:if>
        <s:if test=' #bugInfo.bugType == "4" '><td class="Red">紧急</td></s:if>
        <s:if test=' #bugInfo.bugType == "5" '><td class="Pink">严重</td></s:if>
        <s:if test=' #bugInfo.bugState == "1" '><td><span class="RedBox">新&nbsp;&nbsp;&nbsp;&nbsp;建</span></td></s:if>
        <s:if test=' #bugInfo.bugState == "2" '><td><span class="OrangeBox">修复中</span></td></s:if>
        <s:if test=' #bugInfo.bugState == "3" '><td><span class="BlueBox">已修复</span></td></s:if>
        <s:if test=' #bugInfo.bugState == "4" '><td><span class="GreenBox">关闭</span></td></s:if>
        <td>${bugInfo.bugDealer}</td>
        <td><s:date name=" #bugInfo.bugBeginTime" format="yyyy-MM-dd"/></td>
    </tr>
    </s:iterator>
    
</tbody></table>
</div>
            </div>
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