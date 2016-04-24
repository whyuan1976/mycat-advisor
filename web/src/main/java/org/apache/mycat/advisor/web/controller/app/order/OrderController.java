package org.apache.mycat.advisor.web.controller.app.order;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.TabOrder;
import org.apache.mycat.advisor.service.app.order.ApiOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by cjl on 2016/4/20.
 */
@RestController
@RequestMapping("/app/order")
public class OrderController extends BaseController{


	ApiOrderService apiOrderService;


	@RequestMapping("index")
	public ResultMap index() {
		return success();
	}

	@RequestMapping("subscribe")
	public ResultMap subscribe(TabOrder order, @RequestParam Map<String, Object> param) {

		boolean flag = apiOrderService.newOrder(order);
		if (flag) {
			return success();
		}
		return failure();
	}
}
