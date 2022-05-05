package com.cg.smms.repository;

import com.cg.smms.entities.MallAdmin;

public interface IMallAdminRepository {

	MallAdmin addMallAdmin(MallAdmin mallAdmin);

	MallAdmin updateMallAdmin(MallAdmin mallAdmin);

	MallAdmin searchMallAdmin(int id);

	MallAdmin deleteMallAdmin(int id);

	void beginTransaction();

	void commitTransaction();

}
