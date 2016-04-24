define(function(require, exports, module) {
	var pageHepler = require('../common/page-helper');
	var self = exports;
	mui.init({  
                preloadPages: [{//预加载目标页面  
                    'url': 'adviser/company_service_order.html',  
                    'id': 'adviser/company_service_order.html'  
                }]  
    });  

	pageHepler.init({
		handler: self
	});
});