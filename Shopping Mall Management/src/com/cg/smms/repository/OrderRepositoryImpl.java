package com.cg.smms.repository;

import javax.persistence.EntityManager;

import com.cg.smms.entities.OrderDetails;
import com.cg.smms.exception.OrderCancelException;

public class OrderRepositoryImpl implements IOrderRepository {
	private EntityManager entityManager;

//	Constructor
	public OrderRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

//	addOrder
	@Override
	public OrderDetails addOrder(OrderDetails order) {
		entityManager.persist(order);
		return order;
	}

//	updateOrder
	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		int id = order.getOrderId();
		OrderDetails od = entityManager.find(OrderDetails.class, id);
		try {
			if (od == null) {
				throw new OrderCancelException("Order Details Not Found !!");
			} else {
				entityManager.merge(order);// <----
			}
		} catch (OrderCancelException e) {
			System.out.println(e);
		}
		return od;
	}

//	searchOrder
	@Override
	public OrderDetails searchOrder(int id) {
		OrderDetails od = entityManager.find(OrderDetails.class, id);
		try {
			if (od == null) {
				throw new OrderCancelException("Order Details Not Found !!");
			} 
//			else {
//				System.out.println(od.toString());// <----
//			}
		} catch (OrderCancelException e) {
			System.out.println(e);
		}
		return od;
	}

//	deleteOrder
	@Override
	public OrderDetails deleteOrder(int id) {
		OrderDetails od = entityManager.find(OrderDetails.class, id);
		try {
			if (od == null) {
				throw new OrderCancelException("Order Details Not Found !!");
			} else {
				entityManager.remove(od);// <----
			}
		} catch (OrderCancelException e) {
			System.out.println(e);
		}
		return od;
	}

//	beginTransaction
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

//	commitTransaction
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

}
