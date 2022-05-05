package com.cg.smms.services;

import java.util.List;

import com.cg.smms.entities.Item;
import com.cg.smms.entities.Mall;
import com.cg.smms.entities.User;

public interface ICustomerService {
	Item searchItem(int id);

	List<Item> searchItem(String itemName);

	Item orderItem(Item item);

	Mall searchMall(int id);

//	Boolean cancelOrder(int orderId);

	User login(User user);

	Boolean logOut();
}
