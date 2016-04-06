package org.apache.mycat.advisor.service.um.company;

import org.apache.mycat.advisor.persistence.model.TabCompany;
import org.apache.mycat.advisor.service.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/22.
 */
public interface UserCompanyService extends BaseService<TabCompany> {
    public boolean save(TabCompany o);

    List<Map<String,Object>> findListMapByName(String query);

    List<TabCompany> all();
}
