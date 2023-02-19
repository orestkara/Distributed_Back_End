package backend_system.assignmentgroup16.backendsystem.DAO;

import backend_system.assignmentgroup16.backendsystem.entity.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void saveAuthority(Authorities auth) {
		Authorities anauth = entityManager.merge(auth);
	}
	
}
