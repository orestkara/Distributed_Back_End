package backend_system.assignmentgroup16.backendsystem.DAO;

import backend_system.assignmentgroup16.backendsystem.entity.User;

import java.util.List;

public interface UserDAO {

	//public List<User> findAll();
	
	//public List<User> getTenants();

	//public List<User> getLandlords();

	public User findUserByTin(String TIN);

	public List<User> getUsers();

	public void saveUser(User user);

	public void updateUser(User user);

	public void deleteUser(String TIN);

	//public List<User> getApplications();


}
