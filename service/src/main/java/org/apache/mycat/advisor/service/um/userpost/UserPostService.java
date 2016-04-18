package org.apache.mycat.advisor.service.um.userpost;

import org.apache.mycat.advisor.persistence.model.TabPostInfo;
import org.apache.mycat.advisor.service.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/3/18.
 */
public interface UserPostService extends BaseService<TabPostInfo> {
    public boolean save(TabPostInfo o);

    List<Map<String,Object>> findByName(String query);
}
