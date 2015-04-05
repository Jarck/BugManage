var objEasybug;
var flag = false;
var cType = 0;
var hasInit = false;
var EasybugEditorIntance = null;
var latestVersion = 1.3;
var imgServer="img1";
function initCamera(editor) {
    if (editor != null && editor != undefined) {
        EasybugEditorIntance = editor;
    }    
        var whatsnew='[2013-03-18]下载新版截图插件v' + latestVersion + '，支持IE,Firefox,Chrome三大流行浏览器.'
        if (document.all) {
            document.write('<OBJECT ID="oEA" CLASSID="CLSID:A6BBC994-C147-4C0E-9D1B-8D058059E883" ></OBJECT>');
            objEasybug = document.getElementById('oEA');
            if (objEasybug.LastFileName == undefined || objEasybug.GetVersion < latestVersion) {
                $("#href_client").text(whatsnew).show();
                flag = true;
            }
            
            if(objEasybug.attachEvent) 
            { 
                objEasybug.attachEvent("OnUploadProcessing", OnUploadProcessing);
                objEasybug.attachEvent("OnCameraComplete", OnCameraComplete);            
            }
            else if(objEasybug.addEventListener)
            { 
                objEasybug.addEventListener("OnUploadProcessing", OnUploadProcessing, false); 
                objEasybug.addEventListener("OnCameraComplete", OnCameraComplete, false); 
            }
            hasInit = true;
        }
        else {
            document.write('<embed id="oEA"  type="application/Easybug-Plugin" width="1" height="1" >');
            objEasybug = document.getElementById('oEA');
            if (objEasybug.CameraScreen == undefined || objEasybug.GetVersion < latestVersion) {
                $("#href_client").text(whatsnew).show();
                flag = true;
            }
            objEasybug.OnUploadProcessing = "OnUploadProcessing";
            objEasybug.OnCameraComplete = "OnCameraComplete";
            hasInit = true;
            //alert(objEasybug.GetVersion);
        }
        if (objEasybug)
        {
            objEasybug.ShowLanguage = lan;
	        objEasybug.﻿ServerUrl=imgServer;
        }

//        if (!flag) {
//            setTimeout("bindPaste()", 500);
//        }
        
}

function bindPaste() {
    //alert("paste");
    try {
        var oEditor = CKEDITOR.instances.description;
        oEditor.on('paste', UploadClipboadImage)
    } catch (ex) {
        setTimeout("bindPaste()",500);
    }    
}


function StartCameraScreen() {
    if (flag) {
        alert(lan == "cn" ? "请先安装截图插件" : "please install the screenshot  plugin first");
        return;
    }
    cType = 0;
    
    html = "";
    objEasybug.CameraScreen();
}

function UploadClipboadImage(e) {    
    if (flag) {
        alert(lan == "cn" ? "请先安装截图插件" : "please install the screenshot  plugin first");
        return true;
    }            

    cType = 1;
    html = "";
    var bResult = false;
    $("#info").html('waiting...');
    
    try {
        bResult = objEasybug.UploadClipboadImage();
    } catch (ex) {
        //alert("Upload image error.");
        $("#info").html('');
        return true;
    }

    
    if (bResult == "true" || bResult) {        
        return false;
    }
    else {
        $("#info").html('');
        return true;
    }
}

var m_strFileName;
function OnCameraComplete(strFileName) {
    m_strFileName = strFileName;
    try { window.focus(); }
    catch (err) { }
}

var html;
function OnUploadProcessing(nPercent) {
    setTimeout("$('#info').html('uploading... " + nPercent + "%');", 100);
    //$("#info").html('uploading...... ' + nPercent + "%");
    if (nPercent >= 100) {
        setTimeout("$('#info').html('');",500);
		html = "http://" + imgServer + ".easybug.net/uploadfiles/" + m_strFileName;
        var oEditor = CKEDITOR.instances.description;
        if (oEditor == undefined) oEditor = EasybugEditorIntance;
        
        oEditor.insertHtml('<img src="' + html + '" />');
    }
}

if (window.Event) {
    window.onbeforeunload = function (event) {
        CloseCamera();
    }
} else {
    window.onbeforeunload = function () {
        CloseCamera();
    }
}

function CloseCamera() {
    try {
        objEasybug.CancelCamera();
    }
    catch (err)
       { }
}
function AddHit() {
    $.ajax({ url: "/Bug/AddHit", data: "", type: "post" });
}

