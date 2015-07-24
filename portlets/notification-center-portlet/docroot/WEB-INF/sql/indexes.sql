create index IX_84ADEDE8 on xpiping_notificationcenter_Notifica (companyId);
create index IX_40C04EE0 on xpiping_notificationcenter_Notifica (notificaTypeId);

create index IX_7B049079 on xpiping_notificationcenter_NotificaMessage (notificaId);
create index IX_59F5310D on xpiping_notificationcenter_NotificaMessage (notificaId, entityName, entityId);

create index IX_EF3B99CE on xpiping_notificationcenter_NotificaType (companyId);
create unique index IX_1AF4A59 on xpiping_notificationcenter_NotificaType (name);

create index IX_3C4C8AFC on xpiping_notificationcenter_QueuedEmail (companyId);
create index IX_99176F7 on xpiping_notificationcenter_QueuedEmail (sentOn);