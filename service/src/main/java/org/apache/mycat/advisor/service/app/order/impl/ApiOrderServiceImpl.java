package org.apache.mycat.advisor.service.app.order.impl;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.mycat.advisor.persistence.dao.TabOrderExtendMapper;
import org.apache.mycat.advisor.persistence.dao.TabOrderMapper;
import org.apache.mycat.advisor.persistence.model.TabOrder;
import org.apache.mycat.advisor.persistence.model.TabOrderExtend;
import org.apache.mycat.advisor.service.app.order.ApiOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by cjl on 2016/4/25.
 */
public class ApiOrderServiceImpl implements ApiOrderService {

    @Autowired
    TabOrderMapper orderMapper;
    @Autowired
    TabOrderExtendMapper extendMapper;


    @Override
    public boolean newOrder(Map<String, Object> orderMap,Long productId) {

        String type = orderMap.get("type")+"";
        String beginDate = orderMap.get("beginDate")+"";
        String endDate = orderMap.get("endDate")+"";
        String sceneDay = orderMap.get("sceneDay")+"";
        String advisor1 = orderMap.get("advisor1")+"";
        String advisor2 = orderMap.get("advisor2")+"";
        String advisor3 = orderMap.get("advisor3")+"";
        String memo = orderMap.get("memo")+"";
        long createTime = System.currentTimeMillis();
        //创建一个新订单
        TabOrder order = newOrder(productId, createTime);
        //插入订单信息
        try {
            saveExtend(type, beginDate, endDate, sceneDay, advisor1, advisor2, advisor3, memo,order.getId());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return true;
    }

    private void saveExtend(String type, String beginDate, String endDate, String sceneDay, String advisor1, String advisor2, String advisor3, String memo, Long orderId) throws ParseException {
        TabOrderExtend extend = new TabOrderExtend();
        extend.setAdvisor1(new Long(advisor1));
        extend.setAdvisor2(new Long(advisor2));
        extend.setAdvisor3(new Long(advisor3));
        extend.setBeginDate(DateUtils.parseDate(beginDate, "yyyy-MM-dd HH:mm:ss"));
        extend.setEndDate(DateUtils.parseDate(endDate,"yyyy-MM-dd HH:mm:ss"));
        extend.setOnlineDay(new Integer(sceneDay));
        extend.setType(new Integer(type));
        extend.setMemo(memo);
        extend.setOrderId(orderId);

        extendMapper.insert(extend);
    }

    private TabOrder newOrder(Long productId, long createTime) {
        TabOrder order = new TabOrder();
        order.setOrderStep(1);
        order.setStatus(1);
        order.setProductId(productId);
        order.setCreateTime(createTime);
        order.setUpdateTime(createTime);
        orderMapper.insert(order);
        List<TabOrder> list = orderMapper.select(order);
        return list.get(0);
    }

}
