create table EVENTREG_Attendee (
	attendeeId LONG not null primary key,
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
	eventOptionId LONG,
	managedBy LONG
);

create table EVENTREG_Event (
	eventId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	title STRING null,
	description STRING null,
	address STRING null,
	location STRING null,
	price DOUBLE,
	coordX VARCHAR(75) null,
	coordY VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	requiresApproval BOOLEAN,
	status INTEGER,
	createdBy LONG,
	startDate DATE null,
	endDate DATE null
);

create table EVENTREG_EventOption (
	eventOptionId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	startDate DATE null,
	endDate DATE null,
	seats INTEGER,
	eventId LONG
);

create table EVENTREG_Image (
	imageId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	eventId LONG,
	dlFileEntryId VARCHAR(75) null
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