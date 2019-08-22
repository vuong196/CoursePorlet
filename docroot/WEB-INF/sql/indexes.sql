create index IX_5CBCC82B on Course (CourseId);
create index IX_A9617F47 on Course (Status);
create index IX_E4DE4153 on Course (uuid_);
create index IX_7B71C0F5 on Course (uuid_, companyId);
create unique index IX_30F000B7 on Course (uuid_, groupId);

create index IX_84D1C4FB on Course-Registration (courseId);
create index IX_7024D8E1 on Course-Registration (courseId, status);
create index IX_11A3F235 on Course-Registration (courseId, userId);
create index IX_8D2F7017 on Course-Registration (status);
create index IX_2EAE896B on Course-Registration (userId);
create index IX_C0EE2D51 on Course-Registration (userId, status);
create index IX_D5F8E63 on Course-Registration (uuid_);

create index IX_93EDEAE4 on CourseRegistration (courseId);
create index IX_799505CA on CourseRegistration (courseId, status);
create index IX_1B141F1E on CourseRegistration (courseId, userId);
create index IX_85BDFC40 on CourseRegistration (status);
create index IX_273D1594 on CourseRegistration (userId);
create index IX_7726807A on CourseRegistration (userId, status);
create index IX_2E2A591A on CourseRegistration (uuid_);

create index IX_63BC8F3F on course_user (courseId);
create index IX_26D31F25 on course_user (courseId, status);
create index IX_C8523879 on course_user (courseId, userId);
create index IX_220FFB5B on course_user (status);
create index IX_C38F14AF on course_user (userId);
create index IX_413495 on course_user (userId, status);
create index IX_D85E8A9F on course_user (uuid_);
create index IX_48D6F029 on course_user (uuid_, companyId);
create unique index IX_A47F6CEB on course_user (uuid_, groupId);