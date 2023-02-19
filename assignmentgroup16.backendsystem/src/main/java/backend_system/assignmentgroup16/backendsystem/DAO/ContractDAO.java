package backend_system.assignmentgroup16.backendsystem.DAO;

import backend_system.assignmentgroup16.backendsystem.entity.Contract;

import java.util.List;

public interface ContractDAO {

	public Contract getContract(Integer contract_id);

	public void saveContract(Contract contract);

	public void updateContract(Contract contract);

	public void deleteContract(Integer contract_id);

	public List<Contract> getContracts();

	public List<Contract> getContractSubmissions();

	public void acceptContract(Contract contract);

	public void rejectContract(Contract contract);
	
	public Integer checkContract(Contract contract);

}
