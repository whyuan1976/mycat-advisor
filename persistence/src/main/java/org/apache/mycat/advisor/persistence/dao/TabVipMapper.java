package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabVip;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface TabVipMapper extends MyMapper<TabVip> {

    List<Map<String,Object>> findListByUserName(String username);
}