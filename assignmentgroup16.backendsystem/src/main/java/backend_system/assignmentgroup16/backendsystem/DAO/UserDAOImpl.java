package backend_system.assignmentgroup16.backendsystem.DAO;

import backend_system.assignmentgroup16.backendsystem.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public User findUserByTin(String TIN) {
		return entityManager.find(User.class, TIN);
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		Session session = entityManager.unwrap(Session.class);
		Query<User> query = session.createQuery("from User", User.class);
		List<User> users = query.getResultList();
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		User auser = entityManager.merge(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.createQuery("update User set 'First_Name='" + user.getFirst_name() +"',Last_Name='" + user.getLast_name()+
				"',email='" + user.getEmail() +"',Enabled='" + user.isEnabled()+ "',Phone_Number='" + user.getPhone_number()+
				"'  where username='" + user.getUsername() + "").executeUpdate();
		//update all fields???
	}

	
	@Override
	@Transactional
	public void deleteUser(String TIN) {
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, TIN);
		//remove bidirectional correlation but don't know how
		//user.getApplication().setUser(null);
		session.delete(user);
	}

//	@Override
//	@Transactional
//	public List<User> getApplications() {
//		Session session = entityManager.unwrap(Session.class);
//		Query<User> query = session.createQuery("from User as user where user.is_Approved=0", User.class);
//		return query.getResultList();
//	}

}
