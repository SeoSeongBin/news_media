﻿(function(){bender.loadExternalPlugin("exportpdf","/apps/plugin/");CKEDITOR.plugins.load("exportpdf",function(){bender.editors={defaultHeader:{config:{extraPlugins:"exportpdf"}},customHeader:{config:exportPdfUtils.getDefaultConfig("unit")}};bender.test({setUp:function(){bender.tools.ignoreUnsupportedEnvironment("exportpdf");sinon.stub(CKEDITOR.plugins.exportpdf,"downloadFile")},tearDown:function(){CKEDITOR.plugins.exportpdf.downloadFile.restore()},"test default statistics header":function(){var a=
this.editors.defaultHeader;this.editorBots.defaultHeader.setHtmlWithSelection('<p id="test">Hello, World!</p>^');exportPdfUtils.useXHR(a,function(a){assert.areEqual(a.requestHeaders["x-cs-app-id"],"cke4","Default stats header is wrong.")})},"test custom statistics header":function(){var a=this.editors.customHeader;this.editorBots.customHeader.setHtmlWithSelection('<p id="test">Hello, World!</p>^');exportPdfUtils.useXHR(a,function(a){assert.areEqual(a.requestHeaders["x-cs-app-id"],
"cke4-tests-unit","Custom stats header was not set properly.")})}})})})();