package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.SysAuthorities;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/20.
 */
public interface SysAuthoritiesMapper extends MyMapper<SysAuthorities> {
    List<SysAuthorities> findSysAuthoritiesByUsername(String username);

    List<Map<String,Object>> findListByName(String name);

    List<Long> findResIdsByAuthId(Long id);
}
