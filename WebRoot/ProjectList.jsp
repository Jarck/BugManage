<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    
      
         
    <title>Bug跟踪管理工具</title>
   
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
        
    
    
    <!-- start of content -->
    <div class="Content">
        <div class="Right">
            <div class="Bugicon Midbox">
                项目信息<a href="CreateProject.jsp" class="button-create"><span class="right">
                        创建项目</span> </a>
            </div>
            <div class="clear">
                <!-- -->
            </div>
            <!--start of solution-->
            <div class="Solution">
                
                <h3>
                    所有项目</h3>
                <table border="0" width="100%" style="text-align: center" cellpadding="10" cellspacing="0" class="Bug box">
                    <tbody><tr class="BlueBackground Black BugTitle TableTop">
                        <td width="28%" align="left">项目名称</td>
                        <td width="15%">加入日期</td>
                        <td align="left">操作</td>
                    </tr>
                    
                    <s:if test='0 == projectList.size()'>
    					<tr class="GrayBackGround"><td>暂无数据</td></tr>
    				</s:if>
                    <s:else>
                    	<s:iterator value="projectList" id="projectInfo" status="stat">
                    	<tr class="GrayBackground" id="tr_5766">
	                        <td align="left"><a class="Blue" href="">${projectInfo.projectName}</a></td>
	                        <td>${projectInfo.projectBeginTime}</td>
	                        <td align="left">[<a class="Blue" href="projectInfo.action?projectID=${projectInfo.projectID}">进入</a>]</td>
                    	</tr> 
                    	</s:iterator>    
                    </s:else>
                    
                </tbody>
                </table>
                
                <div class="clear">
                    <!-- -->
                </div>
            </div>
            <!--end of solution-->
        </div>
    </div>
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
       
<div style="display:none;">

</div>

</body></html>