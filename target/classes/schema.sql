DROP TABLE IF EXISTS tab_cocktail;
DROP TABLE IF EXISTS tab;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS cocktail;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS bottle_type;


CREATE TABLE bottle_type (
	bottle_type_id int NOT NULL AUTO_INCREMENT,
	name varchar (256) NOT NULL,
	PRIMARY KEY (bottle_type_id)
);

CREATE TABLE inventory (
	inventory_id int NOT NULL AUTO_INCREMENT,
	bottle_type_id int NOT NULL,
	name varchar(128) NOT NULL,
	cost int,
	size_in_oz int,
	in_inventory int,
	PRIMARY KEY (inventory_id),
	FOREIGN KEY (bottle_type_id) REFERENCES bottle_type (bottle_type_id) ON DELETE CASCADE
);


CREATE TABLE employee (
	employee_id int NOT NULL AUTO_INCREMENT,
	first_name varchar(128) NOT NULL,
	last_name varchar(128) NOT NULL,
	email varchar(256) NOT NULL,
	employee_role varchar(128) NOT NULL,
	PRIMARY KEY(employee_id)
);

CREATE TABLE cocktail (
	cocktail_id int NOT NULL AUTO_INCREMENT,
	name varchar(128) NOT NULL,
	bottle_type_id int NOT NULL,
	cost_to_customer int NOT NULL,
	instructions varchar(512) NOT NULL,
	ingrediants varchar(512) NOT NULL,
	PRIMARY KEY(cocktail_id),
	FOREIGN KEY (bottle_type_id) REFERENCES bottle_type (bottle_type_id) ON DELETE CASCADE
);

CREATE TABLE tab (
	tab_id int NOT NULL AUTO_INCREMENT,
	employee_id int NOT NULL,
	tax int NOT NULL,
	total decimal (10, 2) NOT NULL,
	PRIMARY KEY(tab_id),
	FOREIGN KEY (employee_id) REFERENCES employee (employee_id) ON DELETE CASCADE
);

CREATE TABLE tab_cocktail (
	tab_id int NOT NULL,
	cocktail_id int NOT NULL,
	FOREIGN KEY (tab_id) REFERENCES tab (tab_id) ON DELETE CASCADE,
	FOREIGN KEY (cocktail_id) REFERENCES cocktail (cocktail_id) ON DELETE CASCADE
);