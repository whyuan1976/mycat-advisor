package org.apache.mycat.advisor.service.backstage.vip.vipinfo.impl;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.TabVipMapper;
import org.apache.mycat.advisor.persistence.model.TabVip;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.vip.vipinfo.VipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by cjl on 2016/3/31.
 */
@Service
public class VipInfoServiceImpl extends BaseServiceImpl<TabVip> implements VipInfoService{
    @Autowired
    TabVipMapper mapper;

    @Override
    protected MyMapper<TabVip> myMapper() {
        return this.mapper;
    }

    @Override
    public Page pageList(Map<String, Object> param) {
        this.pageBegin(param);
        Object code = param.get("code");
        String str="%%";
        if (code!=null&& StringUtils.isNotEmpty(code.toString())) {
            str = "%" + code + "%";
        }
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(mapper.findListByUserName(str));
        return twoPage(pageInfo);
    }
}
