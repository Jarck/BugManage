<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>EasyBug_
        登录</title>

    <link href="./css/style.css" type="text/css" rel="stylesheet"/>

    <script src="./js/jquery-1.3.2.min.js" type="text/javascript"></script>

    <script src="./js/common.js" type="text/javascript"></script>

    <link href="./Login_files/thickbox.css" rel="stylesheet" type="text/css"/>

    <script src="./Login_files/thickbox.js" type="text/javascript"></script>

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
            
<div class="left user-nav">
  
</div>
        </div>
        <!--end of top-->
        <!-- start of user-project-->
       
        <!-- end of user-project-->
        <!-- start of subheader-->
        <div class="SubHeader relative">
            <span class="logo"><a href="">
                <img title="Bug跟踪管理系统" src="./image/logo.gif" class="icon_biger"></a> </span>
                
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
                登录
                BUG跟踪管理系统</div>
            <!--start of solution-->
            <div class="Solution Insert Sub">
                <s:form id="_form" action="login" method="post">
	                <table>
	                	<tr><span style="color: Red;" id="info">${errors.login}</span></tr>
	                	<tr><td>Email</td><td><s:textfield name="user.email" class="inputgri"></s:textfield></td><td><span style="color: Red;" id="info">${errors.email}</span></td></tr>
	                	<tr><td>密码</td><td><s:password name="user.password" class="inputgri"></s:password></td><td><span style="color: Red;" id="info">${errors.password}</span></td></tr>
	                	<tr><td><input type="submit" value="登录"/></td><td><a href="Regist.jsp">注册</a></td></tr>
	                </table>
                </s:form>
                
            </div>
            <!--end of solution-->
        </div>
        <div class="clear">
        </div>
    </div>

        <!-- start of content -->
        
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