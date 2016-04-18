package org.apache.mycat.advisor.persistence.dao;

import java.util.List;

import org.apache.mycat.advisor.persistence.model.TabUserLikeConsultant;
import org.apache.mycat.advisor.persistence.util.MyMapper;

public interface TabUserLikeConsultantMapper extends MyMapper<TabUserLikeConsultant> {
	public List<TabUserLikeConsultant> listByUserName(TabUserLikeConsultant tabUserLikeConsultant);
}