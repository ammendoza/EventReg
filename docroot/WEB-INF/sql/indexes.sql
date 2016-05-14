create index IX_459C94C7 on EVENTREG_Attendee (companyId, groupId);

create index IX_9AC0463D on EVENTREG_Event (companyId, groupId);
create index IX_52A4956E on EVENTREG_Event (title, description, location, status);