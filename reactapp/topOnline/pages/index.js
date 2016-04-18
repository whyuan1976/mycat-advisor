define(function(require, exports, module) {

	//设置状态栏颜色(for ios)
	mui.init({
		"statusBarBackground": "#099FDE"
	});

	mui.plusReady(function() {
		plus.navigator.setStatusBarStyle("UIStatusBarStyleBlackOpaque");
	});

	var utils = require('../libs/utils.js');
	var pageHepler = require('../common/page-helper');
	var hotelPriceFilter = require('../controls/hotel-price-filter/main');


	//初始化页面辅助模块
	pageHepler.init({
		handler: self,
		mvvm: true
	});

	mui.plusReady(function() {
		//连续按下两次返回键退出应用
		mui.oldBack = mui.back;
		var backButtonPress = 0;

		mui.back = function() {
			backButtonPress++;
			if (backButtonPress > 1) {
				plus.runtime.quit();
			} else {
				plus.nativeUI.toast('再按一次退出应用', {
					duration: 'short'
				});
			}
			setTimeout(function() {
				backButtonPress = 0;
			}, 1000);
			return false;
		};
		//关闭 splash 画面
		plus.navigator.closeSplashscreen();
	});

});