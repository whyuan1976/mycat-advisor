package org.apache.mycat.advisor.web.controller.backstage.authorise;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.SysResources;
import org.apache.mycat.advisor.service.backstage.authorities.SysModelService;
import org.apache.mycat.advisor.service.backstage.authorities.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cjl on 2016/3/18.
 */
@RestController
@RequestMapping("/auth/res")
public class ResourceController extends BaseController {
    @Autowired
    SysResourceService resourceService;
    @Autowired
    SysModelService sysModelService;


    @RequestMapping("list")

    public ResultMap list(@RequestParam Map<String, Object> param) {
        Page page = resourceService.pageList(param);
        return sucess(page);
    }

    @RequestMapping("save")
    public ResultMap save(SysResources info) {
        if (resourceService.save(info)) {
            return success();
        } else {
            return failure("保存操作失败!");
        }
    }

    @RequestMapping("init")
    public ResultMap init() {
        Map<String, Object> data = new HashMap<>();
        data.put("modules", sysModelService.all());

        return success(data);
    }

    @RequestMapping("get/{id}")
    public ResultMap info(@PathVariable long id) {
        SysResources resources = resourceService.get(id);
        Map<String, Object> data = object2map(resources);
        data.put("modules", sysModelService.all());

        return success(data);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id) {
        if (resourceService.delete(id)) {
            return success();
        } else {
            return failure("删除操作失败！");
        }
    }


}
