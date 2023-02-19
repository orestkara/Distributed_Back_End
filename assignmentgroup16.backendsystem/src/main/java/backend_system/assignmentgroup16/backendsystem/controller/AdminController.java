package backend_system.assignmentgroup16.backendsystem.controller;

import backend_system.assignmentgroup16.backendsystem.DAO.ContractDAO;
import backend_system.assignmentgroup16.backendsystem.DAO.HouseDAO;
import backend_system.assignmentgroup16.backendsystem.DAO.UserDAO;
import backend_system.assignmentgroup16.backendsystem.entity.Contract;
import backend_system.assignmentgroup16.backendsystem.entity.House;
import backend_system.assignmentgroup16.backendsystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private ContractDAO contractDAO;

	@Autowired
	private HouseDAO houseDAO;

	@Autowired
	private UserDAO userDAO;

	@GetMapping("/contracts")
	public List<Contract> getContractSubmissions() {
		return contractDAO.getContractSubmissions();
	}

	@GetMapping("/contracts/{id}")
	public Contract getContract(@PathVariable int id) {
		return contractDAO.getContract(id);
	}

	@DeleteMapping("/contracts/{id}")
	public void deleteContract(@PathVariable int id) {
		contractDAO.deleteContract(id);
	}

	@PostMapping("/contracts")
	Contract saveContract(@Valid @RequestBody Contract contract) {
		contractDAO.saveContract(contract);
		return contract;
	}

	@GetMapping("/houses")
	public List<House> getHouses() {
		return houseDAO.getHouses();
	}

	@GetMapping("/houses/{id}")
	public House getHouse(@PathVariable int id) {
		return houseDAO.getHouse(id);
	}

	@DeleteMapping("/houses/{id}")
	public void deleteHouse(@PathVariable int id) {
		houseDAO.deleteHouse(id);
	}

	@PostMapping("/houses-save")
	House saveHouse(@Valid @RequestBody House house) {
		houseDAO.saveHouse(house);
		return house;
	}

	@PostMapping("/houses")
	House updateHouse(@Valid @RequestBody House house) {
		houseDAO.updateHouse(house);
		return house;
	}

	@GetMapping("/users")
	public List<User> getUser() {
		return userDAO.getUsers();
	}

	@GetMapping("/users/{id}")
	public User findUserByTin(@PathVariable String id) {
		return userDAO.findUserByTin(id);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userDAO.deleteUser(id);
	}

	@PostMapping("/users-save")
	User saveUser(@Valid @RequestBody User user) {
		userDAO.saveUser(user);
		return user;
	}

	@PostMapping("/users")
	User updateUser(@Valid @RequestBody User user) {
		userDAO.updateUser(user);
		return user;
	}

}