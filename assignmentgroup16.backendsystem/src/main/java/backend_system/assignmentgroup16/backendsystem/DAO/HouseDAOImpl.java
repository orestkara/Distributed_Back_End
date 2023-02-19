package backend_system.assignmentgroup16.backendsystem.DAO;

import backend_system.assignmentgroup16.backendsystem.entity.House;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class HouseDAOImpl implements HouseDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<House> getHouses() {
		Session session = entityManager.unwrap(Session.class);
		Query<House> query = session.createQuery("from House", House.class);
		List<House> house = query.getResultList();
		return query.getResultList();
	}

	@Override
	@Transactional
	public House getHouse(Integer house_id) {
		return entityManager.find(House.class, house_id);
	}

	@Override
	@Transactional
	public void saveHouse(House house) {
		House ahouse = entityManager.merge(house);
	}

	@Override
	@Transactional
	public void updateHouse(House house) {
		Session session = entityManager.unwrap(Session.class);
		session.createQuery("update House set house size='" + house.getHouse_size() + "',house description='"
				+ house.getHouse_description() + "',Rent_Details='" + house.getRent_details() + "',Electricity_Id='"
				+ house.getElectricity_id() + "',House_Size='" + house.getHouse_size() + "',Bedrooms='"
				+ house.getBedrooms() + "',Owner_TIN='" + house.getOwner_TIN() + "'  where house_id='"
				+ house.getHouse_id() + "'").executeUpdate();
		// update all fields???
	}

	@Override
	@Transactional
	public void deleteHouse(Integer house_id) {
		Session session = entityManager.unwrap(Session.class);
		House house = session.get(House.class, house_id);
		session.delete(house);
	}

	@Override
	@Transactional
	public List<House> findHousebyTin(String owner_TIN) {
		Session session = entityManager.unwrap(Session.class);
		Query<House> query = session.createQuery("from House H where H.owner_TIN = :owner_TIN ", House.class);
		List<House> house = query.getResultList();
		return query.getResultList();
	}

}