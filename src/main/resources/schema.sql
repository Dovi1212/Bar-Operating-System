DROP TABLE IF EXISTS tabs_cocktail;
DROP TABLE IF EXISTS tabs;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS bottle_type;
DROP TABLE IF EXISTS cocktail;
DROP TABLE IF EXISTS inventory;


CREATE TABLE bottle_type (
	type_id int NOT NULL AUTO_INCREMENT,
	name varchar (256) NOT NULL,
	PRIMARY KEY (type_id)
);

CREATE TABLE inventory (
	inventory_id int NOT NULL AUTO_INCREMENT,
	type_id int NOT NULL NOT NULL,
	name varchar(128) NOT NULL,
	cost int,
	size_in_oz int,
	in_inventory int,
	PRIMARY KEY (inventory_id),
	FOREIGN KEY (type_id) REFERENCES bottle_type (type_id) ON DELETE CASCADE
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
	type_id int NOT NULL,
	cost_to_customer int NOT NULL,
	instructions varchar(512) NOT NULL,
	ingrediants varchar(512) NOT NULL,
	PRIMARY KEY(cocktail_id),
	FOREIGN KEY (type_id) REFERENCES bottle_type (type_id) ON DELETE CASCADE
);

CREATE TABLE tabs (
	tabs_id int NOT NULL AUTO_INCREMENT,
	employee_id int NOT NULL,
	tax int NOT NULL,
	total decimal (10, 2) NOT NULL,
	PRIMARY KEY(tabs_id),
	FOREIGN KEY (employee_id) REFERENCES employee (employee_id) ON DELETE CASCADE
);

CREATE TABLE tabs_cocktail (
	tabs_id int NOT NULL,
	cocktail_id int NOT NULL,
	FOREIGN KEY (tabs_id) REFERENCES tabs (tabs_id) ON DELETE CASCADE,
	FOREIGN KEY (cocktail_id) REFERENCES cocktail (cocktail_id) ON DELETE CASCADE
);