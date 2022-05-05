package com.cg.smms.client;

import java.util.*;

import com.cg.smms.entities.*;
import com.cg.smms.services.*;

@SuppressWarnings("unused")
public class ReadOperation {

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
		user = uService.searchUser(1);

		/* Mall Admin */
		mallAdmin = uService.searchMallAdmin(1);

		/* Mall */
		mall = aService.searchMall(1);

		/* Shop Owner */
		shopOwner = uService.searchShopOwner(1);

		/* Shop */
		shop = sService.searchShopById(1);

		/* Employee */
		employee = eService.searchEmployee(1);
		list1 = sService.searchEmployeesByShopId(1);
		for (Employee emp : list1) {
			System.out.println(emp.getName());
		}

		/* Item */
		item = cService.searchItem(1);
		list2 = cService.searchItem("e");
		
		/* Customer */
		customer = uService.searchCustomer(1);
		
		/* Order */
		order = oService.searchOrder(1);

	}

}
