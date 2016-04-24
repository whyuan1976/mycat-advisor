package org.apache.mycat.advisor.service.backstage.authorities.impl;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.SysResourcesMapper;
import org.apache.mycat.advisor.persistence.model.SysResources;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.authorities.SysResourceService;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/20.
 */
@Service
public class SysResourceServiceImpl extends BaseServiceImpl<SysResources> implements SysResourceService {
    @Autowired
    private SysResourcesMapper mapper;

    @Override
    protected MyMapper<SysResources> myMapper() {
        return mapper;
    }


    @Override
    public Page pageList(Map<String, Object> param) {
        pageBegin(param);
        Object code = param.get("code");
        String str="%%";
        if (code!=null&& StringUtils.isNotEmpty(code.toString())) {
            str = "%" + code + "%";
        }
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(mapper.selectByNameAndCode(str));

        return twoPage(pageInfo);
    }

    @Override
    public boolean save(SysResources info) {
        int i = 0;
        if (info.getResourceId() != null) {
            i = mapper.updateByPrimaryKey(info);
        } else {
            i = mapper.insert(info);
        }
        return i>0;
    }

    @Override
    public Page pageList(Map<String, Object> param, String resIds) {
        pageBegin(param);
        Object code = param.get("code");
        String str="%%";
        if (code!=null&& StringUtils.isNotEmpty(code.toString())) {
            str = "%" + code + "%";
        }
        List<Map<String, Object>> list = mapper.selectByNameAndCode(str);
        if (resIds!=null&&StringUtils.isNotEmpty(resIds)) {
            for (int i = 0; i < list.size(); i++) {
                String id = list.get(i).get("RESOURCE_ID").toString();
                if (resIds.indexOf(id) > -1) {
                    list.get(i).put("check", "checked");
                }
            }
        }

        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);

        return twoPage(pageInfo);
    }
}
