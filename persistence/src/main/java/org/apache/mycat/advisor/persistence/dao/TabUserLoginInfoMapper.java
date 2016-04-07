<<<<<<< HEAD
package org.apache.mycat.advisor.persistence.dao;

import java.util.List;

import org.apache.mycat.advisor.persistence.model.TabUserLoginInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;

public interface TabUserLoginInfoMapper extends MyMapper<TabUserLoginInfo> {
	 public List<TabUserLoginInfo> listByUserName(TabUserLoginInfo userLoginInfo);
=======
package org.apache.mycat.advisor.persistence.dao;

import java.util.List;

import org.apache.mycat.advisor.persistence.model.TabUserLoginInfo;
import org.apache.mycat.advisor.persistence.util.MyMapper;

public interface TabUserLoginInfoMapper extends MyMapper<TabUserLoginInfo> {
	 public List<TabUserLoginInfo> listByUserName(TabUserLoginInfo userLoginInfo);
>>>>>>> MyCATApache/master
}