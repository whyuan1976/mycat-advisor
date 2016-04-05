package org.apache.mycat.advisor.persistence.dao;

import java.util.List;

import org.apache.mycat.advisor.persistence.model.TabOrder;
import org.apache.mycat.advisor.persistence.util.MyMapper;

public interface TabOrderMapper extends MyMapper<TabOrder> {
	
	 public List<TabOrder> listByType(TabOrder tabOrder);

	public TabOrder getOrderInfoById(long id);
}