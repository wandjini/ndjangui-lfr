create index IX_5AD736B5 on ndjangui_Address (groupId);

create index IX_63D57219 on ndjangui_BudgetPeriod (groupId);
create index IX_3B3087FF on ndjangui_BudgetPeriod (groupId, status);

create index IX_5FA4A25A on ndjangui_Fund (groupId);
create index IX_E8893CAF on ndjangui_Fund (groupId, budgetPeriodId);
create index IX_722FE740 on ndjangui_Fund (groupId, status);

create index IX_5E6C97C0 on ndjangui_FundType (groupId);
create unique index IX_BBA6177F on ndjangui_FundType (groupId, name);
create index IX_4B7716A6 on ndjangui_FundType (groupId, status);

create unique index IX_C54024D2 on ndjangui_Member (cardNumber);
create unique index IX_3244F207 on ndjangui_Member (email);
create index IX_DE1838A5 on ndjangui_Member (groupId);
create unique index IX_6F317D2 on ndjangui_Member (groupId, cardNumber);
create unique index IX_33461F07 on ndjangui_Member (groupId, email);
create index IX_56BA028B on ndjangui_Member (groupId, status);

create index IX_61088757 on ndjangui_MemberSitting (groupId);
create index IX_3B30C540 on ndjangui_MemberSitting (groupId, sittingId);

create index IX_1FB0DA22 on ndjangui_Operation (groupId);
create index IX_EF8BD708 on ndjangui_Operation (groupId, status);

create index IX_4A87AB88 on ndjangui_OperationType (groupId);
create unique index IX_51C53547 on ndjangui_OperationType (groupId, name);
create index IX_D645E26E on ndjangui_OperationType (groupId, status);

create index IX_7687E48 on ndjangui_Sanction (groupId);
create index IX_987F52E on ndjangui_Sanction (groupId, status);

create index IX_87E4CCAE on ndjangui_SanctionType (groupId);
create unique index IX_DD3261ED on ndjangui_SanctionType (groupId, name);
create index IX_3B1A7D94 on ndjangui_SanctionType (groupId, status);

create index IX_B61D36D3 on ndjangui_Session (groupId);
create index IX_752CF2B9 on ndjangui_Session (groupId, status);

create index IX_FD36ADD on ndjangui_Sitting (groupId);
create index IX_6A1B7CC3 on ndjangui_Sitting (groupId, status);

create index IX_F353F8C5 on ndjangui_member (groupId);