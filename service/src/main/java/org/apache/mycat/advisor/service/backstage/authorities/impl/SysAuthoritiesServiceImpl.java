package org.apache.mycat.advisor.service.backstage.authorities.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.SysAuthoritiesMapper;
import org.apache.mycat.advisor.persistence.dao.SysAuthoritiesResourcesMapper;
import org.apache.mycat.advisor.persistence.model.SysAuthorities;
import org.apache.mycat.advisor.persistence.model.SysAuthoritiesResources;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.authorities.SysAuthoritiesService;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/20.
 */
@Service
public class SysAuthoritiesServiceImpl extends BaseServiceImpl<SysAuthorities> implements SysAuthoritiesService {
    @Autowired
    private SysAuthoritiesMapper sysAuthoritiesMapper;
    @Autowired
    private SysAuthoritiesResourcesMapper sysAuthoritiesResourcesMapper;

    @Override
    protected MyMapper<SysAuthorities> myMapper() {
        return sysAuthoritiesMapper;
    }

    @Override
    public Collection<GrantedAuthority> loadUserAuthorities(String username) {
        List<SysAuthorities> list = this.getSysAuthoritiesByUsername(username);

        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

        for (SysAuthorities authority : list) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthorityMark());
            auths.add(grantedAuthority);
        }

        return auths;
    }

    @Override
    public Page pageList(Map<String, Object> param) {
        pageBegin(param);
        Object code = param.get("code");
        String str="%%";
        if (code!=null&& StringUtils.isNotEmpty(code.toString())) {
            str = "%" + code + "%";
        }
        PageInfo pageInfo = new PageInfo(sysAuthoritiesMapper.findListByName(str));
        return twoPage(pageInfo);
    }

    @Override
    public String getResIds(Long id) {
        List<Long> ids = sysAuthoritiesMapper.findResIdsByAuthId(id);
        return JSON.toJSON(ids).toString();
    }

    @Override
    public boolean changeRes(Map<String, Object> param) {
        Object resId = param.get("resId");
        Object checked = param.get("checked");
        Object authId = param.get("authId");
        int i = 0;
        if (checked != null) {
            SysAuthoritiesResources authoritiesResources = new SysAuthoritiesResources();
            authoritiesResources.setAuthorityId(new Long(authId.toString()));
            authoritiesResources.setResourceId(new Long(resId.toString()));

            if ("true".equals(checked)) {
                //选中
                i = sysAuthoritiesResourcesMapper.insert(authoritiesResources);
            } else {
                //未选中
                i = sysAuthoritiesResourcesMapper.delete(authoritiesResources);
            }
        }


        return i > 0;
    }

    @Override
    public Page pageList(Map<String, Object> param, List<Long> authIds) {
        pageBegin(param);
        Object code = param.get("code");
        String str="%%";
        if (code!=null&& StringUtils.isNotEmpty(code.toString())) {
            str = "%" + code + "%";
        }
        List<Map<String,Object>> list = sysAuthoritiesMapper.findListByName(str);
        for (int i = 0; i < list.size(); i++) {
            Long authId = new Long(list.get(i).get("AUTHORITY_ID").toString());
            if (authIds.contains(authId)) {
                list.get(i).put("check", "checked");
            }
        }

        PageInfo pageInfo = new PageInfo(list);
        return twoPage(pageInfo);
    }


    private List<SysAuthorities> getSysAuthoritiesByUsername(String username){
        List<SysAuthorities> list = sysAuthoritiesMapper.findSysAuthoritiesByUsername(username);
        return list;
    }


}
