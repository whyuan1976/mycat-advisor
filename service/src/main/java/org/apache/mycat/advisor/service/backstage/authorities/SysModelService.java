package org.apache.mycat.advisor.service.backstage.authorities;

import org.apache.mycat.advisor.persistence.model.SysModules;
import org.apache.mycat.advisor.service.backstage.base.BaseService;

import java.util.List;

/**
 * Created by cjl on 2016/4/21.
 *
 * 系统模块
 */
public interface SysModelService extends BaseService<SysModules>{

    List<SysModules> tree();

    boolean save(SysModules info);

    List<SysModules> all();

    List<SysModules> tree(List<Long> modelId);
}
