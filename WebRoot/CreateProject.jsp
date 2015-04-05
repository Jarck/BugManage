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
    <a class="DLine light-yellow" href="loginOut">退出</a>
    
</div>

        </div>
        <!--end of top-->
        

    <script src="./js/jquery-1.3.2.min.js" type="text/javascript"></script>

    <link href="./css/thickbox.css" rel="stylesheet" type="text/css">

    <script src="./js/thickbox.js" type="text/javascript"></script>

    <!-- start of content -->
    <div class="Content">
        <div class="Right">
            <div class="Bugicon Midbox">
                创建新项目
            </div>
            <!--start of solution-->
            <div class="Solution">
                
                <form id="_form" action="createProject" method="post">
                <div class="OverviewBox clear box">
                    <label>项目名称<font color="red">*</font></label>
                    <s:textfield name="projectName"></s:textfield>
                    <span style="color: Red;" id="info">${errors.projectName}</font>
                </div>
                <div class="OverviewBox clear box">
                    <label>添加成员</label>
                    <div class="left">
                        <div class="left">
                            <s:textarea cols="25" rows="6" name="emailList"></s:textarea>
                        </div>
                        <div class="nametip DLine ">
                            <div class="mid">
                                添加新成员(输入Email,用";"隔开)
                            </div>
                            <div class="btm">
                                <!-- -->
                            </div>
                        </div>
                        <br class="clear">
                        <br>
						
                    </div>
                    <div class="OverviewBox clear box">
                		<input type="submit" value="创建"/><input type="reset" value="取消"/>
                	</div>
                </div>
                </form>
                
                <div class="clear">
                    <!-- -->
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