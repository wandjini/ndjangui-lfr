create table xpiping_notificationcenter_Notifica (
	notificaId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	notificaTypeId LONG,
	name VARCHAR(75) null,
	text_ TEXT null,
	subject VARCHAR(75) null,
	description VARCHAR(75) null,
	aviable BOOLEAN,
	ignoreIntersaction BOOLEAN,
	orgsIds VARCHAR(75) null,
	groupsIds VARCHAR(75) null,
	rolesIds VARCHAR(75) null,
	lastCheckDate DATE null,
	deleted BOOLEAN
);

create table xpiping_notificationcenter_NotificaMessage (
	notificaMessageId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	notificaId LONG,
	userId LONG,
	entityId LONG,
	entityName VARCHAR(75) null,
	queuedEmailId LONG
);

create table xpiping_notificationcenter_NotificaType (
	notificaTypeId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	messageDestination VARCHAR(75) null,
	description VARCHAR(75) null,
	placeHolders TEXT null,
	aviable BOOLEAN
);

create table xpiping_notificationcenter_QueuedEmail (
	queuedEmailId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	from_ VARCHAR(75) null,
	fromName VARCHAR(75) null,
	to_ VARCHAR(75) null,
	toName VARCHAR(75) null,
	cc VARCHAR(75) null,
	bcc VARCHAR(75) null,
	subject STRING null,
	body TEXT null,
	attachmentFileName VARCHAR(75) null,
	attachmentFileEntryId LONG,
	sentTries LONG,
	sentOn DATE null
);