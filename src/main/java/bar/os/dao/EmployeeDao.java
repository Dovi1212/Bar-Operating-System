package bar.os.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bar.os.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

	String findEmployeeRoleByID(Long employeeId);

}
