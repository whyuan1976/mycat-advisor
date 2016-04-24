package org.apache.mycat.advisor.service.app.order;

import org.apache.mycat.advisor.persistence.model.TabOrder;

/**
 * Created by cjl on 2016/4/21.
 */
public interface ApiOrderService {

	boolean newOrder(TabOrder order);
}
