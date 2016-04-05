package org.apache.mycat.advisor.web.controller.um;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.service.um.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cjl on 2016/3/18.
 */
@RestController
@RequestMapping("/um/userInfo/")
public class UserInfoController extends BaseController {
    @Autowired
    UserInfoService userInfoService;


    @RequestMapping("list")

    public ResultMap list(@RequestParam Map<String, Object> param) {
        Page page = userInfoService.page(param);
        return sucess(page);
    }

    @RequestMapping("save")
    public ResultMap save(TabUserInfo info) {
        if (userInfoService.saveOrUpdate(info)) {
            return success();
        } else {
            return failure("保存操作失败!");
        }
    }

    @RequestMapping("init")
    public ResultMap init() {
        return success();
    }

    @RequestMapping("get/{id}")
    public ResultMap info(@PathVariable long id) {
        TabUserInfo type = userInfoService.get(id);
        return success(type);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id) {
        if (userInfoService.delete(id)) {
            return success();
        } else {
            return failure("删除操作失败！");
        }
    }
    
    @RequestMapping("getUserByName")
    public List<Map<String,Object>> getUserByName(String query){
    	List<TabUserInfo> userList = userInfoService.getAllByUsername(query);
    	List<Map<String,Object>> users = new ArrayList<>();
    	for(TabUserInfo userInfo : userList){
    		Map<String,Object> temp = new HashMap<>();
    		temp.put("id", userInfo.getId());
    		temp.put("name", userInfo.getUsername());
    		users.add(temp);
    	}
    	
    	return users;
    }


}
