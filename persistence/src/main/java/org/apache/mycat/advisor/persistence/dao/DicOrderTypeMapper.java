package org.apache.mycat.advisor.persistence.dao;

import java.util.List;

import org.apache.mycat.advisor.persistence.model.DicOrderType;
import org.apache.mycat.advisor.persistence.util.MyMapper;


public interface DicOrderTypeMapper extends MyMapper<DicOrderType> {

	public List<DicOrderType> listByName(DicOrderType orderType);
}

