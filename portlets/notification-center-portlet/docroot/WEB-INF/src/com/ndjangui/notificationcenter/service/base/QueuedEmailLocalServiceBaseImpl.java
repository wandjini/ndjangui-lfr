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

package com.ndjangui.notificationcenter.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.xpiping.notificationcenter.model.QueuedEmail;
import com.xpiping.notificationcenter.service.QueuedEmailLocalService;
import com.xpiping.notificationcenter.service.persistence.NotificaMessagePersistence;
import com.xpiping.notificationcenter.service.persistence.NotificaPersistence;
import com.xpiping.notificationcenter.service.persistence.NotificaTypePersistence;
import com.xpiping.notificationcenter.service.persistence.QueuedEmailPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the queued email local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ndjangui.notificationcenter.service.impl.QueuedEmailLocalServiceImpl}.
 * </p>
 *
 * @author marcoleo
 * @see com.ndjangui.notificationcenter.service.impl.QueuedEmailLocalServiceImpl
 * @see com.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil
 * @generated
 */
public abstract class QueuedEmailLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements QueuedEmailLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.xpiping.notificationcenter.service.QueuedEmailLocalServiceUtil} to access the queued email local service.
	 */

	/**
	 * Adds the queued email to the database. Also notifies the appropriate model listeners.
	 *
	 * @param queuedEmail the queued email
	 * @return the queued email that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public QueuedEmail addQueuedEmail(QueuedEmail queuedEmail)
		throws SystemException {
		queuedEmail.setNew(true);

		return queuedEmailPersistence.update(queuedEmail);
	}

	/**
	 * Creates a new queued email with the primary key. Does not add the queued email to the database.
	 *
	 * @param queuedEmailId the primary key for the new queued email
	 * @return the new queued email
	 */
	@Override
	public QueuedEmail createQueuedEmail(long queuedEmailId) {
		return queuedEmailPersistence.create(queuedEmailId);
	}

	/**
	 * Deletes the queued email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param queuedEmailId the primary key of the queued email
	 * @return the queued email that was removed
	 * @throws PortalException if a queued email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public QueuedEmail deleteQueuedEmail(long queuedEmailId)
		throws PortalException, SystemException {
		return queuedEmailPersistence.remove(queuedEmailId);
	}

	/**
	 * Deletes the queued email from the database. Also notifies the appropriate model listeners.
	 *
	 * @param queuedEmail the queued email
	 * @return the queued email that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public QueuedEmail deleteQueuedEmail(QueuedEmail queuedEmail)
		throws SystemException {
		return queuedEmailPersistence.remove(queuedEmail);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(QueuedEmail.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return queuedEmailPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return queuedEmailPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return queuedEmailPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return queuedEmailPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return queuedEmailPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public QueuedEmail fetchQueuedEmail(long queuedEmailId)
		throws SystemException {
		return queuedEmailPersistence.fetchByPrimaryKey(queuedEmailId);
	}

	/**
	 * Returns the queued email with the primary key.
	 *
	 * @param queuedEmailId the primary key of the queued email
	 * @return the queued email
	 * @throws PortalException if a queued email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QueuedEmail getQueuedEmail(long queuedEmailId)
		throws PortalException, SystemException {
		return queuedEmailPersistence.findByPrimaryKey(queuedEmailId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return queuedEmailPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the queued emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ndjangui.notificationcenter.model.impl.QueuedEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of queued emails
	 * @param end the upper bound of the range of queued emails (not inclusive)
	 * @return the range of queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<QueuedEmail> getQueuedEmails(int start, int end)
		throws SystemException {
		return queuedEmailPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of queued emails.
	 *
	 * @return the number of queued emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getQueuedEmailsCount() throws SystemException {
		return queuedEmailPersistence.countAll();
	}

	/**
	 * Updates the queued email in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param queuedEmail the queued email
	 * @return the queued email that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public QueuedEmail updateQueuedEmail(QueuedEmail queuedEmail)
		throws SystemException {
		return queuedEmailPersistence.update(queuedEmail);
	}

	/**
	 * Returns the notifica local service.
	 *
	 * @return the notifica local service
	 */
	public com.xpiping.notificationcenter.service.NotificaLocalService getNotificaLocalService() {
		return notificaLocalService;
	}

	/**
	 * Sets the notifica local service.
	 *
	 * @param notificaLocalService the notifica local service
	 */
	public void setNotificaLocalService(
		com.xpiping.notificationcenter.service.NotificaLocalService notificaLocalService) {
		this.notificaLocalService = notificaLocalService;
	}

	/**
	 * Returns the notifica remote service.
	 *
	 * @return the notifica remote service
	 */
	public com.xpiping.notificationcenter.service.NotificaService getNotificaService() {
		return notificaService;
	}

	/**
	 * Sets the notifica remote service.
	 *
	 * @param notificaService the notifica remote service
	 */
	public void setNotificaService(
		com.xpiping.notificationcenter.service.NotificaService notificaService) {
		this.notificaService = notificaService;
	}

	/**
	 * Returns the notifica persistence.
	 *
	 * @return the notifica persistence
	 */
	public NotificaPersistence getNotificaPersistence() {
		return notificaPersistence;
	}

	/**
	 * Sets the notifica persistence.
	 *
	 * @param notificaPersistence the notifica persistence
	 */
	public void setNotificaPersistence(NotificaPersistence notificaPersistence) {
		this.notificaPersistence = notificaPersistence;
	}

	/**
	 * Returns the notifica message local service.
	 *
	 * @return the notifica message local service
	 */
	public com.xpiping.notificationcenter.service.NotificaMessageLocalService getNotificaMessageLocalService() {
		return notificaMessageLocalService;
	}

	/**
	 * Sets the notifica message local service.
	 *
	 * @param notificaMessageLocalService the notifica message local service
	 */
	public void setNotificaMessageLocalService(
		com.xpiping.notificationcenter.service.NotificaMessageLocalService notificaMessageLocalService) {
		this.notificaMessageLocalService = notificaMessageLocalService;
	}

	/**
	 * Returns the notifica message remote service.
	 *
	 * @return the notifica message remote service
	 */
	public com.xpiping.notificationcenter.service.NotificaMessageService getNotificaMessageService() {
		return notificaMessageService;
	}

	/**
	 * Sets the notifica message remote service.
	 *
	 * @param notificaMessageService the notifica message remote service
	 */
	public void setNotificaMessageService(
		com.xpiping.notificationcenter.service.NotificaMessageService notificaMessageService) {
		this.notificaMessageService = notificaMessageService;
	}

	/**
	 * Returns the notifica message persistence.
	 *
	 * @return the notifica message persistence
	 */
	public NotificaMessagePersistence getNotificaMessagePersistence() {
		return notificaMessagePersistence;
	}

	/**
	 * Sets the notifica message persistence.
	 *
	 * @param notificaMessagePersistence the notifica message persistence
	 */
	public void setNotificaMessagePersistence(
		NotificaMessagePersistence notificaMessagePersistence) {
		this.notificaMessagePersistence = notificaMessagePersistence;
	}

	/**
	 * Returns the notifica type local service.
	 *
	 * @return the notifica type local service
	 */
	public com.xpiping.notificationcenter.service.NotificaTypeLocalService getNotificaTypeLocalService() {
		return notificaTypeLocalService;
	}

	/**
	 * Sets the notifica type local service.
	 *
	 * @param notificaTypeLocalService the notifica type local service
	 */
	public void setNotificaTypeLocalService(
		com.xpiping.notificationcenter.service.NotificaTypeLocalService notificaTypeLocalService) {
		this.notificaTypeLocalService = notificaTypeLocalService;
	}

	/**
	 * Returns the notifica type remote service.
	 *
	 * @return the notifica type remote service
	 */
	public com.xpiping.notificationcenter.service.NotificaTypeService getNotificaTypeService() {
		return notificaTypeService;
	}

	/**
	 * Sets the notifica type remote service.
	 *
	 * @param notificaTypeService the notifica type remote service
	 */
	public void setNotificaTypeService(
		com.xpiping.notificationcenter.service.NotificaTypeService notificaTypeService) {
		this.notificaTypeService = notificaTypeService;
	}

	/**
	 * Returns the notifica type persistence.
	 *
	 * @return the notifica type persistence
	 */
	public NotificaTypePersistence getNotificaTypePersistence() {
		return notificaTypePersistence;
	}

	/**
	 * Sets the notifica type persistence.
	 *
	 * @param notificaTypePersistence the notifica type persistence
	 */
	public void setNotificaTypePersistence(
		NotificaTypePersistence notificaTypePersistence) {
		this.notificaTypePersistence = notificaTypePersistence;
	}

	/**
	 * Returns the queued email local service.
	 *
	 * @return the queued email local service
	 */
	public com.xpiping.notificationcenter.service.QueuedEmailLocalService getQueuedEmailLocalService() {
		return queuedEmailLocalService;
	}

	/**
	 * Sets the queued email local service.
	 *
	 * @param queuedEmailLocalService the queued email local service
	 */
	public void setQueuedEmailLocalService(
		com.xpiping.notificationcenter.service.QueuedEmailLocalService queuedEmailLocalService) {
		this.queuedEmailLocalService = queuedEmailLocalService;
	}

	/**
	 * Returns the queued email remote service.
	 *
	 * @return the queued email remote service
	 */
	public com.xpiping.notificationcenter.service.QueuedEmailService getQueuedEmailService() {
		return queuedEmailService;
	}

	/**
	 * Sets the queued email remote service.
	 *
	 * @param queuedEmailService the queued email remote service
	 */
	public void setQueuedEmailService(
		com.xpiping.notificationcenter.service.QueuedEmailService queuedEmailService) {
		this.queuedEmailService = queuedEmailService;
	}

	/**
	 * Returns the queued email persistence.
	 *
	 * @return the queued email persistence
	 */
	public QueuedEmailPersistence getQueuedEmailPersistence() {
		return queuedEmailPersistence;
	}

	/**
	 * Sets the queued email persistence.
	 *
	 * @param queuedEmailPersistence the queued email persistence
	 */
	public void setQueuedEmailPersistence(
		QueuedEmailPersistence queuedEmailPersistence) {
		this.queuedEmailPersistence = queuedEmailPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.xpiping.notificationcenter.model.QueuedEmail",
			queuedEmailLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.xpiping.notificationcenter.model.QueuedEmail");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return QueuedEmail.class;
	}

	protected String getModelClassName() {
		return QueuedEmail.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = queuedEmailPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.xpiping.notificationcenter.service.NotificaLocalService.class)
	protected com.xpiping.notificationcenter.service.NotificaLocalService notificaLocalService;
	@BeanReference(type = com.xpiping.notificationcenter.service.NotificaService.class)
	protected com.xpiping.notificationcenter.service.NotificaService notificaService;
	@BeanReference(type = NotificaPersistence.class)
	protected NotificaPersistence notificaPersistence;
	@BeanReference(type = com.xpiping.notificationcenter.service.NotificaMessageLocalService.class)
	protected com.xpiping.notificationcenter.service.NotificaMessageLocalService notificaMessageLocalService;
	@BeanReference(type = com.xpiping.notificationcenter.service.NotificaMessageService.class)
	protected com.xpiping.notificationcenter.service.NotificaMessageService notificaMessageService;
	@BeanReference(type = NotificaMessagePersistence.class)
	protected NotificaMessagePersistence notificaMessagePersistence;
	@BeanReference(type = com.xpiping.notificationcenter.service.NotificaTypeLocalService.class)
	protected com.xpiping.notificationcenter.service.NotificaTypeLocalService notificaTypeLocalService;
	@BeanReference(type = com.xpiping.notificationcenter.service.NotificaTypeService.class)
	protected com.xpiping.notificationcenter.service.NotificaTypeService notificaTypeService;
	@BeanReference(type = NotificaTypePersistence.class)
	protected NotificaTypePersistence notificaTypePersistence;
	@BeanReference(type = com.xpiping.notificationcenter.service.QueuedEmailLocalService.class)
	protected com.xpiping.notificationcenter.service.QueuedEmailLocalService queuedEmailLocalService;
	@BeanReference(type = com.xpiping.notificationcenter.service.QueuedEmailService.class)
	protected com.xpiping.notificationcenter.service.QueuedEmailService queuedEmailService;
	@BeanReference(type = QueuedEmailPersistence.class)
	protected QueuedEmailPersistence queuedEmailPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private QueuedEmailLocalServiceClpInvoker _clpInvoker = new QueuedEmailLocalServiceClpInvoker();
}