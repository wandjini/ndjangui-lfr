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

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sort;

import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlEscapableObject;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.UniqueList;
import com.ndjangui.notificationcenter.messaging.impl.QueuedEmailSenderListner;
import com.ndjangui.notificationcenter.service.base.NotificaLocalServiceBaseImpl;
import com.ndjangui.notificationcenter.util.NotificationCenterUtils;
import com.xpiping.notificationcenter.NoSuchNotificaException;
import com.xpiping.notificationcenter.model.Notifica;
import com.xpiping.notificationcenter.model.NotificaMessage;
import com.xpiping.notificationcenter.model.NotificaType;
import com.xpiping.notificationcenter.service.NotificaMessageLocalServiceUtil;
import com.xpiping.notificationcenter.service.NotificaTypeLocalServiceUtil;

/**
 * The implementation of the notifica local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.xpiping.notificationcenter.service.NotificaLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author marcol
 * @see com.ndjangui.notificationcenter.service.base.NotificaLocalServiceBaseImpl
 * @see com.xpiping.notificationcenter.service.NotificaLocalServiceUtil
 */
public class NotificaLocalServiceImpl extends NotificaLocalServiceBaseImpl {

	private static Log _log =
		LogFactoryUtil.getLog(NotificaLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.xpiping.notificationcenter.service.NotificaLocalServiceUtil}
	 * to access the notifica local service.
	 */
	public Notifica addNotifica(
		long notificaTypeId, String name, String text, String subject,
		String description, Boolean aviable, Boolean ignoreIntersaction, String orgsIds, String groupsIds,
		String rolesIds, ServiceContext serviceContext)
		throws SystemException, PortalException {

		orgsIds = NotificationCenterUtils.formatOrganizationsIds(orgsIds);

		Date now = new Date();
		User user =
			userPersistence.findByPrimaryKey(serviceContext.getUserId());

		long notificaId =
			counterLocalService.increment(Notifica.class.getName());

		Notifica notifica = notificaPersistence.create(notificaId);

		notifica.setCompanyId(serviceContext.getCompanyId());
		notifica.setUserId(user.getUserId());
		notifica.setUserName(user.getFullName());
		notifica.setCreateDate(serviceContext.getCreateDate(now));
		notifica.setModifiedDate(serviceContext.getModifiedDate(now));

		notifica.setNotificaTypeId(notificaTypeId);
		notifica.setName(name);
		notifica.setText(text);
		notifica.setSubject(subject);
		notifica.setDescription(description);
		notifica.setAviable(aviable);
		notifica.setIgnoreIntersaction(ignoreIntersaction);
		notifica.setOrgsIds(orgsIds);
		notifica.setGroupsIds(groupsIds);
		notifica.setRolesIds(rolesIds);

		notificaPersistence.update(notifica, false);

		return notifica;
	}

	public Notifica updateNotifica(
		long notificaId, String text, String subject, String description,
		Boolean aviable,Boolean ignoreIntersaction, String orgsIds, String groupsIds, String rolesIds,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		orgsIds = NotificationCenterUtils.formatOrganizationsIds(orgsIds);

		Date now = new Date();

		Notifica notifica = notificaPersistence.findByPrimaryKey(notificaId);

		notifica.setModifiedDate(serviceContext.getModifiedDate(now));

		notifica.setText(text);
		notifica.setSubject(subject);
		notifica.setDescription(description);
		notifica.setAviable(aviable);
		notifica.setIgnoreIntersaction(ignoreIntersaction);
		notifica.setOrgsIds(orgsIds);
		notifica.setGroupsIds(groupsIds);
		notifica.setRolesIds(rolesIds);

		notificaPersistence.update(notifica, false);

		return notifica;
	}
	
	@Override
	public Notifica deleteNotifica(long notificaId)
		throws PortalException, SystemException {
	
		Notifica notifica = notificaPersistence.findByPrimaryKey(notificaId);
		return deleteNotifica(notifica);
	}
	
	@Override
	public Notifica deleteNotifica(Notifica notifica)
		throws SystemException {
	
		Date now = new Date();
		
		notifica.setModifiedDate(now);

		notifica.setDeleted(true);
		notifica.setAviable(false);

		notificaPersistence.update(notifica, false);

		return notifica;
	}
	
	

	public List<Notifica> getNotifiche(long companyId, int start, int end)
		throws SystemException {

		return notificaPersistence.findByCompanyId(companyId, start, end);
	}

	public int countNotifiche(long companyId)
		throws SystemException {

		return notificaPersistence.countByCompanyId(companyId);
	}

	public List<User> getUsersPerNotifica(long notificaId)
		throws PortalException, SystemException {

		Notifica notifica = getNotifica(notificaId);

		List<User> organizationUsers = new ArrayList<User>();
		List<User> userGropUsers = new ArrayList<User>();

		long[] orgsIds = null, userGroupsIds = null;

		if (StringUtils.isNotEmpty(notifica.getOrgsIds()))
			orgsIds =
				StringUtil.split(
					GetterUtil.getString(notifica.getOrgsIds()), 0L);
		if (StringUtils.isNotEmpty(notifica.getGroupsIds()))
			userGroupsIds =
				StringUtil.split(
					GetterUtil.getString(notifica.getGroupsIds()), 0L);

		organizationUsers = getOrganizationsUsers(orgsIds);
		userGropUsers = getUserGroupsUsers(userGroupsIds);
		// Bisogna fare l'intersezione delle tre liste

		List<User> users = intersection(organizationUsers, userGropUsers);

		users = sort(users, on(User.class).getFullName());

		return users;

	}

	List<User> getUserGroupsUsers(long[] userGroupIds)
		throws PortalException, SystemException {

		if (userGroupIds == null)
			return new ArrayList<User>();

		List<User> users = new UniqueList<User>();

		List<UserGroup> userGroups =
			UserGroupLocalServiceUtil.getUserGroups(userGroupIds);

		for (UserGroup userGroup : userGroups) {

			users.addAll(UserLocalServiceUtil.getUserGroupUsers(userGroup.getUserGroupId()));
		}

		return users;
	}

	List<User> getOrganizationsUsers(long[] organizationIds) {

		List<User> users = new UniqueList<User>();

		try {
			
			List<Organization> organizations = null;

			if (organizationIds == null){
				organizations =
						OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			}
			else{
				organizations =
					OrganizationLocalServiceUtil.getOrganizations(organizationIds);
			}
			for (Organization organization : organizations) {
				users.addAll(getOrganizationUsersByOrganization(organization));

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

	List<User> getOrganizationUsersByOrganization(Organization organization)
		throws SystemException {

		if (organization == null)
			return new ArrayList<User>();

		List<Organization> organizations = null;

		organizations = organization.getDescendants();

		organizations.add(organization);

		List<User> organizationUsers = new ArrayList<User>();

		for (Organization org : organizations) {
			organizationUsers.addAll(userLocalService.getOrganizationUsers(org.getOrganizationId()));
		}
		return organizationUsers;

	}

	/**
	 * @param list1
	 * @param list2
	 * @param list3
	 * @return Intersezione delle tre liste Le liste vuote vengono escluse,
	 *         poich� l'intersezione di un qualunque insieme A con l'insieme
	 *         vuoto � l'insieme vuoto
	 */
	private List<User> intersection(
		List<User> list1, List<User> list2, List<User> list3) {

		List<User> listToReturn = intersection(list1, list2);

		listToReturn = intersection(listToReturn, list3);

		return listToReturn;
	}

	/**
	 * @param list1
	 * @param list2
	 * @param list3
	 * @return Intersezione delle tre liste Le liste vuote vengono escluse,
	 *         poich� l'intersezione di un qualunque insieme A con l'insieme
	 *         vuoto � l'insieme vuoto
	 */
	private List<User> intersection(List<User> list1, List<User> list2) {

		if (list1 == null)
			list1 = new ArrayList<User>();

		if (list2 == null)
			list2 = new ArrayList<User>();

		if (list1.isEmpty() || list2.isEmpty()) {
			if (list1.isEmpty()) {
				// sicuramnte � l'altra lista ad essere vuota
				return list2;
			}
			else {
				// sicuramnte � l'unica lista piena
				return list1;
			}
		}

		return ListUtil.fromCollection(CollectionUtils.intersection(
			list1, list2));

	}

	public void sendNotificaType(
		String notificaTypeName, String entityName, long entityId,
		long[] userIds, Map<String, Object> placeHolders, boolean forceReSend) 
						throws PortalException {

		try {
			
			NotificaType notificaType =
				NotificaTypeLocalServiceUtil.getNotificaTypeByName(notificaTypeName);

			if (notificaType == null) {
				_log.error("Nessuna notificaType esiste con il nome: " +
					notificaTypeName);
				return;
			}
			if (!notificaType.getAviable()) {
				_log.info("NotificaType " + notificaTypeName +
					" non � attiva , entityname: " + entityName +
					", entityId:" + entityId);
				return;
			}

			List<Notifica> notifiche =
				notificaPersistence.findByNotificaTypeId(notificaType.getNotificaTypeId());
			
			List<User> users = getUsers(ArrayUtil
				.toArray(userIds));
			
			for (Notifica notifica : notifiche) {

				sendNotifica(notifica, entityName, entityId, users, placeHolders,forceReSend );
			}

		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendNotifica(
		long notificaId, String entityName, long entityId, List<User> users,
		Map<String, Object> placeHolders , boolean forceReSend)
		throws SystemException, PortalException {
		
		Notifica notifica = getNotifica(notificaId);
		
		sendNotifica(notifica, entityName, entityId, users, placeHolders, forceReSend);
	}
	
	public void sendNotifica(
		Notifica notifica, String entityName, long entityId, List<User> users,
		Map<String, Object> placeHolders , boolean forceReSend)
		throws SystemException, PortalException {

		if (notifica == null)
			return;

		if (!notifica.getAviable()) {
			_log.info("Notifica " + notifica.getName() +
				" non � attiva , entityname: " + entityName + ", entityId:" +
				entityId);
			return;
		}

		if (!forceReSend && notificaAllreadySent(notifica.getNotificaId(), entityName, entityId)) {
			_log.info("Notifica " + notifica.getName() +
				" � gi� stata inviata , entityname: " + entityName +
				", entityId:" + entityId);
			return;
		}

		List<User> usersToNotify = new ArrayList<User>();

		usersToNotify = getUsersPerNotifica(notifica.getNotificaId());

		if (usersToNotify == null) {
			_log.info("Notifica " + notifica.getName() +
				" nessun utente nella lista , entityname: " + entityName +
				", entityId:" + entityId);
			return;
		}
		if (usersToNotify.isEmpty()) {
			_log.info("Notifica " + notifica.getName() +
				" nessun utente nella lista , entityname: " + entityName +
				", entityId:" + entityId);
			return;
		}

		if (users != null && !users.isEmpty() && !notifica.getIgnoreIntersaction()) {
			usersToNotify = intersection(usersToNotify, users);
		}

		for (User user : usersToNotify) {

			String body =
				formatNotificaText(notifica.getText(), placeHolders, user);
			String subject =
				formatNotificaText(notifica.getSubject(), placeHolders, user);

			NotificaMessageLocalServiceUtil.addNotificaMessage(
				notifica.getCompanyId(), notifica.getNotificaId(), user, entityId,
				entityName, "" , body, subject);
			
		}

	}
	
	

	public String formatNotificaText(
		String textToReplace, Map<String, Object> tokens, User user) {

		textToReplace =
			StringUtil.replace(
				textToReplace,
				"[$NOME_UTENTE$]",
				new HtmlEscapableObject<String>(user.getFullName(), true).getEscapedValue());

		Format formatDateTimeFormat =
			FastDateFormatFactoryUtil.getDate(
				user.getLocale(), user.getTimeZone());

		for (Map.Entry<String, Object> token : tokens.entrySet()) {

			String value = null;

			if (token.getValue() instanceof Date) {
				value = formatDateTimeFormat.format(token.getValue());
			}
			else {
				value = GetterUtil.getString(token.getValue());
			}

			textToReplace =
				StringUtil.replace(
					textToReplace,
					token.getKey(),
					new HtmlEscapableObject<String>(value, true).getEscapedValue());

		}

		return textToReplace;

	}

	public Boolean notificaAllreadySent(
		long notificaId, String entityName, long entityId)
		throws SystemException {

		List<NotificaMessage> notificaMessages =
			NotificaMessageLocalServiceUtil.getNotificaMessages_N_E_E(
				notificaId, entityName, entityId);

		if (notificaMessages == null)
			return false;

		if (notificaMessages.isEmpty())
			return false;

		return true;
	}

	private List<User> getUsers(Long[] usersIds) throws PortalException,
	SystemException {

		if(usersIds.length == 0){
			return new ArrayList<User>();
		}
		
		long companyId = PortalUtil.getDefaultCompanyId();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class);
		
		dynamicQuery.add(PropertyFactoryUtil.forName("userId").in(usersIds));
		
		return UserLocalServiceUtil.dynamicQuery(dynamicQuery);
	
	}
	
	
	
}
