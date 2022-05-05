package com.cg.smms.services;

import com.cg.smms.entities.*;
import com.cg.smms.repository.*;

public class OrderServiceImpl implements IOrderService {
	private IOrderRepository OrderDao;
//	private IOrderService orderService;

//	Constructor
	public OrderServiceImpl() {
		OrderDao = new OrderRepositoryImpl();
//		orderService = new OrderServiceImpl();
	}

//	addOrder
	@Override
	public OrderDetails addOrder(OrderDetails order) {
		OrderDao.beginTransaction();
		OrderDao.addOrder(order);
		OrderDao.commitTransaction();
		return order;
	}

//	updateOrder
	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		OrderDao.beginTransaction();
		OrderDao.updateOrder(order);
		OrderDao.commitTransaction();
		return order;
	}

//	searchOrder
	@Override
	public OrderDetails searchOrder(int id) {
		OrderDetails order = OrderDao.searchOrder(id);
		System.out.println("Here is your Result: OrderNo." + order.getOrderId());
		return order;
	}

//	cancelOrder
	@Override
	public boolean cancelOrder(int id) {
		OrderDao.beginTransaction();
		OrderDao.deleteOrder(id);
		OrderDao.commitTransaction();
		return false;
	}

//	cancelMall
	@Override
	public Boolean cancelMall(int id) {
//		orderService.cancelOrder(id);
		OrderDao.beginTransaction();
		OrderDao.deleteOrder(id);
		OrderDao.commitTransaction();
		return false;
	}

//	addItem
	@Override
	public Item addItem(Item item) {
		IShopService shopService = new ShopServiceImpl();
		shopService.addItem(item);
		return item;
	}

}
