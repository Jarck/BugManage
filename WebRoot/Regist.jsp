<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0036)http://www.easybug.net/Member/Regist -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    
    
    <title>Bug管理系统_
        注册</title>

    <link href="./css/style.css" type="text/css" rel="stylesheet"/>

    <script src="./css/jquery-1.3.2.min.js" type="text/javascript"></script>

    <script src="./css/common.js" type="text/javascript"></script>

    <link href="./css/thickbox.css" rel="stylesheet" type="text/css"/>

    <script src="./css/thickbox.js" type="text/javascript"></script>

    <!--[if IE 6]>

<script src="/Content/data/DD_belatedPNG_0.0.8a-min.js" mce_src="/Content/data/DD_belatedPNG_0.0.8a-min.js"></script>

<script type="text/javascript">DD_belatedPNG.fix('.Content ,.Content div.Right ,ul.Menu li a.menu1 ,ul.Menu li a.menu2 ,ul.Menu li a.menu3 ,ul.Menu li a.menu4,ul.Menu li a.menu5,.sun,.white_btn_left,.white_btn_right,.contact .about-us .Solution,.blue_box .information');</script>

<![endif]-->
</head>
<body>
    <!-- start of wrapper-->
    <div class=" Wrapper Home-Wrapper relative">
        <!-- start of top-->
        <div class=" Top">

        </div>
        <!--end of top-->
        <!-- start of user-project-->
        <div class="user-project">
            现在有<span>7474</span>个项目使用EasyBug
        </div>
        <!-- end of user-project-->
        <!-- start of subheader-->
        <div class="SubHeader relative">
            <span class="logo"><a href="">
                <img title="Bug管理系统" src="./image/logo.gif" class="icon_biger"/></a> </span>
                
            <ul class="HomeMenu">
            
                <li><a href="" class="">
                        首页</a></li>
                <li><a href="" class="">
                        产品说明</a></li>
                <li><a href="" class="">
                        常见问题</a></li>                        
                <li><a href="" class="">
                        关于我们</a></li>
            </ul>
        </div>
        <!-- end of subheader-->
        <!-- start of content -->
        
    <div class="Content">
        <div class="Right">
            <div class="Bugicon Midbox">
                注册
                Easybug
            </div>
            <div class="Solution Insert Sub">
                <s:form id="_form" action="regist" method="post">
	                <table>
	                	<tr><td>邮箱:</td><td><s:textfield name="user.email" class="inputgri"></s:textfield></td><td><span style="color: Red;" id="info">${errors.email} ${errors.emaildouble}</span></td></tr>
	                	<tr><td>昵称:</td><td> <s:textfield name="user.name" class="inputgri"></s:textfield></td><td><span style="color: Red;" id="info">${errors.name} ${errors.namedouble}</span></td></tr>
	                	<tr><td>密码:</td><td><s:password name="user.password" class="inputgri"></s:password></td><td><span style="color: Red;" id="info">${errors.password}</span></td></tr>
	                	<tr><td><input type="submit" value="注册"/></td><td><input type="reset" value="取消"/></td></tr>
	                </table>
                </s:form>
            </div>
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