create table Course (
	uuid_ VARCHAR(75) null,
	CourseId LONG not null primary key,
	Name VARCHAR(75) null,
	Description VARCHAR(75) null,
	Lecturer VARCHAR(75) null,
	Duration INTEGER,
	Status BOOLEAN
);