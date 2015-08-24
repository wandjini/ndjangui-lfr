create table ndjangui_Address (
	addressId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	street VARCHAR(75) null,
	city VARCHAR(75) null,
	country VARCHAR(75) null,
	town VARCHAR(75) null,
	note VARCHAR(75) null
);

create table ndjangui_BudgetPeriod (
	budgetPeriodId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	shortDescription TEXT null,
	startDate DATE null,
	endDate DATE null,
	status INTEGER
);

create table ndjangui_Fund (
	fundId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	budgetPeriodId LONG,
	name VARCHAR(75) null,
	shortDescription TEXT null,
	fundTypeId LONG,
	fundType VARCHAR(75) null,
	status INTEGER
);

create table ndjangui_FundType (
	fundTypeId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	shortDescription TEXT null,
	status INTEGER
);

create table ndjangui_Member (
	memberId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	surname VARCHAR(75) null,
	fullname VARCHAR(75) null,
	email VARCHAR(75) null,
	cardNumber VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	rate DOUBLE,
	status INTEGER
);

create table ndjangui_MemberFund (
	memberFundId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	memberId LONG,
	fundId LONG,
	memberName VARCHAR(75) null,
	fundName VARCHAR(75) null
);

create table ndjangui_MemberSitting (
	memberSittingId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	memberId LONG,
	sittingId LONG,
	memberName VARCHAR(75) null,
	sittingName VARCHAR(75) null
);

create table ndjangui_Member_Fund (
	memberFundId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	memberId LONG,
	fundId LONG
);

create table ndjangui_Operation (
	operationId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	budgetPeriodId LONG,
	name VARCHAR(75) null,
	shortDescription TEXT null,
	operationTypeId LONG,
	sittingId LONG,
	status INTEGER,
	amount DOUBLE,
	srcFundClassPK LONG,
	srcFundClassName VARCHAR(75) null,
	destFundClassPK LONG,
	destFundClassName VARCHAR(75) null
);

create table ndjangui_OperationType (
	operationTypeId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	shortDescription TEXT null,
	status INTEGER
);

create table ndjangui_Operation_Fund (
	operationFundId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	operationId LONG,
	srcFundClassPK LONG,
	srcFundClassName VARCHAR(75) null,
	destFundClassPK LONG,
	destFundClassName VARCHAR(75) null
);

create table ndjangui_Sanction (
	sanctionId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	memberId LONG,
	budgetPeriodId LONG,
	name VARCHAR(75) null,
	shortDescription TEXT null,
	sanctionTypeId LONG,
	sittingId LONG,
	amount DOUBLE,
	status INTEGER,
	srcFundClassPK LONG,
	srcFundClassName VARCHAR(75) null,
	destFundClassPK LONG,
	destFundClassName VARCHAR(75) null
);

create table ndjangui_SanctionType (
	sanctionTypeId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	shortDescription TEXT null,
	amount DOUBLE,
	status INTEGER
);

create table ndjangui_Session (
	sessionId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	budgetPeriodId LONG,
	name VARCHAR(75) null,
	notes VARCHAR(75) null,
	status INTEGER
);

create table ndjangui_Sitting (
	sittingId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	startDate DATE null,
	startHour INTEGER,
	startMin INTEGER,
	endDate DATE null,
	endHour INTEGER,
	endMin INTEGER,
	budgetPeriodId LONG,
	name VARCHAR(75) null,
	dayPlan TEXT null,
	notes VARCHAR(75) null,
	status INTEGER
);

create table ndjangui_member (
	memberId LONG not null primary key,
	userId LONG,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	surname VARCHAR(75) null,
	fullname VARCHAR(75) null,
	email VARCHAR(75) null
);