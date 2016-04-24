package org.apache.mycat.advisor.web.controller.backstage.um;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.TabUserLikeType;
import org.apache.mycat.advisor.service.backstage.um.userliketype.UserLikeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by qyp on 2016/4/4.
 */
@RestController
@RequestMapping("/um/userLikeType/")
public class UserLikeTypeController extends BaseController {
    @Autowired
    UserLikeTypeService userLikeTypeService;


    @SuppressWarnings("rawtypes")
	@RequestMapping("list")

    public ResultMap list(@RequestParam Map<String, Object> param) {
        Page page = userLikeTypeService.page(param);
        return sucess(page);
    }


    @RequestMapping("init")
    public ResultMap init() {
        return success();
    }

    @RequestMapping("get/{id}")
    public ResultMap info(@PathVariable long id) {
        TabUserLikeType UserLikeType = userLikeTypeService.get(id);
        return success(UserLikeType);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id) {
        if (userLikeTypeService.delete(id)) {
            return success();
        } else {
            return failure("删除操作失败！");
        }
    }


}
