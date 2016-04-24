package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.SysRolesMoudles;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;

/**
 * Created by cjl on 2016/3/20.
 */
public interface SysRolesMoudlesMapper extends MyMapper<SysRolesMoudles> {
    List<Long> findModelIdsByRoleId(long roleId);
}
