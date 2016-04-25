define(function(require, exports, module) {

	//设置状态栏颜色(for ios)
	mui.init({
		"statusBarBackground": "#099FDE"
	});

	mui.plusReady(function() {
		plus.navigator.setStatusBarStyle("UIStatusBarStyleBlackOpaque");
		
	});

	
	var utils = require('../../libs/utils.js');
	var pageHepler = require('../../common/page-helper');
	
	var skillFilter = require('../../controls/skill-filter/main');


	//mui('.normal').addClass("mui-hidden");
	var self = exports;

	self.services = [{
		name: '产品设计',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}, {
		name: '软件架构设计',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:1
	}, {
		name: '数据库',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}, {
		name: '项目监管',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}, {
		name: '系统运维',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}, {
		name: '产品推广',
		detail:'产品设计说明。这里是详细说明。很多字哦。没力气写了。就这么点吧。差旅补贴另计。。。',
		price: "现场服务：0.5~3w/天   &nbsp;&nbsp;在线服务：1~3K/天  &nbsp;&nbsp;不包含差旅费",
		selected:0
	}];
	
	self.pickService = function(index) {
		var tmp = self.services[index];
		tmp.selected = tmp.selected == 0? 1:0;

	};

	//初始化页面辅助模块
	pageHepler.init({
		handler: self,
		mvvm: true
	});



});