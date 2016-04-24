package org.apache.mycat.advisor.service.backstage.um.userlikeconsultant.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.TabUserLikeConsultantMapper;
import org.apache.mycat.advisor.persistence.model.TabUserLikeConsultant;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.um.userlikeconsultant.UserLikeConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by qyp on 2016/4/4.
 */
@Service
public class UserLikeConsultantServiceImpl extends BaseServiceImpl<TabUserLikeConsultant> implements UserLikeConsultantService {
    @Autowired
    TabUserLikeConsultantMapper mapper;

    @Override
    protected MyMapper<TabUserLikeConsultant> myMapper() {
        return this.mapper;
    }

    @Override
    public Page<TabUserLikeConsultant> page(Map<String, Object> param) {
        int pageIndex = 0;
        int pageCount = 8;
        Object tmpIndex = param.get("pageIndex");
        Object tmpCount = param.get("pageCount");
        if (tmpIndex != null && StringUtils.isNotEmpty(tmpIndex.toString())) {
            pageIndex = Integer.parseInt(tmpIndex.toString());
        }
        if (tmpCount != null && StringUtils.isNotEmpty(tmpCount.toString())) {
            pageCount = Integer.parseInt(tmpCount.toString());
        }
        Object tmpstr = param.get("name");
        String name = "";
        if (tmpstr != null && StringUtils.isNotEmpty(tmpstr.toString())) {
            name =tmpstr.toString();
        }
        TabUserLikeConsultant userLikeConsultant=new TabUserLikeConsultant();
        userLikeConsultant.setUserName(name);
        PageHelper.startPage(pageIndex + 1, pageCount);
        PageInfo<TabUserLikeConsultant> pageInfo = new PageInfo<TabUserLikeConsultant>(mapper.listByUserName(userLikeConsultant));
        return twoPage(pageInfo);
    }
}
