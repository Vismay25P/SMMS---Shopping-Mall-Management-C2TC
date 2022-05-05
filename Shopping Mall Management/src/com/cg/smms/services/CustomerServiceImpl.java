package com.cg.smms.services;

import java.util.*;
import com.cg.smms.entities.*;
import com.cg.smms.repository.*;

public class CustomerServiceImpl implements ICustomerService {
	private IItemRepository ItemDAO;
	private IMallRepository MallDao;// Not Required
	private IUserService UserService;
//	private IOrderService orderService;

//	Constructor
	public CustomerServiceImpl() {
		ItemDAO = new ItemRepositoryImpl();
		MallDao = new MallRepositoryImpl();// Not Required
		UserService = new UserServiceImpl();
//		orderService = new OrderServiceImpl();
	}

	@Override
	public Item searchItem(int id) {
		Item item = ItemDAO.searchItem(id);
		System.out.println("Here is your Result: Item " + item.getName());
		return item;
	}

	@Override
	public List<Item> searchItem(String itemName) {
		List<Item> list = new ArrayList<Item>();
		Item i = ItemDAO.searchItem(itemName);
		list.add(i);
		return list;
	}

	@Override
	public Item orderItem(Item item) {
		int id = item.getItemId();
		Item i = ItemDAO.searchItem(id);
		return i;
	}

	@Override
	public Mall searchMall(int id) {
		Mall mall = MallDao.searchMall(id);
		return mall;
	}

//	@Override
//	public Boolean cancelOrder(int orderId) {
//		orderService.cancelOrder(orderId);
//		return false;
//	}

	@Override
	public User login(User user) {
		UserService.login(user);
		return user;
	}

	@Override
	public Boolean logOut() {
		UserService.logOut();
		return false;
	}

}
