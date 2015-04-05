<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Bug管理系统</title>
  
    <link href="./css/style.css" rel="stylesheet" type="text/css">
    <script src="./js/common.js" type="text/javascript"></script>
    <!--[if IE 6]>

<script src="/Content/data/DD_belatedPNG_0.0.8a-min.js" mce_src="/Content/data/DD_belatedPNG_0.0.8a-min.js"></script>

<script type="text/javascript">DD_belatedPNG.fix('.Content ,.Content div.Right ,ul.Menu li a.menu1 ,ul.Menu li a.menu2 ,ul.Menu li a.menu3 ,ul.Menu li a.menu4,ul.Menu li a.menu5');</script>

<![endif]-->
<script type="text/javascript" src="./js/config.js"></script><link rel="stylesheet" type="text/css" href="./AddBug_files/editor.css"><script type="text/javascript" src="./AddBug_files/zh-cn.js"></script><script type="text/javascript" src="./AddBug_files/plugin.js"></script><script type="text/javascript" src="./AddBug_files/zh-cn(1).js"></script><script type="text/javascript" src="./AddBug_files/default.js"></script></head>
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
            <s:form action="addBug" method="post">
            
            <input name="pid" type="hidden" value="5766">
            <div class="Bugicon Midbox">
                UnDefined
                Bug
            </div>
            <!--start of solution-->
            <div class="Solution Insert ">
                <table class="Gray box">
            		<tr><td> Bug标题<font color="red">*</font></td><td><s:textfield name="bugInfo.bugName" class="inputgri" cssStyle="width:750px;"></s:textfield></td><td><span style="color: Red;" id="info">${errors.title}</span></td></tr>
            		<!--
            		<tr><td>版本</td><td> <s:select list="#{'1':'默认版本'}" name="bugInfo.version"></s:select></td></tr>
            		<tr><td>模块</td><td> <s:select list="#{'1':'默认模版'}" name="bugInfo.module"></s:select></td></tr>
            		-->
            		<tr><td>优先级</td><td><s:select list="#{'1':'低','2':'中','3':'高','4':'紧急','5':'严重'}" name="bugInfo.bugType" cssStyle="width:75px"></s:select></td></tr>
            	
            		<tr><td>处理人</td>
            			<td><select style="width:75px" name="bugInfo.bugDealer">
            					<s:iterator value="userList" id="userInfo" status="stat"><option >${userInfo.name}</option></s:iterator>
            				</select>
            			</td>
            		</tr>
            		<!--  
            		<tr><td>处理人</td><td><s:textfield name="bugInfo.bugDealer" class="inputgri" style="width:150px;"></s:textfield></td></tr>
            		-->
            		<tr><td>描述与截图</td><td><s:textarea name="bugInfo.bugContent" class="inputgri" cssStyle="width:150px;"></s:textarea></td></tr>
            		<tr><td><input type="submit" value="提交"/></td></tr>
            	</table>
                <div class="clear">
                    <!-- -->
                </div>
            </div>
            </s:form>
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

    <script src="./js/jquery-1.3.2.min.js" type="text/javascript"></script>

    <script src="./js/addbug.js" type="text/javascript"></script>

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