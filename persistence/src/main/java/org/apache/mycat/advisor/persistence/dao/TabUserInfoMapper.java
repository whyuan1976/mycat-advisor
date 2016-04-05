package org.apache.mycat.advisor.persistence.dao;

import java.util.List;

import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;

public interface TabUserInfoMapper extends MyMapper<TabUserInfo> {
	public List<TabUserInfo> getAllByName(TabUserInfo user);
}