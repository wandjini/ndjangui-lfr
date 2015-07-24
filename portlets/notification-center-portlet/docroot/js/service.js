Liferay.Service.register("Liferay.Service.brother_notificationcenter", "it.brother.intranet.notificationcenter.service", "notification-center-portlet");

Liferay.Service.registerClass(
	Liferay.Service.brother_notificationcenter, "Notifica",
	{
		getNotifica: true,
		addNotifica: true,
		updateNotifica: true,
		getNotifiche: true,
		countNotifiche: true,
		sendNotificaInstantanea: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.brother_notificationcenter, "NotificaType",
	{
		addNotificaType: true,
		updateNotificaType: true,
		getNotificaType: true,
		getNotificheType: true,
		countNotificheType: true
	}
);