package bar.os.dao;
//Author Svitlana Leven

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bar.os.entity.Employee;
import bar.os.entity.Tab;

public interface EmployeeDao extends JpaRepository<Employee, Long> {



	List<Employee> findAllByEmployeeRole(String employeeRole);


	List<Tab> findAllTabsByEmployeeId(Long employeeId);


	Employee findByEmployeeId(Long employeeId);


	Employee findEmployeeByEmployeeId(Long employeeId);

}
