package org.apache.mycat.advisor.service.um.userinfo;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.service.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/20.
 */
public interface UserInfoService extends BaseService<TabUserInfo> {
    TabUserInfo findUserByUsername(String userName);

    List<TabUserInfo> findAll();

    TabUserInfo findByUsernameAndPassword(String email, String password);

    public boolean save(TabUserInfo o);

    Page<Map> pageList(Map<String, Object> param);

    List<Map<String,Object>> findListMapByUserName(String query);
    
    List<TabUserInfo> getAllByUsername(String name);

}
