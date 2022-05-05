package com.cg.smms.repository;

import com.cg.smms.entities.Shop;

public interface IShopRepository {
	Shop addShop(Shop shop);

	Shop updateShop(Shop shop);

	Shop searchShopById(int id);

	boolean deleteShop(int id);

	void beginTransaction();

	void commitTransaction();

}
