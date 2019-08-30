create table Course (
	uuid_ VARCHAR(75) null,
	CourseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	Name VARCHAR(75) null,
	Description VARCHAR(75) null,
	Lecturer VARCHAR(75) null,
	Duration INTEGER,
	Status INTEGER
);

create table Course-Registration (
	uuid_ VARCHAR(75) null,
	id LONG not null primary key,
	courseId LONG,
	userId LONG,
	status INTEGER
);

create table CourseRegistration (
	uuid_ VARCHAR(75) null,
	id LONG not null primary key,
	courseId LONG,
	userId LONG,
	status INTEGER
);

create table course_user (
	uuid_ VARCHAR(75) null,
	id LONG not null primary key,
	courseId LONG,
	userId LONG,
	status INTEGER
);