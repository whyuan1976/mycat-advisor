package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.SysRolesAuthorities;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;

/**
 * Created by cjl on 2016/3/20.
 */
public interface SysRolesAuthoritiesMapper extends MyMapper<SysRolesAuthorities> {
    List<Long> findAuthIdsByRoleId(long roleId);
}
