package com.cg.smms.services;

import java.util.*;
import com.cg.smms.entities.*;
import com.cg.smms.repository.*;

@SuppressWarnings("unused")
public class ShopServiceImpl implements IShopService {

	private IShopRepository ShopDao;// shop
	private IShopOwnerRepository ShopOwnerDao;
	private IEmployeeService EmployeeService;
//	private IEmployeeRepository EmployeeDao;
	private IItemRepository ItemDao;

//	Constructor
	public ShopServiceImpl() {
		ShopDao = new ShopRepositoryImpl();
		ShopOwnerDao = new ShopOwnerRepositoryImpl();
		EmployeeService = new EmployeeServiceImpl();
//		EmployeeDao = new EmployeeRepositoryImpl();
		ItemDao = new ItemRepositoryImpl();
	}

//	addShop
	@Override
	public Shop addShop(Shop shop) {
		// TODO Auto-generated method stub
		ShopDao.beginTransaction();
		ShopDao.addShop(shop);
		ShopDao.commitTransaction();
		System.out.println("1 Shop added");
		return shop;
	}

//	updateShop
	@Override
	public Shop updateShop(Shop shop) {
		// TODO Auto-generated method stub
		ShopDao.beginTransaction();
		ShopDao.updateShop(shop);
		ShopDao.commitTransaction();
		System.out.println("Shop Updated");
		return shop;
	}

//	searchShopById
	@Override
	public Shop searchShopById(int shopId) {
		Shop shop = ShopDao.searchShopById(shopId);
		System.out.println("Here is your Result: Shop " + shop.getShopName());
		return shop;
	}

//	deleteShop
	@Override
	public boolean deleteShop(int shopId) {
		ShopDao.beginTransaction();
		ShopDao.deleteShop(shopId);
		ShopDao.commitTransaction();
		System.out.println("Shop " + shopId + " shop deleted");
		return false;
	}

	@Override
	public ShopOwner addShopOwner(ShopOwner shopOwner) {
		ShopOwnerDao.beginTransaction();
		shopOwner = ShopOwnerDao.addShopOwner(shopOwner);
		ShopOwnerDao.commitTransaction();
		return shopOwner;
	}

	@Override
	public ShopOwner updateShopOwner(ShopOwner shopOwner) {
		// TODO Auto-generated method stub
		ShopOwnerDao.beginTransaction();
		shopOwner = ShopOwnerDao.updateShopOwner(shopOwner);
		ShopOwnerDao.commitTransaction();
		return shopOwner;
	}

	@Override
	public ShopOwner searchShopOwner(int shopOwnerId) {
		// TODO Auto-generated method stub
		ShopOwner shopOwner = ShopOwnerDao.searchShopOwner(shopOwnerId);
		User user = shopOwner.getUser();
		System.out.println("Here is your Result: ShopOwner " + user.getName());
		return shopOwner;
	}

	@Override
	public boolean deleteShopOwner(int shopOwnerId) {
		ShopOwnerDao.beginTransaction();
		ShopOwnerDao.deleteShopOwner(shopOwnerId);
		ShopOwnerDao.commitTransaction();
		return false;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		EmployeeService.addEmployee(employee);
		return true;
	}

	@Override
	public boolean addEmployees(List<Employee> employees) {
		EmployeeService.addEmployees(employees);
		return true;
	}

	@Override
	public List<Employee> searchEmployeesByShopId(int id) {
		Shop shop = searchShopById(id);
		List<Employee> list = new ArrayList<Employee>();
//		Employee i = EmployeeDao.searchEmployee(id);
//		list.add(i);
		list = shop.getEmployee();
		return list;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		EmployeeService.updateEmployee(employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		EmployeeService.deleteEmployee(id);
		return false;
	}

	@Override
	public Item addItem(Item item) {
		ItemDao.beginTransaction();
		item = ItemDao.addItem(item);
		ItemDao.commitTransaction();
		System.out.println("1 Item added");
		return item;
	}

	@Override
	public List<Item> addItems(List<Item> items) {
		ItemDao.beginTransaction();
		for (Item item : items) {
			ItemDao.addItem(item);
		}
		ItemDao.commitTransaction();
		System.out.println("Item List added");
		return items;
	}

	@Override
	public Item updateItem(Item item) {
		ItemDao.beginTransaction();
		item = ItemDao.updateItem(item);
		ItemDao.commitTransaction();
		System.out.println("1 Item updated");
		return item;
	}

	@Override
	public Item deleteItem(int id) {
		ItemDao.beginTransaction();
		Item item = ItemDao.searchItem(id);
		ItemDao.deleteItem(id);
		ItemDao.commitTransaction();
		System.out.println("1 Item deleted");
		return item;
	}

}
