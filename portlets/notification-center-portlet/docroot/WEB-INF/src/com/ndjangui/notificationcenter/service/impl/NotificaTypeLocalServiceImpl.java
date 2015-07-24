/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ndjangui.notificationcenter.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ServiceContext;
import com.ndjangui.notificationcenter.service.base.NotificaTypeLocalServiceBaseImpl;
import com.xpiping.notificationcenter.NoSuchNotificaTypeException;
import com.xpiping.notificationcenter.model.Notifica;
import com.xpiping.notificationcenter.model.NotificaType;

/**
 * The implementation of the notifica type local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.xpiping.notificationcenter.service.NotificaTypeLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author marcol
 * @see com.ndjangui.notificationcenter.service.base.NotificaTypeLocalServiceBaseImpl
 * @see com.xpiping.notificationcenter.service.NotificaTypeLocalServiceUtil
 */
public class NotificaTypeLocalServiceImpl
	extends NotificaTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.xpiping.notificationcenter.service.NotificaTypeLocalServiceUtil
	 * } to access the notifica type local service.
	 */
	public NotificaType addNotificaType(
		String name, String description, String messageDestination,
		Boolean aviable, List<String> placeHolders,
		ServiceContext serviceContext)
		throws SystemException {

		String placeHoldersStr =
			StringUtil.merge(placeHolders, StringPool.COMMA);

		return addNotificaType(
			name, description, messageDestination, aviable, placeHoldersStr,
			serviceContext);

	}

	public NotificaType addNotificaType(
		String name, String description, String messageDestination,
		Boolean aviable, String placeHolders, ServiceContext serviceContext)
		throws SystemException {

		Date now = new Date();

		long notificaTypeId =
			counterLocalService.increment(NotificaType.class.getName());

		NotificaType notificaType =
			notificaTypePersistence.create(notificaTypeId);

		notificaType.setCompanyId(serviceContext.getCompanyId());
		notificaType.setCreateDate(now);
		notificaType.setModifiedDate(now);
		notificaType.setName(name);
		notificaType.setDescription(description);
		notificaType.setMessageDestination(messageDestination);
		notificaType.setAviable(aviable);
		notificaType.setPlaceHolders(placeHolders);

		notificaType = notificaTypePersistence.update(notificaType, false);

		return notificaType;
	}

	public NotificaType updateNotificaType(
		long notificaTypeId, String description, String messageDestination,
		Boolean aviable, List<String> placeHolders,
		ServiceContext serviceContext)
		throws SystemException {

		String placeHoldersStr =
			StringUtil.merge(placeHolders, StringPool.COMMA);

		return updateNotificaType(
			notificaTypeId, description, messageDestination, aviable,
			placeHoldersStr, serviceContext);
	}

	public NotificaType updateNotificaType(
		long notificaTypeId, String description, String messageDestination,
		Boolean aviable, String placeHolders, ServiceContext serviceContext)
		throws SystemException {

		Date now = new Date();

		NotificaType notificaType =
			notificaTypePersistence.fetchByPrimaryKey(notificaTypeId);

		notificaType.setModifiedDate(now);
		notificaType.setDescription(description);
		notificaType.setMessageDestination(messageDestination);
		notificaType.setAviable(aviable);
		notificaType.setPlaceHolders(placeHolders);

		notificaType = notificaTypePersistence.update(notificaType, false);

		return notificaType;
	}

	public List<NotificaType> getNotificheType(
		long companyId, int start, int end)
		throws SystemException {

		return notificaTypePersistence.findByCompanyId(companyId, start, end);
	}

	public int countNotificheType(long companyId)
		throws SystemException {

		return notificaTypePersistence.countByCompanyId(companyId);
	}
	
	public Boolean isNotificaTypeAviable(long notificaTypeId)
					throws PortalException, SystemException{
		
		NotificaType notificaType = getNotificaType(notificaTypeId);
		
		
		return notificaType.getAviable();
	}
	
	public NotificaType getNotificaTypeByName(String  notificaTypeName) 
					throws SystemException
					{
		
		NotificaType notificaType = null;
		//NoSuchNotificaTypeException
		try {
			notificaType = notificaTypePersistence.findByName(notificaTypeName);
		}
		catch (NoSuchNotificaTypeException e) {
			notificaType = null;
		}
		
		
		
		return notificaType;
	}
	
}