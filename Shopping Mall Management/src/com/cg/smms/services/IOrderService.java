package com.cg.smms.services;

import com.cg.smms.entities.Item;
import com.cg.smms.entities.OrderDetails;

public interface IOrderService {
	OrderDetails addOrder(OrderDetails order);

	OrderDetails updateOrder(OrderDetails order);

	OrderDetails searchOrder(int id);
	
	boolean cancelOrder(int id);

	Boolean cancelMall(int id);

	Item addItem(Item item);

}
