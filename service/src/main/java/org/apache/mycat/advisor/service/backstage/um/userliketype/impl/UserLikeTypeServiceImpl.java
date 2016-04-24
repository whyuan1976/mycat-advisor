package org.apache.mycat.advisor.service.backstage.um.userliketype.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.TabUserLikeTypeMapper;
import org.apache.mycat.advisor.persistence.model.TabUserLikeType;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.um.userliketype.UserLikeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by qyp on 2016/4/4.
 */
@Service
public class UserLikeTypeServiceImpl extends BaseServiceImpl<TabUserLikeType> implements UserLikeTypeService {
    @Autowired
    TabUserLikeTypeMapper mapper;

    @Override
    protected MyMapper<TabUserLikeType> myMapper() {
        return this.mapper;
    }

    @Override
    public Page<TabUserLikeType> page(Map<String, Object> param) {
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
        TabUserLikeType userLikeType=new TabUserLikeType();
        userLikeType.setUserName(name);
        PageHelper.startPage(pageIndex + 1, pageCount);
        PageInfo<TabUserLikeType> pageInfo = new PageInfo<TabUserLikeType>(mapper.listByUserNameAndTypeCode(userLikeType));
        return twoPage(pageInfo);
    }
}
