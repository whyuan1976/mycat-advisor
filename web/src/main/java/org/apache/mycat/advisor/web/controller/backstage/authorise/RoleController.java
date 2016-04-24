package org.apache.mycat.advisor.web.controller.backstage.authorise;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.SysModules;
import org.apache.mycat.advisor.persistence.model.SysRoles;
import org.apache.mycat.advisor.service.backstage.authorities.SysAuthoritiesService;
import org.apache.mycat.advisor.service.backstage.authorities.SysModelService;
import org.apache.mycat.advisor.service.backstage.authorities.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/18.
 */
@RestController
@RequestMapping("/auth/role")
public class RoleController extends BaseController {
    @Autowired
    SysRoleService roleService;
    @Autowired
    SysModelService modelService;
    @Autowired
    SysAuthoritiesService authoritiesService;

    @RequestMapping("list")

    public ResultMap list(@RequestParam Map<String,Object> map) {
        Page page = roleService.pageList(map);
        return success(page);
    }

    @RequestMapping("save")
    public ResultMap save(SysRoles info) {
        if (roleService.saveOrUpdate(info)) {
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
        SysRoles roles = roleService.get(id);
        return success(roles);
    }

    @RequestMapping("auth/{id}")
    public ResultMap auth(@PathVariable long id,@RequestParam Map<String,Object> map) {
        List<Long> authId = roleService.getAuthIdsByRoleId(id);
        Page page = authoritiesService.pageList(map, authId);
        Map<String, Object> data = new HashMap<>();
        data.put("roleId", id);
        data.putAll(map);
        return sucess(page,data);
    }

    @RequestMapping("changeAuth")
    public ResultMap changeAuth(@RequestParam Map<String, Object> map) {
        if (roleService.changeAuth(map)) {
            return success();
        }

        return failure();
    }

    @RequestMapping("changeModel")
    public ResultMap changeModel(@RequestParam Map<String, Object> map) {
        if (roleService.changeModel(map)) {
            return success();
        }

        return failure();
    }

    @RequestMapping("model/{id}")
    public ResultMap model(@PathVariable long id,@RequestParam Map<String,Object> map) {
        List<Long> modelId = roleService.getModelIdByRoleId(id);
        List<SysModules> list = modelService.tree(modelId);
        Map<String, Object> data = new HashMap<>();
        data.put("list", list);
        data.put("roleId", id);
        data.putAll(map);
        return success(data);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id) {
        if (roleService.delete(id)) {
            return success();
        } else {
            return failure("删除操作失败！");
        }
    }


}
