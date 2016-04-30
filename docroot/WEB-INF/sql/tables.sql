create table EVENTREG_Attendee (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name VARCHAR(75) null,
	surname VARCHAR(75) null,
	company VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null,
	registerDate DATE null,
	reservationCode VARCHAR(75) null,
	status INTEGER,
	managedBy LONG
);

create table EVENTREG_Event (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	title STRING null,
	description STRING null,
	address STRING null,
	location STRING null,
	coordX VARCHAR(75) null,
	coordY VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	requiresApproval BOOLEAN,
	status INTEGER,
	createdBy LONG
);

create table EVENTREG_EventOption (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	startDate DATE null,
	endDate DATE null,
	price DOUBLE
);

create table EVENTREG_Image (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG
);

create table EVENTREG_RegEvent (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	title STRING null,
	description STRING null,
	address STRING null,
	location STRING null,
	coordX VARCHAR(75) null,
	coordY VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	requiresApproval BOOLEAN,
	status INTEGER,
	createdBy LONG
);