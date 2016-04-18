package org.apache.mycat.advisor.service.vip.vipinfo;

import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.model.TabVip;
import org.apache.mycat.advisor.service.base.BaseService;

import java.util.Map;

/**
 * Created by cjl on 2016/3/31.
 */
public interface VipInfoService extends BaseService<TabVip> {

    Page pageList(Map<String, Object> param);
}
