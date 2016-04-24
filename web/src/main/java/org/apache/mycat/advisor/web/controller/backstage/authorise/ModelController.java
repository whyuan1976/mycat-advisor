package org.apache.mycat.advisor.web.controller.backstage.authorise;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.SysModules;
import org.apache.mycat.advisor.service.backstage.authorities.SysModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cjl on 2016/3/18.
 */
@RestController
@RequestMapping("/auth/model")
public class ModelController extends BaseController {
    @Autowired
    SysModelService modelService;

    @RequestMapping("list")

    public ResultMap list() {
        List list = modelService.tree();
        return success(list);
    }

    @RequestMapping("save")
    public ResultMap save(SysModules info) {
        if (modelService.save(info)) {
            return success();
        } else {
            return failure("保存操作失败!");
        }
    }

    @RequestMapping("init/{id}")
    public ResultMap init(@PathVariable long id) {
        SysModules modules = new SysModules();
        modules.setParent(id);
        return success(modules);
    }

    @RequestMapping("get/{id}")
    public ResultMap info(@PathVariable long id) {
        SysModules modules = modelService.get(id);
        return success(modules);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id) {
        if (modelService.delete(id)) {
            return success();
        } else {
            return failure("删除操作失败！");
        }
    }


}
