<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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
    <a class="DLine light-yellow" href="projectList">返回项目列表</a>
    <a class="DLine light-yellow" href="loginOut">退出</a>
    
</div>

        </div>
        <!--end of top-->
        
    
<!-- start of subheader-->
<div class="SubHeader">
    <span class="left">
        
        <img src="./image/nopic.jpg" class="BlueBorder icon_biger user-logo-define"/>
        
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
        <div class="Right Sub Sar">
            <div class="Bugicon Midbox">
                项目概况
            </div>
            <div class="SearchBox">
                <div class="left BiggestFont">
                    <a class="bugs-total" href="">Bug总数:<span class="num">${allBugNum}</span></a>
                    <img src="./image/line.gif" class="SLine"/>
                    <a class="bugs-unfix" href=""> 未修复的Bug数:<span class="num">${unClosedBugNum}</span></a>
                    <img src="./image/line.gif" class="SLine"/>
                    <a class="bugs-approval" href="">待审核的Bug数:<span class="num">${sloveBugNum}</span></a>
                    <img src="./image/line.gif" class="SLine"/>
                    <a href="" class="bugs-fix"> 已解决的Bug数:<span class="num">${closedBugNum}</span></a>
                    <img src="./image/line.gif" class="SLine"/>
                </div>
                <a href="userList.action" class="button-create" style="margin-top: 10px;"><span>提交新Bug</span></a>
                <div class="clear">
                    <!-- -->
                </div>
            </div>
            <!--start of solution-->
            <div class="Solution ScaleBox left">
                <div class="gantan Urgently left">
                    <b>
                        严重待处理的BUG</b></div>
               
                
                
                <div class="BlueBorder_btm">
                    <!-- -->
                </div>
    				
                <table border="0" width="100%" cellpadding="10" cellspacing="0" class="Bug box">
                    <tbody><tr class="BlueBackground Black BugTitle TableTop">
                        <td width="67%"> <b>标题</b></td>
                        <td><b>优先级</b></td>
                        <td><b>处理人</b></td>
                    </tr>
                    
                     <s:if test='0 == urgentBugInfoList.size()'>
    					<tr class="GrayBackGround"><td>暂无数据</td></tr>
    				</s:if>
                    
                     <s:iterator value="urgentBugInfoList" id="bugInfo" status="stat">
                    	<tr class="GrayBackground">
	                    	<td><a href="bugDetail.action?id=${bugInfo.bugID}" class="Blue BiggerFont"><b>${bugInfo.bugID}#${bugInfo.bugName}</b></a></td>
	                    	<s:if test=' #bugInfo.bugType == "1" '><td class="Green">低</td></s:if>
	                    	<s:if test=' #bugInfo.bugType == "2" '><td class="ThinGreen">中</td></s:if>
	                    	<s:if test=' #bugInfo.bugType == "3" '><td class="Orange">高</td></s:if>
	                    	<s:if test=' #bugInfo.bugType == "4" '><td class="Red">紧急</td></s:if>
	                    	<s:if test=' #bugInfo.bugType == "5" '><td class="Pink">严重</td></s:if>
	                   	    <td>${bugInfo.bugDealer}</td>
                    	</tr>
                    </s:iterator>
                    
                </tbody></table>
                
            </div>
            <!--end of solution-->
            <!--start of solution-->
            <div class="Solution ScaleBox right">
                <div class="gantan Newbug left">
                    <b> 最新Bug</b>
                </div>
                <div class="BlueBorder_btm">
                    <!-- -->
                </div>
                
                <table border="0" width="100%" cellpadding="10" cellspacing="0" class="Bug box">
                    <tbody><tr class="BlueBackground Black BugTitle TableTop">
                        <td width="67%"> <b>标题</b></td>
                        <td><b>优先级</b></td>
                        <td><b>处理人</b></td>
                    </tr>
                    
                     <s:if test='0 == newBugInfoList.size()'>
    					<tr class="GrayBackGround"><td>暂无数据</td></tr>
    				</s:if>
                    
                    
	                    <s:iterator value="newBugInfoList" id="bugInfo" status="stat">
	                   			
		                    	<s:if test=' #stat.count < 10 '>
		                    		<tr class="GrayBackground">
			                    	<td><a href="bugDetail.action?id=${bugInfo.bugID}" class="Blue BiggerFont"><b>${bugInfo.bugID}#${bugInfo.bugName}</b></a></td>
			                    	<s:if test=' #bugInfo.bugType == "1" '><td class="Green">低</td></s:if>
			                    	<s:if test=' #bugInfo.bugType == "2" '><td class="ThinGreen">中</td></s:if>
			                    	<s:if test=' #bugInfo.bugType == "3" '><td class="Orange">高</td></s:if>
			                    	<s:if test=' #bugInfo.bugType == "4" '><td class="Red">紧急</td></s:if>
			                    	<s:if test=' #bugInfo.bugType == "5" '><td class="Pink">严重</td></s:if>
			                   	    <td>${bugInfo.bugDealer}</td>
		                    		</tr>
		                    	</s:if>
	                    </s:iterator>
                    
                </tbody></table>
                
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