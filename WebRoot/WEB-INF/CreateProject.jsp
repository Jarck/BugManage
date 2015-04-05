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
    <a class="DLine light-yellow" href="">主页</a> 
    欢迎
    <span class="username">
        ${loginUser.name}</span>
    已加入
    <a class="DLine light-yellow" href=""><b>
        1</b>
        个团队</a> <a class="DLine light-yellow" href="">
            <b>
                1</b>
            个项目</a>|<a class="DLine light-yellow" href="">
                我的团队</a>|<a class="DLine light-yellow" href="">
                    个人资料</a>|<a class="DLine light-yellow" href="">
                        退出</a>
    
</div>

<form id="lan_form" action="" method="post">
<div class="right help-language">
<span class="icon_big">
        语言</span> <a href="javascript:SetLanguage('zh-CN')">
            <img title="中文简体" src="./image/cn.gif"/>&nbsp;中</a>
    <a href="javascript:SetLanguage('en-US')">
        <img title="英文" src="./image/gb.gif"/>&nbsp;EN</a>
    <input id="hidden_lan" type="hidden" value="zh-CN" name="lan"/>
    <input type="hidden" value="/Project/CreateProject/7743" name="addr"/>
</div>
</form>

        </div>
        <!--end of top-->
        

    <script src="./js/jquery-1.3.2.min.js" type="text/javascript"></script>

    <link href="./css/thickbox.css" rel="stylesheet" type="text/css">

    <script src="./js/thickbox.js" type="text/javascript"></script>

    <script type="text/javascript">
    
    function SelectAll()
    {
       var sl=document.getElementById('sr');
       var l=sl.options.length;
       for(var i=0;i<l;i++)
       {
           sl.options[i].selected=true;   
       }
      
    }
   
    function SelectAdd()
    { 
      var sl=document.getElementById("sl");
      var l=sl.options.length;
       for(var i=0;i<l;i++)
       { 
         if (sl.options[i].selected)
         {  
           var temp=sl.options[i]; 
            if (!IsAdd(temp.value))
           document.getElementById("sr").options.add(new Option(temp.text,temp.value)); 
         }
       }
    }
    
    function IsAdd(value)
    {
      var sr=document.getElementById("sr");
       var l=sr.options.length;
       for(var i=0;i<l;i++)
       {
         if (sr.options[i].value==value)
          return true;
       }
       return false;
    }
    
    function SelectDel()
 { 
  $("#sr option").each(function(i){if ($(this).attr("selected") ) $(this).remove(); })
  }
    </script>

    <!-- start of content -->
    <div class="Content">
        <div class="Right">
            <div class="Bugicon Midbox">
                创建新项目
            </div>
            <!--start of solution-->
            <div class="Solution">
                
                <form id="_form" action="" onsubmit="javascript:SelectAll();" method="post">
                <input type="hidden" value="7743" name="tid"/>
                <div class="OverviewBox clear box">
                    <label>
                        当前团队</label>
                    <select id="s_team" onchange="ChangeTeam();">
                        
                        <option value="7743" selected="selected">
                            ljd的团队</option>
                        
                    </select>
                </div>
                <div class="OverviewBox clear box">
                    <label>
                        项目名称<font color="red">*</font>
                    </label>
                    <input class="input-w160" type="text" name="projectName" id="projectName">
                    <font color="red">
                        </font></div>
                <div class="OverviewBox clear box">
                    <label>
                        从现有人员选择</label>
                    <div class="left">
                        <p class="Smallbox Black">
                            团队成员</p>
                        <select id="sl" class="input-w160" multiple="multiple" style="height: 150px;">
                            
                            <option value="19161">
                                ljd
                            </option>
                            <option value="19161">
                                aaa
                            </option>
                            
                        </select>
                    </div>
                    <div class="left Two-way">
                        <a href="javascript:SelectAdd();" class="Buttom box"><span>
                            添加
                            &gt;</span></a>
                        <div class="clear">
                            <!-- -->
                        </div>
                        <a href="javascript:SelectDel();" class="Buttom"><span>&lt;
                            删除</span></a>
                    </div>
                    <div class="left">
                        <p class="Smallbox Green">
                            已选成员</p>
                        <select id="sr" class="input-w160" name="selectMembers" multiple="multiple" style="height: 150px;">
                            <option value="19161" disabled="disabled">
                                ljd
                            </option>
                        </select>
                    </div>
                </div>
                <div class="OverviewBox clear box">
                    <label>
                        添加新成员</label>
                    <div class="left">
                        <div class="left">
                            <textarea cols="25" rows="6" name="newMembers"></textarea>
                        </div>
                        <div class="nametip DLine ">
                            <div class="mid">
                                添加新成员(输入Email,换行隔开)
                            </div>
                            <div class="btm">
                                <!-- -->
                            </div>
                        </div>
                        <br class="clear">
                        <br>

                        <a href="javascript:SubmitForm2('_form');" class="Buttom icon_bigest"><span>
                            创建</span></a> <a href="javascript:history.go(-1);" class="Buttom icon_bigest"><span>
                                    返回</span></a>
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
    <br>

    <script type="text/javascript">
    var titlenull="项目名称不能为空";
    function ChangeTeam()
    { 
      window.location="/Project/CreateProject/"+document.getElementById('s_team').value;
    }
    function SubmitForm2(m)
    {
        if(document.getElementById("a_vip"))
        {
           Click('a_vip');
           return;
        }
        if(document.getElementById("a_rewnew"))
        {
           Click('a_rewnew');
           return;
       }
      if ($("#projectName").val().trim()=="") 
       {
       alert(titlenull);
       return;
       }
       SelectAll();
       $("#"+m).submit();
    }
    </script>

    <script type="text/javascript">
    $(document).ready(function(){  
      Click('a_vip');
   }) 
    </script>

    
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