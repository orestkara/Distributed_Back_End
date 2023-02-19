package backend_system.assignmentgroup16.backendsystem.controller;

import backend_system.assignmentgroup16.backendsystem.DAO.ContractDAO;
import backend_system.assignmentgroup16.backendsystem.DAO.HouseDAO;
import backend_system.assignmentgroup16.backendsystem.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tenant")
public class TenantController {

	@Autowired
	private ContractDAO contractDAO;

	@Autowired
	private HouseDAO houseDAO;
	

	@GetMapping("/getContract/{id}")
	public Contract getContract(@PathVariable int id) {
		if (contractDAO.checkContract(contractDAO.getContract(id)) == 0) {
			return contractDAO.getContract(id);
		} else {
			System.out.println ("Contract is approved or rejected");
			return null;
		}
	}
	@PostMapping("/addComments/{id}")
	Contract updateContract(@Valid @RequestBody Contract contract) {
		contractDAO.updateContract(contract);
		return contract;
	}
	
	@PostMapping("/acceptContract/{id}")
	public String acceptContract(@RequestParam("id") Integer id) {
		Contract contract = contractDAO.getContract(id);
		contractDAO.acceptContract(contract);
		return "Contract accepted";
	}
	
}