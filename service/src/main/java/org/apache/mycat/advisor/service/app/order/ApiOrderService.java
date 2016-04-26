package org.apache.mycat.advisor.service.app.order;

import java.util.Map;

/**
 * Created by cjl on 2016/4/21.
 */
public interface ApiOrderService {


	boolean newOrder(Map<String, Object> orderMap, Long productId);
}
