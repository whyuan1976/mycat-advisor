package org.apache.mycat.advisor.service.backstage.authorities;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.model.SysRoles;
import org.apache.mycat.advisor.service.backstage.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/4/21.
 *
 * 系统角色
 */
public interface SysRoleService extends BaseService<SysRoles>{
    Page pageList(Map<String, Object> map);

    boolean save(SysRoles info);

    List<Long> getModelIdByRoleId(long id);

    List<Long> getAuthIdsByRoleId(long id);

    boolean changeModel(Map<String, Object> map);

    boolean changeAuth(Map<String, Object> map);
}
