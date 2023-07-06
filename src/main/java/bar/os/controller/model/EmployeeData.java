package bar.os.controller.model;
//Author Svitlana Leven

import java.util.HashSet;
import java.util.Set;

import bar.os.entity.Employee;
import bar.os.entity.Tab;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeData {

	
private Long employeeId;
	
	private String FirstName;
	private String LastName;
	private String Email;
	private String employeeRole;
	Set<TabData> tabs = new HashSet<>();
	
	public EmployeeData(Employee employee) {
		employeeId = employee.getEmployeeId();
		FirstName = employee.getFirstName();
		LastName = employee.getLastName();
		Email = employee.getEmail();
		employeeRole = employee.getEmployeeRole();
		
		for(Tab tab : employee.getTabs()) {
			tabs.add(new TabData(tab));
		}
}
}
