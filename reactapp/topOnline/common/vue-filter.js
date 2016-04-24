define(function(require, exports, module) {
	var utils = require('../libs/utils.js');

	exports.date = function(value) {
		var theDate = new Date(value);
		var theDateNum = parseInt(utils.formatDate(theDate, "yyyyMMdd"));
		var todayNum = parseInt(utils.formatDate(new Date(), "yyyyMMdd"));
		if (todayNum == theDateNum) {
			return '今天';
		} else if (todayNum - theDateNum == 1) {
			return "昨天";
		} else if (todayNum - theDateNum == 2) {
			return "前天";
		} else if (todayNum - theDateNum == -1) {
			return "明天";
		} else if (todayNum - theDateNum == -2) {
			return "后天";
		} else {
			return utils.formatDate(theDate, 'MM月dd日');
		}
	};

	exports.week = function(value) {
		var theDate = new Date(value);
		var weekIndex = theDate.getDay();
		return ["日", "一", "二", "三", "四", "五", "六"][weekIndex];
	};
	
	exports.month = function(value) {
		var theDate = new Date(value);
		var monthIndex = theDate.getMonth();
		return ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"][monthIndex];
	};

});