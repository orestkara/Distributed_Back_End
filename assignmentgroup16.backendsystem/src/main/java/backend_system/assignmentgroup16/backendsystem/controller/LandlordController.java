package backend_system.assignmentgroup16.backendsystem.controller;

import backend_system.assignmentgroup16.backendsystem.DAO.ContractDAO;
import backend_system.assignmentgroup16.backendsystem.DAO.HouseDAO;
import backend_system.assignmentgroup16.backendsystem.entity.Contract;
import backend_system.assignmentgroup16.backendsystem.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/landlord")
public class LandlordController {

	@Autowired
	private ContractDAO contractDAO;

	@Autowired
	private HouseDAO houseDAO;

	@GetMapping("/{id}")
	List<House> get(@PathVariable String id) {
		List<House> houses = houseDAO.findHousebyTin(id);
		return houses;
	}

	@PostMapping("/newContract")
	Contract saveContract(@Valid @RequestBody Contract contract) {
		contractDAO.saveContract(contract);
		return contract;
	}

	@GetMapping ("/getContract/{id}")
	public Contract getContract(@PathVariable int id) {
		if (contractDAO.checkContract(contractDAO.getContract(id)) == 1) {
            return contractDAO.getContract(id);
        } else {
			System.out.println ("Contract is newly made or approved or rejected");
			return null;
        }
	}

	@PostMapping("/acceptContract/{id}")
	public String acceptContract(@RequestParam("id") Integer id) {
		Contract contract = contractDAO.getContract(id);
		contractDAO.acceptContract(contract);
		return "Contract accepted";
	}

	@PostMapping("/rejectContract/{id}")
	public String rejectContract(@RequestParam("id") Integer id) {
		Contract contract = contractDAO.getContract(id);
		contractDAO.rejectContract(contract);
		return "Contract rejected";
	}

}
