package bar.os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bar.os.service.InventoryService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class InventoryController {

	
	@Autowired
	private InventoryService inventoryService;
}
