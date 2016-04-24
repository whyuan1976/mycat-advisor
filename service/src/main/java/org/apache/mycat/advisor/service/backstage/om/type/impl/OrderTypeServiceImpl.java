package org.apache.mycat.advisor.service.backstage.om.type.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.persistence.dao.DicOrderTypeMapper;
import org.apache.mycat.advisor.persistence.model.DicOrderType;
import org.apache.mycat.advisor.persistence.util.MyMapper;
import org.apache.mycat.advisor.service.backstage.base.BaseServiceImpl;
import org.apache.mycat.advisor.service.backstage.om.type.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderTypeServiceImpl extends BaseServiceImpl<DicOrderType> implements
		OrderTypeService {
	
	@Autowired
	private DicOrderTypeMapper mapper;
	
	@Override
	protected MyMapper<DicOrderType> myMapper() {
		return mapper;
	}

	@Override
	public boolean save(DicOrderType type) {
		type.setStatus(1);
		type.setDelFlag(0);
		return super.saveOrUpdate(type);
	}
	
	
	@Override
	public Page<DicOrderType> page(Map<String, Object> param) {
		int pageIndex = 0;
        int pageCount = 8;
        Object tmpIndex = param.get("pageIndex");
        Object tmpCount = param.get("pageCount");
        if (tmpIndex != null && StringUtils.isNotEmpty(tmpIndex.toString())) {
            pageIndex = Integer.parseInt(tmpIndex.toString());
        }
        if (tmpCount != null && StringUtils.isNotEmpty(tmpCount.toString())) {
            pageCount = Integer.parseInt(tmpCount.toString());
        }
        String name = (String) param.get("name");
        DicOrderType orderType = new DicOrderType();
        if(StringUtils.isNoneEmpty(name)){
        	orderType.setName(name);
        }
        
        PageHelper.startPage(pageIndex+1, pageCount);
        PageInfo<DicOrderType> pageInfo = new PageInfo<DicOrderType>(mapper.listByName(orderType));
        return twoPage(pageInfo);
	}



}
