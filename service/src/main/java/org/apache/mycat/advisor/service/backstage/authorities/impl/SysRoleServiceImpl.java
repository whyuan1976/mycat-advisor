package org.apache.mycat.advisor.service.backstage.authorities.impl;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.SysRolesAuthoritiesMapper;
import org.apache.mycat.advisor.persistence.dao.SysRolesMapper;
import org.apache.mycat.advisor.persistence.dao.SysRolesMoudlesMapper;
import org.apache.mycat.advisor.persistence.model.SysRoles;
import org.apache.mycat.advisor.persistence.model.SysRolesAuthorities;
import org.apache.mycat.advisor.persistence.model.SysRolesMoudles;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.authorities.SysRoleService;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/20.
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoles> implements SysRoleService {
    @Autowired
    private SysRolesMapper mapper;
    @Autowired
    private SysRolesMoudlesMapper rolesMoudlesMapper;
    @Autowired
    private SysRolesAuthoritiesMapper rolesAuthoritiesMapper;

    @Override
    protected MyMapper<SysRoles> myMapper() {
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
        List<Map<String, Object>> list = mapper.selectByNameAndCode(str);
       /* if (resIds!=null&&StringUtils.isNotEmpty(resIds)) {
            for (int i = 0; i < list.size(); i++) {
                String id = list.get(i).get("RESOURCE_ID").toString();
                if (resIds.indexOf(id) > -1) {
                    list.get(i).put("check", "checked");
                }
            }
        }*/

        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);

        return twoPage(pageInfo);
    }

    @Override
    public boolean save(SysRoles info) {
        int i = 0;
        if (info.getModuleId() != null) {
            mapper.updateByPrimaryKey(info);
        } else {
            mapper.insert(info);
        }

        return false;
    }

    @Override
    public List<Long> getModelIdByRoleId(long roleId) {
        List<Long> modelIds = rolesMoudlesMapper.findModelIdsByRoleId(roleId);

        return modelIds;
    }

    @Override
    public List<Long> getAuthIdsByRoleId(long roleId) {
        List<Long> authIds = rolesAuthoritiesMapper.findAuthIdsByRoleId(roleId);
        return authIds;
    }

    @Override
    public boolean changeModel(Map<String, Object> param) {
        Object roleId = param.get("roleId");
        Object checked = param.get("checked");
        Object modelId = param.get("modelId");
        int i = 0;
        if (checked != null) {
            SysRolesMoudles rolesMoudles = new SysRolesMoudles();
            rolesMoudles.setModuleId(new Long(modelId.toString()));
            rolesMoudles.setRoleId(new Long(roleId.toString()));

            if ("true".equals(checked)) {
                //选中
                i = rolesMoudlesMapper.insert(rolesMoudles);
            } else {
                //未选中
                i = rolesMoudlesMapper.delete(rolesMoudles);
            }
        }


        return i > 0;
    }

    @Override
    public boolean changeAuth(Map<String, Object> param) {
        Object roleId = param.get("roleId");
        Object checked = param.get("checked");
        Object authId = param.get("authId");
        int i = 0;
        if (checked != null) {
            SysRolesAuthorities rolesAuthorities = new SysRolesAuthorities();

            rolesAuthorities.setAuthorityId(new Long(authId.toString()));
            rolesAuthorities.setRoleId(new Long(roleId.toString()));

            if ("true".equals(checked)) {
                //选中
                i = rolesAuthoritiesMapper.insert(rolesAuthorities);
            } else {
                //未选中
                i = rolesAuthoritiesMapper.delete(rolesAuthorities);
            }
        }


        return i > 0;
    }
}
