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
	var skillFilter = require('../controls/skill-filter/main');



	var self = exports;

	self.dayNum = 1;
	self.menNum = 1;
	self.beginDate = utils.formatDate(new Date(), 'yyyy-MM-dd');

	var calcEndDate = function() {
		var endDate = new Date(self.beginDate);
		endDate.setDate(endDate.getDate() + self.dayNum);
		self.endDate = utils.formatDate(endDate, 'yyyy-MM-dd');
	};
	calcEndDate();

	//更改入住天数
	self.changeDayNum = function(event) {
		self.dayNum = parseInt(event.target.value);
		calcEndDate();
	};
	
	
	//更改人数
	self.changeMenNum = function(event) {
		self.menNum = parseInt(event.target.value);
		
	};

	//选择日期
	self.pickeDate = function(event, x) {
		var currentYear = (new Date()).getFullYear();
		self.dtPicker = self.dtPicker || new mui.DtPicker({
			"type": "date",
			"beginYear": currentYear,
			"endYear": currentYear + 1
		});
		self.dtPicker.show(function(rs) {
			self.beginDate = rs.value;
			calcEndDate();
		});
	};

	self.priceRange = hotelPriceFilter.priceRange;
	self.star = hotelPriceFilter.star;
	self.languageRange = skillFilter.languageRange;
	self.platform = skillFilter.platform;
	self.computed = {
		priceAndStar: function() {
			if (self.star.value == 0 &&
				self.priceRange.value == 0) {
				return "价格/星级";
			} else {
				return self.priceRange.text + "," + self.star.text;
			}
		},
		
		skill: function() {
			if (self.languageRange.value == 0 &&
				self.platform.value == 0) {
				return "技术要求";
			} else {
				return self.languageRange.text + "," + self.platform.text;
			}
		},
		
		paymentStr: function() {
			if (self.payment == undefined) {
				return "付款方式";
			} else {
				return self.payment.text;
			}
		}
	};

	//设置价格过滤条件
	self.setPriceFilter = function() {
		hotelPriceFilter.show(function(rs) {
			self.priceRange = rs.priceRange;
			self.star = rs.star;
		});
	};

	//设置技术要求条件
	self.setSkillFilter = function() {
		skillFilter.show(function(rs) {
			self.languageRange = rs.languageRange;
			self.platform = rs.platform;
		});
	};



		
	//设置技术要求条件
	self.setPaymentMethod = function() {
		if (!self.payment) {
			self.payment = new mui.PopPicker();
					self.payment.setData([{
						value: '1',
						text: '每月支付'
					}, {
						value: '2',
						text: '每2月支付'
					}, {
						value: '3',
						text: '一次性支付'
					}, {
						value: '4',
						text: '分三次支付'
					}]);
		}
		self.payment.show(function() {});
		
		

	};
	self.setInvoice = function() {
		if (!self.iPicker) {
			self.iPicker = new mui.PopPicker();
			self.iPicker.setData([{
				text: "不需要"
			}, {
				text: "到店领取"
			}]);
		}
		self.iPicker.show(function() {});
	};

	self.setRequirement = function() {
		if (window.plus) {
			plus.nativeUI.prompt("请填写您的要求", function() {
				//TODO: 
			}, "特殊要求", "", ["确认", "取消"]);
		} else {
			var rs = prompt("请填写您的要求");
			//TODO:
		}
	};


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
		//plus.navigator.closeSplashscreen();
	});

});