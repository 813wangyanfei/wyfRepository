/**
 * 宸ュ叿绫�
 * @author yzzhouyalei@foxmail.com
 * Copyright (c) 2016-6-2 by 鍖椾含鐩栧嫆鍏嬫柉鐜繚绉戞妧鏈夐檺鍏徃
 */

/**
 * 杈呭姪甯冨眬
 */
function layout_support(){
	$.each($(".layout"),function(i,v){
		var w = $(window).width();
		var h = $(window).height();
		var pw = $(this).parent().width();
		var ph = $(window).parent().height();
		var ew = $(this).attr("data_w"),eh = $(this).attr("data_h"),elh = $(this).attr("data_lh");
		if(ew!=undefined)
			$(this).css({"width":eval("("+ew+")")});
		if(eh!=undefined)
			$(this).css({"height":eval("("+eh+")")});
		if(elh!=undefined)
			$(this).css({"line-height":eval("("+elh+")")+"px"});
	});
}