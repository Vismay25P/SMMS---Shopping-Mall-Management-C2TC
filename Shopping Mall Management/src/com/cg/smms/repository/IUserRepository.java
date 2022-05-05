package com.cg.smms.repository;

import com.cg.smms.entities.User;

public interface IUserRepository {

	User addNewUser(User user);

	User updateUser(User user);

	User searchUser(int id);

	User searchUser(User user);

	User deleteUser(int id);

	void beginTransaction();

	void commitTransaction();

}
