package org.apache.mycat.advisor.service.backstage.authorities;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.model.SysResources;
import org.apache.mycat.advisor.service.backstage.base.BaseService;

import java.util.Map;

/**
 * Created by cjl on 2016/4/21.
 *
 * 系统资源
 */
public interface SysResourceService extends BaseService<SysResources>{
    Page pageList(Map<String, Object> param);

    boolean save(SysResources info);

    Page pageList(Map<String, Object> param, String resIds);
}
