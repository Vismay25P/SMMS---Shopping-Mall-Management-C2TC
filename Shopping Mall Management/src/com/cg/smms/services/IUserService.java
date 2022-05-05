package com.cg.smms.services;

import com.cg.smms.entities.*;

public interface IUserService {

	/* User */

	User addNewUser(User user);

	User updateUser(User user);;

	User searchUser(int id);

	User deleteUser(int id);

	/* Customer */

	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer searchCustomer(int id);

	Customer deleteCustomer(int id);

	/* ShopOwner */

	ShopOwner addShopOwner(ShopOwner shopOwner);

	ShopOwner updateShopOwner(ShopOwner shopOwner);

	ShopOwner searchShopOwner(int id);

	ShopOwner deleteShopOwner(int id);

	/* MallAdmin */
	
	MallAdmin searchMallAdmin(int id);
	
//	MallAdmin addMallAdmin(MallAdmin mallAdmin);

	/* LogIn LogOut */

	User login(User user);

	Boolean logOut();
}
