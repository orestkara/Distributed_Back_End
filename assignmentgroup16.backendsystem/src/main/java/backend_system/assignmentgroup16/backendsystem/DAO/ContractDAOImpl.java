package backend_system.assignmentgroup16.backendsystem.DAO;

import backend_system.assignmentgroup16.backendsystem.entity.Contract;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ContractDAOImpl implements ContractDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public Contract getContract(Integer contract_id) {
		return entityManager.find(Contract.class, contract_id);
	}

	@Override
	@Transactional
	public void saveContract(Contract contract) {
		Contract acontract = entityManager.merge(contract);
	}

	@Override
	@Transactional
	public void updateContract(Contract contract) {
		Session session = entityManager.unwrap(Session.class);
		session.createQuery("update contract set 'Submission_Date='" + contract.getSubmission_date() + "',Tenant_Name='"
				+ contract.getTenant_name() + "',Tenant_TIN='" + contract.getTenant_TIN() + "',Email='"
				+ contract.getEmail() + "',Phone_Number='" + contract.getPhone_number() + "',Special_Terms='"
				+ contract.getSpecial_terms() + "',Rental_Period='" + contract.getRental_period() + "',Approved='" + 0
				+ "',Payment='" + contract.getPayment() + "where contract_id=" + contract.getContract_id() + "")
				.executeUpdate();
		// update all fields???
	}

	@Override
	@Transactional
	public void deleteContract(Integer contract_id) {
		Session session = entityManager.unwrap(Session.class);
		Contract contract = session.get(Contract.class, contract_id);
		session.delete(contract);
	}

	@Override
	@Transactional
	public List<Contract> getContractSubmissions() {
		Session session = entityManager.unwrap(Session.class);
		Query<Contract> query = session.createQuery("from Contract C where C.approved=3", Contract.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void acceptContract(Contract contract) {
		Session session = entityManager.unwrap(Session.class);
		session.createQuery("update Contract set approved=3 where id='"+contract.getContract_id()+"'")
				.executeUpdate();
	}

	@Override
	@Transactional
	public void rejectContract(Contract contract) {
		Session session = entityManager.unwrap(Session.class);
		session.createQuery("update Contract set approved=2 where id='"+contract.getContract_id()+"'")
				.executeUpdate();
	}

	@Override
	@Transactional
	public List<Contract> getContracts() {
		Session session = entityManager.unwrap(Session.class);
		Query<Contract> query = session.createQuery("from Contract", Contract.class);
		List<Contract> contracts = query.getResultList();
		return query.getResultList();
	}

	@Override
	@Transactional
	public Integer checkContract(Contract contract) {
		Session session = entityManager.unwrap(Session.class);
		return contract.getApproved();
	}

}