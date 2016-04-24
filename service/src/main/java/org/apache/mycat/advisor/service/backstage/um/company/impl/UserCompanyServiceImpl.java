package org.apache.mycat.advisor.service.backstage.um.company.impl;

import org.apache.mycat.advisor.persistence.dao.TabCompanyMapper;
import org.apache.mycat.advisor.persistence.model.TabCompany;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.um.company.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/22.
 */
@Service
public class UserCompanyServiceImpl extends BaseServiceImpl<TabCompany> implements UserCompanyService {
    @Autowired
    TabCompanyMapper mapper;


    @Override
    protected MyMapper<TabCompany> myMapper() {
        return mapper;
    }

    public boolean save(TabCompany o) {
        if (o.getId() != null) {
            o.setUpdateTime(new Date());
        } else {
            o.setInsertTime(new Date());
            o.setUpdateTime(new Date());
            o.setDelFlag(0);
        }
        return super.saveOrUpdate(o);
    }

    @Override
    public List<Map<String, Object>> findListMapByName(String query) {
        List<Map<String, Object>> list = mapper.findIdAndNameByName("%"+query+"%");

        return list;
    }

    @Override
    public List<TabCompany> all() {
        return mapper.selectAll();
    }
}
