package com.cg.smms.client;

import java.util.*;

import com.cg.smms.entities.*;
import com.cg.smms.services.*;

@SuppressWarnings("unused")
public class DeleteOperation {
	public static void main(String[] args) {
		/* Entity Object Creation */
		User user;
		MallAdmin mallAdmin;
		Mall mall;
		ShopOwner shopOwner;
		Shop shop;
		Employee employee;
		List<Employee> list1 = new ArrayList<Employee>();
		Item item;
		List<Item> list2 = new ArrayList<Item>();
		Customer customer;
		OrderDetails order;
		List<OrderDetails> list3 = new ArrayList<OrderDetails>();

		/* Service Object Creation */
		IUserService uService = new UserServiceImpl();
		IAdminService aService = new AdminServiceImpl();
		IShopService sService = new ShopServiceImpl();
		IEmployeeService eService = new EmployeeServiceImpl();
		ICustomerService cService = new CustomerServiceImpl();
		IOrderService oService = new OrderServiceImpl();

		/* User */
//		uService.deleteUser(2);

		/* Mall Admin */
//		aService.deleteMallAdmin(1);

		/* Mall */
//		aService.deleteMall(1);

		/* Shop Owner */
//		sService.deleteShopOwner(1);//<-------

		/* Shop */
//		sService.deleteShop(1);

//		/* Employee */
//		eService.deleteEmployee(1);//<-------
//
//		/* Item */
//		sService.deleteItem(1);//<--------
//
//		/* Customer */
//		uService.deleteCustomer(2);//<--------
//
//		/* Order */
//		oService.cancelOrder(2);//<--------
	}
}
