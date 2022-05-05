package com.cg.smms.repository;

import com.cg.smms.entities.Mall;

public interface IMallRepository {
	Mall addMall(Mall mall);

	Mall updateMall(Mall mall);

	Mall searchMall(int id);
	
	Mall deleteMall(int id);

	void beginTransaction();

	void commitTransaction();
}
