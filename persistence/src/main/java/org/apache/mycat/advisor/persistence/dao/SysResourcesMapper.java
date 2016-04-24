package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.SysResources;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/20.
 */
public interface SysResourcesMapper extends MyMapper<SysResources> {
    List<Map<String,Object>> selectByNameAndCode(String name);
}
