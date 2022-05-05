package com.cg.smms.services;

import com.cg.smms.entities.*;
import com.cg.smms.repository.*;

public class AdminServiceImpl implements IAdminService {
	private IMallAdminRepository mallAdminDao;
	private IUserService UserService;
	private IShopService ShopService;
	private IMallRepository mallDao;

//	Constructor
	public AdminServiceImpl() {
		mallAdminDao = new MallAdminRepositoryImpl();
		UserService = new UserServiceImpl();
		ShopService = new ShopServiceImpl();
		mallDao = new MallRepositoryImpl();
	}

	@Override
	public Boolean approaveNewShop(Shop shop) {
		shop = ShopService.addShop(shop);
		return true;
	}

	@Override
	public User updateUser(User user) {
		UserService.updateUser(user);
		return user;
	}

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

	@Override
	public MallAdmin addMallAdmin(MallAdmin mallAdmin) {
		mallAdminDao.beginTransaction();
		mallAdminDao.addMallAdmin(mallAdmin);
		mallAdminDao.commitTransaction();
		return mallAdmin;
	}

	@Override
	public MallAdmin updateMallAdmin(MallAdmin mallAdmin) {
		mallAdminDao.beginTransaction();
		mallAdminDao.updateMallAdmin(mallAdmin);
		mallAdminDao.commitTransaction();
		return mallAdmin;
	}

	@Override
	public MallAdmin searchMallAdmin(int id) {
		MallAdmin mallAdmin = mallAdminDao.searchMallAdmin(id);
		return mallAdmin;
	}

	@Override
	public MallAdmin deleteMallAdmin(int id) {
		MallAdmin mallAdmin = mallAdminDao.searchMallAdmin(id);
		mallAdminDao.deleteMallAdmin(id);
		return mallAdmin;
	}

	@Override
	public Mall addMall(Mall mall) {
		mallDao.beginTransaction();
		mallDao.addMall(mall);
		mallDao.commitTransaction();
		return mall;
	}

	@Override
	public Mall updateMall(Mall mall) {
		mallDao.beginTransaction();
		mallDao.updateMall(mall);
		mallDao.commitTransaction();
		return mall;
	}

	@Override
	public Mall searchMall(int id) {
		Mall mall = mallDao.searchMall(id);
		return mall;
	}

	@Override
	public Mall deleteMall(int id) {
		mallDao.beginTransaction();
		Mall mall = mallDao.searchMall(id);
		mallDao.deleteMall(id);
		mallDao.commitTransaction();
		return mall;
	}

}
