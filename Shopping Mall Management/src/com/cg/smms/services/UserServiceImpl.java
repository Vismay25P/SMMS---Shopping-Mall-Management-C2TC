package com.cg.smms.services;

import com.cg.smms.entities.*;
import com.cg.smms.repository.*;

public class UserServiceImpl implements IUserService {
	private IUserRepository UserDAO;
	private ICustomerRepository CustDAO;
	private IShopService shopService;
	private IMallAdminRepository mallAdminDao;
//	private IAdminService AdminService;

//	Constructor
	public UserServiceImpl() {
		UserDAO = new UserRepositoryImpl();
		CustDAO = new CustomerRepositoryImpl();
		mallAdminDao = new MallAdminRepositoryImpl();
		shopService = new ShopServiceImpl();
//		AdminService = new AdminServiceImpl(); // <-- Going to loop
	}

//	login
	@Override
	public User login(User user) {
		String a = user.getPassword();
		User u = UserDAO.searchUser(user); // getting info of user from User Database
		String b = u.getPassword();
		boolean ans = a.equals(b);// Checking Values using equals method
		if (ans == true) {
			System.out.println("** Dear " + u.getName() + ", Login Successful !!! **");
			System.out.println("You are " + u.getType());
		} else {
			System.out.println("** Invalid input!! **");
		}
		return u;
	}

//	logOut
	@Override
	public Boolean logOut() {
		System.out.println("** Logout... Visit Again **");
		return false;
	}

	/* User */
	@Override
	public User addNewUser(User user) {
		UserDAO.beginTransaction();
		user = UserDAO.addNewUser(user);
		UserDAO.commitTransaction();
		return user;
	}

	@Override
	public User updateUser(User user) {
		UserDAO.beginTransaction();
		user = UserDAO.updateUser(user);
		UserDAO.commitTransaction();
		return user;
	}

	@Override
	public User searchUser(int id) {
		User user = UserDAO.searchUser(id);
		return user;
	}

	@Override
	public User deleteUser(int id) {
		UserDAO.beginTransaction();
		User user = UserDAO.deleteUser(id);
		UserDAO.commitTransaction();
		return user;
	}

	/* Customer */
	@Override
	public Customer addCustomer(Customer customer) {
		CustDAO.beginTransaction();
		customer = CustDAO.addCustomer(customer);
		CustDAO.commitTransaction();
		System.out.println("1 User Created");
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		CustDAO.beginTransaction();
		customer = CustDAO.updateCustomer(customer);
		CustDAO.commitTransaction();
		System.out.println("User Details Updated");
		return customer;
	}

	@Override
	public Customer searchCustomer(int id) {
		Customer customer = CustDAO.searchCustomer(id);
		User user = customer.getUser();
		System.out.println("Here is your Result: Customer " + user.getName());
		return customer;
	}

	@Override
	public Customer deleteCustomer(int id) {
		CustDAO.beginTransaction();
		Customer customer = CustDAO.searchCustomer(id);
		CustDAO.deleteCustomer(id);
		CustDAO.commitTransaction();
		System.out.println("1 User Deleted");
		return customer;
	}

	/* ShopOwner */
	@Override
	public ShopOwner addShopOwner(ShopOwner shopOwner) {
		shopService.addShopOwner(shopOwner);
		System.out.println("1 User Created");
		return shopOwner;
	}

	@Override
	public ShopOwner updateShopOwner(ShopOwner shopOwner) {
		shopService.updateShopOwner(shopOwner);
		System.out.println("User Details Updated");
		return shopOwner;
	}

	@Override
	public ShopOwner searchShopOwner(int id) {
		ShopOwner shopOwner = shopService.searchShopOwner(id);
		return shopOwner;
	}

	@Override
	public ShopOwner deleteShopOwner(int id) {
		ShopOwner shopOwner = shopService.searchShopOwner(id);
		shopService.deleteShopOwner(id);
		return shopOwner;
	}

//	/* MallAdmin */

	@Override
	public MallAdmin searchMallAdmin(int id) {
		// TODO Auto-generated method stub
		MallAdmin mallAdmin = mallAdminDao.searchMallAdmin(id);
		return mallAdmin;
	}

//	@Override
//	public MallAdmin addMallAdmin(MallAdmin mallAdmin) {
//		AdminService.addMallAdmin(mallAdmin);
//		System.out.println("1 USER CREATED");
//		return mallAdmin;
//	}

}
