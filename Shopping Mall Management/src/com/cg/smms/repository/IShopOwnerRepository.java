package com.cg.smms.repository;

import com.cg.smms.entities.ShopOwner;

public interface IShopOwnerRepository {

	ShopOwner addShopOwner(ShopOwner shopOwner);

	ShopOwner updateShopOwner(ShopOwner shopOwner);

	ShopOwner searchShopOwner(int id);

	ShopOwner deleteShopOwner(int id);

	void commitTransaction();

	void beginTransaction();
}
