package bar.os.dao;
//Author Svitlana Leven

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bar.os.entity.Tab;

public interface TabDao extends JpaRepository<Tab, Long> {

	void deleteById(Long tabId);



}
