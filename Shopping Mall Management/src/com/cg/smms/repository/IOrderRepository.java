package com.cg.smms.repository;

import com.cg.smms.entities.OrderDetails;

public interface IOrderRepository {

	OrderDetails addOrder(OrderDetails order);

	OrderDetails updateOrder(OrderDetails order);

	OrderDetails searchOrder(int id);

	OrderDetails deleteOrder(int id);

	void beginTransaction();

	void commitTransaction();
}
