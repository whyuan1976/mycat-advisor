package org.apache.mycat.advisor.service.backstage.um.userinfo;

import org.apache.mycat.advisor.common.security.shiro.dynamic.JdbcPermissionDao;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * package: org.apache.mycat.advisor.service.backstage.um.userinfo <br/>
 * functional describe:
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/4/26 14:51
 */
@Service
public class JdbcPermissionImp implements JdbcPermissionDao{
    @Override
    public LinkedHashMap<String, String> generateDefinitions() {
        return null;
    }

    @Override
    public Map<String, String> findDefinitionsMap() {
        return null;
    }
}
