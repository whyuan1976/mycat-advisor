package org.apache.mycat.advisor.persistence.dao;

import java.util.List;

import org.apache.mycat.advisor.persistence.model.TabUserLikeType;
import org.apache.mycat.advisor.persistence.util.MyMapper;

public interface TabUserLikeTypeMapper extends MyMapper<TabUserLikeType> {
	 public List<TabUserLikeType> listByUserNameAndTypeCode(TabUserLikeType tabUserLikeType);
}