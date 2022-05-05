package com.cg.smms.services;

import com.cg.smms.entities.*;

public interface IAdminService {

	MallAdmin addMallAdmin(MallAdmin mallAdmin);

	MallAdmin updateMallAdmin(MallAdmin mallAdmin);

	MallAdmin searchMallAdmin(int id);

	MallAdmin deleteMallAdmin(int id);

	Mall addMall(Mall mall);

	Mall updateMall(Mall mall);

	Mall searchMall(int id);
	
	Mall deleteMall(int id);

	Boolean approaveNewShop(Shop shop);

	User updateUser(User user);

	User login(User user);

	Boolean logOut();

}
