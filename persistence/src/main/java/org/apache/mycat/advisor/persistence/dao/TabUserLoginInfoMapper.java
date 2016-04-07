package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabUserLoginInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;

public interface TabUserLoginInfoMapper extends MyMapper<TabUserLoginInfo> {
	 public List<TabUserLoginInfo> listByUserName(TabUserLoginInfo userLoginInfo);
}