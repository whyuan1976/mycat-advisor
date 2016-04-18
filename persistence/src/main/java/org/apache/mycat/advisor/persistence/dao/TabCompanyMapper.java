package org.apache.mycat.advisor.persistence.dao;

import org.apache.mycat.advisor.persistence.model.TabCompany;
import org.apache.mycat.advisor.persistence.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface TabCompanyMapper extends MyMapper<TabCompany> {

    List<Map<String,Object>> findIdAndNameByName(String name);
}