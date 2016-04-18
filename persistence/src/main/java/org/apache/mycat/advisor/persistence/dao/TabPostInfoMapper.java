package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabPostInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface TabPostInfoMapper  extends MyMapper<TabPostInfo> {

    List<Map<String,Object>> getIdAndNameByName(String name);
}