<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
        
    <script src="./js/jquery-1.3.2.min.js" type="text/javascript"></script>
    <form id="_form" action="modifyBugInfo" method="post">
    <!-- start of content -->
    <div class="Content">
        <div class="Right">
            <div class="Bugicon Midbox left">
                Bug
                处理</div>
            <div class="clear">
            </div>
            <!--start of solution-->
            <div class="Solution Insert">
            
            	
            	<s:if test='!bugInfo.bugState.equals("关闭")'>
            		<p class="createEdit">
            		<!-- 
            			<a class="Blue edit" href="">修改</a>
            			 -->
            		</p>
            	</s:if>
                   
                 	<p class="Gray box">
                        <label>
                            项目名称
                        </label>
                        <b>
                        ${projectName}</b></p>
                    <p class="Gray box">
                        <label>
                            Bug标题
                        </label>
                        ${bugInfo.bugID}#&nbsp;${bugInfo.bugName}</p>
                    <p class="Gray box">
                        <label> 时间</label>
                        ${bugInfo.bugBeginTime}</p>
                   		<s:date name=" #bugInfo.bugBeginTime" format="yyyy-MM-dd"/>
                    <p class="Gray box">
                        <label>
                            优先级</label>
                      <s:if test='bugInfo.bugType.equals("1")'>低</s:if>
                      <s:if test='bugInfo.bugType.equals("2")'>中</s:if>
                      <s:if test='bugInfo.bugType.equals("3")'>高</s:if>
                      <s:if test='bugInfo.bugType.equals("4")'>紧急</s:if>
                      <s:if test='bugInfo.bugType.equals("5")'>严重</s:if>
                    </p>
                    <p class="Gray box">
                        <label>
                            状态</label>
                      <s:if test='bugInfo.bugState.equals("1")'>新建</s:if>
                   	  <s:if test='bugInfo.bugState.equals("2")'>修复中</s:if>
                   	  <s:if test='bugInfo.bugState.equals("3")'>已修复</s:if>
                   	  <s:if test='bugInfo.bugState.equals("4")'>关闭</s:if></p>
                    <p class="Gray box">
                        <label>
                            分配人</label>
                       ${bugInfo.bugFinder}
                    </p>
                    <p class="Gray box">
                        <label>
                            处理人</label>
                       ${bugInfo.bugDealer}
                    </p>
                    <p class="Gray box">
                        <label>
                            描述与截图</label>
                        <span class="left">
                            </span></p><p>
	${bugInfo.bugContent}</p>

                    <p></p>
                    <div class="Gray box Detail clear">
                        <label>
                            处理过程</label>
                        <!--start of solution-->
                        <div class="Solution left">
                            
                            <table border="0" width="100%" cellpadding="10" cellspacing="0" class="bugdetail box">
                                
                                <tbody><tr class="title">
                                    <td width="12%">
                                        <span class="BlueBox">
                                            已分配
                                        </span>
                                    </td>
                                    <td width="20%">
                                        ${bugInfo.bugFinder}
                                        →
                                        ${bugInfo.bugDealer}
                                    </td>
                                    <td class="">
                                        
                                    </td>
                                    <td width="14%">
                                        ${bugInfo.bugBeginTime}
                                    </td>
                                </tr>
                                <tr class="arrow">
                                    <td colspan="4">
                                    </td>
                                </tr>
                                
                                <tr class="last">
                                    <td>
                                        <span class="RedBox">
                                            <s:if test='bugInfo.bugState.equals("1")'>新建</s:if>
                   	  						<s:if test='bugInfo.bugState.equals("2")'>修复中</s:if>
                   	  						<s:if test='bugInfo.bugState.equals("3")'>已修复</s:if>
                   	  						<s:if test='bugInfo.bugState.equals("4")'>关闭</s:if>
                   	  					</span>
                                    </td>
                                    <td>
                                        ${bugInfo.bugDealer}
                                    </td>
                                    <td class="">
                                        
                                    </td>
                                    <td>
                                        
                                    </td>
                                </tr>
                                
                                
                            </tbody></table>
                        </div>
                        <!--end of solution-->
                    </div>
                    <div class="clear">
                        <!-- -->
                    </div>
                    
                    <s:if test='!bugInfo.bugState.equals("关闭")'>
                    	
                    	<p class="Gray box NoneBorder">
                        <label>
                            状态</label>
                        <span class="icon_bigest">
                            <s:select list="#{'2':'修复中','3':'已修复','4':'关闭'}" name="bugModifyInfo.bugState"></s:select>
                        </span>
                        
                        <span id="input_changTo"></span>
                    </p>
                    <input type="hidden" name="bugModifyInfo.bugID" value="${bugInfo.bugID}"/>
                    <div class="transform"> 
                        <p class="Gray box" style="margin-top: 1px;">
                            <label>
                                备注</label>
                             <span class="icon_bigest">
                            <s:textarea name="bugModifyInfo.bugContent" class="inputgri" cssStyle="width:150px;"></s:textarea>
                        </span>
                         </p>
                    </div>
                    <p class="Gray box">
                        <label>
                            &nbsp;</label>
                        <input type="submit" value="提交"/><input type="reset" value="取消"/>
                    </p>
                    </s:if>
                    
                    
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
   </form>
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