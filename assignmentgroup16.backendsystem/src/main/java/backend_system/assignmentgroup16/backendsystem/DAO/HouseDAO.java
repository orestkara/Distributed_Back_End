package backend_system.assignmentgroup16.backendsystem.DAO;

import backend_system.assignmentgroup16.backendsystem.entity.House;

import java.util.List;

public interface HouseDAO {

	public List<House> getHouses();

	public House getHouse(Integer house_id);

	public void saveHouse(House house);

	public void updateHouse(House house);

	public void deleteHouse(Integer house_id);
	
	public List<House> findHousebyTin(String owner_TIN);
	

}
