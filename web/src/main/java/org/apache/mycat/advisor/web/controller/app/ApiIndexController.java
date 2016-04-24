package org.apache.mycat.advisor.web.controller.app;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cjl on 2016/4/20.
 */
@RestController
@RequestMapping("/app/")
public class ApiIndexController extends BaseController{

	@RequestMapping("index")
	public ResultMap index() {
		return success();
	}
}
