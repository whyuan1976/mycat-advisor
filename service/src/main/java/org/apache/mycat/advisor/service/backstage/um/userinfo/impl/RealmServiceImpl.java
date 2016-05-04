package org.apache.mycat.advisor.service.backstage.um.userinfo.impl;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.security.shiro.authentication.RealmService;
import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.um.userinfo.RealmServiceWrapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

/**
 * package: org.apache.mycat.advisor.service.backstage.um.userinfo.impl <br/>
 * functional describe:
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/4/26 13:54
 */
@Service("realmService")
public class RealmServiceImpl extends BaseServiceImpl<TabUserInfo> implements RealmServiceWrapper{
    @Override
    public Object getUniqueIdentity(String userName) {
        return null;
    }

    @Override
    public Object getUserPassword(String userName) {
        return null;
    }

    @Override
    public Map<String, Object> getUserUniqueIdentityAndPassword(String userName) {
        return null;
    }

    @Override
    public Collection<String> getPermissions(Object uniqueIdentity) {
        return null;
    }

    @Override
    public Collection<String> getRoles(Object uniqueIdentity) {
        return null;
    }

    @Override
    public Map<String, Collection<String>> getUserRolesAndPerms(Object uniqueIdentity) {
        return null;
    }

    @Override
    protected MyMapper<TabUserInfo> myMapper() {
        return null;
    }
}
