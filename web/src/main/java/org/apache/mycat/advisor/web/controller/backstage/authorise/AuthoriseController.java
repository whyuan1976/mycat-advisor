package org.apache.mycat.advisor.web.controller.backstage.authorise;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.SysAuthorities;
import org.apache.mycat.advisor.service.backstage.authorities.SysAuthoritiesService;
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
@RequestMapping("/auth/auth")
public class AuthoriseController extends BaseController {
    @Autowired
    SysAuthoritiesService authoritiesService;
    @Autowired
    SysModelService sysModelService;
    @Autowired
    SysResourceService resourceService;

    @RequestMapping("list")

    public ResultMap list(@RequestParam Map<String, Object> param) {
        Page page = authoritiesService.pageList(param);
        return sucess(page);
    }
    @RequestMapping("res/{id}")

    public ResultMap res(@PathVariable long id,@RequestParam Map<String, Object> param) {
        String resIds = authoritiesService.getResIds(id);
        Page page = resourceService.pageList(param, resIds);
        Map<String, Object> data = new HashMap<>();
        data.put("authId", id);
        data.putAll(param);
        return sucess(page, data);
    }

    @RequestMapping("changeRes")
    public ResultMap changeRes(@RequestParam Map<String, Object> param) {
        if (authoritiesService.changeRes(param)) {
            return success();
        }
        return failure();
    }

    @RequestMapping("save")
    public ResultMap save(SysAuthorities info) {

        if (authoritiesService.saveOrUpdate(info)) {
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
        SysAuthorities authorities = authoritiesService.get(id);
        Map<String, Object> data = object2map(authorities);
        data.put("modules", sysModelService.all());
        return success(data);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id) {
        if (authoritiesService.delete(id)) {
            return success();
        } else {
            return failure("删除操作失败！");
        }
    }


}
