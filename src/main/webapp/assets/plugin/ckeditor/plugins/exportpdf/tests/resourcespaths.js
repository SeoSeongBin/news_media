﻿(function(){bender.loadExternalPlugin("exportpdf","/apps/plugin/");CKEDITOR.plugins.load("exportpdf",function(){function a(a,d,b){b=exportPdfUtils.getDefaultConfig("unit",b||{});bender.editorBot.create({name:"editor"+Date.now(),config:b},function(b){var c=b.editor;b.setHtmlWithSelection(a);c.once("exportPdf",function(b){assert.areEqual(a,b.data.html)},null,null,10);c.once("exportPdf",function(a){a.cancel();assert.areEqual('<div class="cke_editable cke_contents_ltr">'+d+"</div>",a.data.html)},
null,null,16);c.execCommand("exportPdf")})}function b(a,b){a=a.replace(/\/$/g,"");b&&0<b&&(a=a.split("/").slice(0,-b).join("/"));return a}bender.test({setUp:function(){bender.tools.ignoreUnsupportedEnvironment("exportpdf");this.paths={relative0:b(bender.testDir),relative1:b(bender.testDir,1),relative3:b(bender.testDir,3)}},"test absolute image urls are not changed":function(){a('<p>Foo <img src="https://ckeditor.com/img/image1.jpg" /><img src="https://ckeditor.com/img/image2.png" /></p>',
'<p>Foo <img src="https://ckeditor.com/img/image1.jpg" /><img src="https://ckeditor.com/img/image2.png" /></p>')},"test relative (to root) image urls are changed to absolute":function(){a('<p><img src="/img/image1.jpg" /> Bar <img src="/img/big/image2.png" /></p>','<p><img src="'+exportPdfUtils.toAbsoluteUrl("/img/image1.jpg")+'" /> Bar <img src="'+exportPdfUtils.toAbsoluteUrl("/img/big/image2.png")+'" /></p>')},
'test relative (to root) image urls with ".." are changed to absolute':function(){a('<p><img src="/../img/image1.jpg" /> Bar <img src="/../../img/big/image2.png" /></p>','<p><img src="'+exportPdfUtils.toAbsoluteUrl("/img/image1.jpg")+'" /> Bar <img src="'+exportPdfUtils.toAbsoluteUrl("/img/big/image2.png")+'" /></p>')},"test relative (to root) image urls with custom baseHref are changed to absolute":function(){a('<p><img src="/img/image1.jpg" /> Bar <img src="/img/big/image2.png" /></p>',
'<p><img src="'+exportPdfUtils.toAbsoluteUrl("/img/image1.jpg","http://ckeditor.com")+'" /> Bar <img src="'+exportPdfUtils.toAbsoluteUrl("/img/big/image2.png","http://ckeditor.com")+'" /></p>',{baseHref:"http://ckeditor.com/ckeditor4/"})},'test relative (to root) image urls with custom baseHref and ".." are changed to absolute':function(){a('<p><img src="/../img/image1.jpg" /> Bar <img src="/../../img/big/image2.png" /></p>','<p><img src="'+
exportPdfUtils.toAbsoluteUrl("/img/image1.jpg","http://ckeditor.com")+'" /> Bar <img src="'+exportPdfUtils.toAbsoluteUrl("/img/big/image2.png","http://ckeditor.com")+'" /></p>',{baseHref:"http://ckeditor.com/ckeditor4/"})},"test relative (to current url) image urls are changed to absolute":function(){a('<p><img src="img/image1.jpg" /> Bar <img src="img/big/image2.png" /></p>','<p><img src="'+exportPdfUtils.toAbsoluteUrl(this.paths.relative0+
"/img/image1.jpg")+'" /> Bar <img src="'+exportPdfUtils.toAbsoluteUrl(this.paths.relative0+"/img/big/image2.png")+'" /></p>')},'test relative (to current url) image urls with ".." are changed to absolute':function(){a('<p><img src="../img/image1.jpg" /> Bar <img src="../../../img/big/image2.png" /></p>','<p><img src="'+exportPdfUtils.toAbsoluteUrl(this.paths.relative1+"/img/image1.jpg")+'" /> Bar <img src="'+exportPdfUtils.toAbsoluteUrl(this.paths.relative3+
"/img/big/image2.png")+'" /></p>')},"test relative (to current url) image urls with custom baseHref are changed to absolute":function(){a('<p><img src="img/image1.jpg" /> Bar <img src="img/big/image2.png" /></p>','<p><img src="'+exportPdfUtils.toAbsoluteUrl("img/image1.jpg","http://ckeditor.com/ckeditor4/")+'" /> Bar <img src="'+exportPdfUtils.toAbsoluteUrl("img/big/image2.png","http://ckeditor.com/ckeditor4/")+'" /></p>',{baseHref:"http://ckeditor.com/ckeditor4/"})},
'test relative (to current url) image urls with custom baseHref and ".." are changed to absolute':function(){a('<p><img src="../img/image1.jpg" /> Bar <img src="../../img/big/image2.png" /></p>','<p><img src="'+exportPdfUtils.toAbsoluteUrl("img/image1.jpg","https://ckeditor.com/ckeditor4/")+'" /> Bar <img src="'+exportPdfUtils.toAbsoluteUrl("img/big/image2.png","https://ckeditor.com/")+'" /></p>',{baseHref:"https://ckeditor.com/ckeditor4/demo/"})}})})})();