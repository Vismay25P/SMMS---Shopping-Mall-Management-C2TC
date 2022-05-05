package com.cg.smms.repository;

import javax.persistence.EntityManager;

import com.cg.smms.entities.Shop;
import com.cg.smms.exception.ShopNotFoundException;

public class ShopRepositoryImpl implements IShopRepository {
	private EntityManager entityManager;

//	Constructor
	public ShopRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

//	addShop
	@Override
	public Shop addShop(Shop shop) {
		entityManager.persist(shop);
		return shop;
	}

//	updateShop
	@Override
	public Shop updateShop(Shop shop) {
		int a = shop.getShopId();
		Shop sh = entityManager.find(Shop.class, a);
		try {
			if (sh == null) {
				throw new ShopNotFoundException("Shop not found");
			} else {
				entityManager.merge(shop);
			}
		} catch (ShopNotFoundException e) {
			System.out.println(e);
		}
		return sh;
	}

//	searchShopById
	@Override
	public Shop searchShopById(int id) {
		Shop shop = entityManager.find(Shop.class, id);
		try {
			if (shop == null) {
				throw new ShopNotFoundException("Shop not found");
			} 
//			else {
//				System.out.println("Shop Name :- " + shop.getShopName());
//			}
		} catch (ShopNotFoundException e) {
			System.out.println(e);
		}
		return shop;
	}

//	deleteShop
	@Override
	public boolean deleteShop(int shopId) {
		Shop shop = entityManager.find(Shop.class, shopId);
		try {
			if (shop == null) {
				throw new ShopNotFoundException("Shop not found");
			} else {
				entityManager.remove(shop);
			}
		} catch (ShopNotFoundException e) {
			System.out.println(e);
		}
		return false;
	}

//	beginTransaction
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

//	commitTransaction
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

}
