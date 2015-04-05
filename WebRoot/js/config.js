/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
    // config.uiColor = '#AADC6E';

    config.filebrowserUploadUrl = '/ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Files'; //上传文件按钮(标签)
    config.filebrowserImageUploadUrl = '/ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Images'; //上传图片按钮(标签)
    config.filebrowserFlashUploadUrl = '/ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Flash'; //上传Flash按钮(标签)

    config.toolbarCanCollapse = false;
    config.skin = 'kama'; // 'v2';
    config.toolbar = 'easybugfull';

    config.toolbar_easybugfull = [['Bold', 'Italic', 'Underline', 'Strike',
                                 '-','NumberedList', 'BulletedList', 'Outdent', 'Indent',
                                '-','TextColor','BGColor','JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock',
                                '-','Link', 'Unlink',
                                '-','Image', 'Table', 'Smiley',
                                '-','Paste', 'PasteText', 'PasteFromWord', 'Source','-','StartCapture','CaptureFromClipboard']];

    config.toolbar = 'easybugbase';
    config.toolbar_easybugbase = [['Smiley', 'Image', 'TextColor', 'BGColor', 'Bold', 'Italic', 'Underline', 'Link', 'Unlink', '-', 'StartCapture', 'CaptureFromClipboard']];

    config.toolbar = 'EditMail';
    config.toolbar_EditMail = [['TextColor', 'BGColor', 'Bold', 'Italic', 'Underline', 'Link', 'Unlink']];


    config.fontSize_sizes = '8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;'

    //是否强制复制来的内容去除格式 plugins/pastetext/plugin.js
    config.forcePasteAsPlainText = true;
    //是否使用完整的html编辑模式 如使用，其源码将包含：<html><body></body></html>等标签
    config.fullPage = false;
    //是否忽略段落中的空字符 若不忽略 则字符将以“”表示 plugins/wysiwygarea/plugin.js
    config.ignoreEmptyParagraph = true;
    /*
    //对address标签进行格式化 plugins/format/plugin.js 
    config.format_address = { element : 'address', attributes : { class : 'styledAddress' } }; 

    //对DIV标签自动进行格式化 plugins/format/plugin.js 
    config.format_div = { element : 'div', attributes : { class : 'normalDiv' } }; 

    //对H1标签自动进行格式化 plugins/format/plugin.js 
    config.format_h1 = { element : 'h1', attributes : { class : 'contentTitle1' } }; 

    //对H2标签自动进行格式化 plugins/format/plugin.js 
    config.format_h2 = { element : 'h2', attributes : { class : 'contentTitle2' } }; 

    //对H3标签自动进行格式化 plugins/format/plugin.js 
    config.format_h1 = { element : 'h3', attributes : { class : 'contentTitle3' } }; 

    //对H4标签自动进行格式化 plugins/format/plugin.js 
    config.format_h1 = { element : 'h4', attributes : { class : 'contentTitle4' } }; 

    //对H5标签自动进行格式化 plugins/format/plugin.js 
    config.format_h1 = { element : 'h5', attributes : { class : 'contentTitle5' } }; 

    //对H6标签自动进行格式化 plugins/format/plugin.js 
    config.format_h1 = { element : 'h6', attributes : { class : 'contentTitle6' } }; 

    //对P标签自动进行格式化 plugins/format/plugin.js 
    //config.format_p = { element : 'p', attributes : { class : 'normalPara' } }; 

    //对PRE标签自动进行格式化 plugins/format/plugin.js 
    config.format_pre = { element : 'pre', attributes : { class : 'code' } }; 
    */
    //在清除图片属性框中的链接属性时 是否同时清除两边的<a>标签 plugins/image/plugin.js
    config.image_removeLinkByEmptyURL = true;
    //当从word里复制文字进来时，是否进行文字的格式化去除 plugins/pastefromword/plugin.js 
    config.pasteFromWordIgnoreFontFace = true; //默认为忽略格式 
    //是否使用<h1><h2>等标签修饰或者代替从word文档中粘贴过来的内容 plugins/pastefromword/plugin.js 
    config.pasteFromWordKeepsStructure = false;
    //从word中粘贴内容时是否移除格式 plugins/pastefromword/plugin.js
    config.pasteFromWordRemoveStyle = false;
    //当输入：shift+Enter时插入的标签
    config.shiftEnterMode = CKEDITOR.ENTER_BR; //可选：CKEDITOR.ENTER_BR或CKEDITOR.ENTER_DIV
    //页面载入时，编辑框是否立即获得焦点 plugins/editingblock/plugin.js plugins/editingblock/plugin.js.
    config.startupFocus = false;
    //当用户键入TAB时，编辑器走过的空格数，(&nbsp;) 当值为0时，焦点将移出编辑框 plugins/tab/plugin.js
    config.tabSpaces = 4;
    //撤销的记录步数 plugins/undo/plugin.js
    config.undoStackSize = 20;



    // 在 CKEditor 中集成 CKFinder，注意 ckfinder 的路径选择要正确。 
    //CKFinder.SetupCKEditor(null, "/ckfinder/");
};

CKEDITOR.config.toolbar_Full =
[
	{ name: 'document', items: ['Source', '-', 'Save', 'NewPage', 'DocProps', 'Preview', 'Print', '-', 'Templates'] },
	{ name: 'clipboard', items: ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo'] },
	{ name: 'editing', items: ['Find', 'Replace', '-', 'SelectAll', '-', 'SpellChecker', 'Scayt'] },
	{ name: 'forms', items: ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'] },
	'/',
	{ name: 'basicstyles', items: ['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat'] },
	{ name: 'paragraph', items: ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', 'CreateDiv', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl'] },
	{ name: 'links', items: ['Link', 'Unlink', 'Anchor'] },
	{ name: 'insert', items: ['Image', 'Flash', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak', 'Iframe'] },
	'/',
	{ name: 'styles', items: ['Styles', 'Format', 'Font', 'FontSize'] },
	{ name: 'colors', items: ['TextColor', 'BGColor'] },
	{ name: 'tools', items: ['Maximize', 'ShowBlocks', '-', 'About'] }
];
