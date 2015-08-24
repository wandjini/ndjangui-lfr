/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package cmr.fandenatech.ndjangui.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SittingLocalService}.
 *
 * @author guyw
 * @see SittingLocalService
 * @generated
 */
public class SittingLocalServiceWrapper implements SittingLocalService,
	ServiceWrapper<SittingLocalService> {
	public SittingLocalServiceWrapper(SittingLocalService sittingLocalService) {
		_sittingLocalService = sittingLocalService;
	}

	/**
	* Adds the sitting to the database. Also notifies the appropriate model listeners.
	*
	* @param sitting the sitting
	* @return the sitting that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sitting addSitting(
		cmr.fandenatech.ndjangui.model.Sitting sitting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.addSitting(sitting);
	}

	/**
	* Creates a new sitting with the primary key. Does not add the sitting to the database.
	*
	* @param sittingId the primary key for the new sitting
	* @return the new sitting
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sitting createSitting(long sittingId) {
		return _sittingLocalService.createSitting(sittingId);
	}

	/**
	* Deletes the sitting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sittingId the primary key of the sitting
	* @return the sitting that was removed
	* @throws PortalException if a sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sitting deleteSitting(long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.deleteSitting(sittingId);
	}

	/**
	* Deletes the sitting from the database. Also notifies the appropriate model listeners.
	*
	* @param sitting the sitting
	* @return the sitting that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sitting deleteSitting(
		cmr.fandenatech.ndjangui.model.Sitting sitting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.deleteSitting(sitting);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sittingLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting fetchSitting(long sittingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.fetchSitting(sittingId);
	}

	/**
	* Returns the sitting with the primary key.
	*
	* @param sittingId the primary key of the sitting
	* @return the sitting
	* @throws PortalException if a sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sitting getSitting(long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.getSitting(sittingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the sittings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sittings
	* @param end the upper bound of the range of sittings (not inclusive)
	* @return the range of sittings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Sitting> getSittings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.getSittings(start, end);
	}

	/**
	* Returns the number of sittings.
	*
	* @return the number of sittings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSittingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.getSittingsCount();
	}

	/**
	* Updates the sitting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sitting the sitting
	* @return the sitting that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sitting updateSitting(
		cmr.fandenatech.ndjangui.model.Sitting sitting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.updateSitting(sitting);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sittingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sittingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sittingLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting addSitting(long groupId,
		long userId, java.lang.String name, java.lang.String dayPlan,
		java.lang.String notes,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.addSitting(groupId, userId, name, dayPlan,
			notes, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting updateSitting(long userId,
		long sittingId, java.lang.String name, java.lang.String dayPlan,
		java.lang.String notes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.updateSitting(userId, sittingId, name,
			dayPlan, notes);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting openSitting(long userId,
		long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.openSitting(userId, sittingId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting closeSitting(long userId,
		long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.closeSitting(userId, sittingId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sitting updateSittingStatus(
		long userId, long sittingId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.updateSittingStatus(userId, sittingId,
			status);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Sitting> getSittingsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.getSittingsByGroupId(groupId, start, end);
	}

	@Override
	public int countSittingsByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.countSittingsByGroupId(groupId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Sitting> getSittingsByGroupId_Status(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.getSittingsByGroupId_Status(groupId, status);
	}

	@Override
	public int countSittingsByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.countSittingsByGroupId_Status(groupId,
			status);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting addMemberSitting(
		long groupId, long userId, long sittingId, long memberId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.addMemberSitting(groupId, userId,
			sittingId, memberId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting removeMemberSitting(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sittingLocalService.removeMemberSitting(memberSittingId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SittingLocalService getWrappedSittingLocalService() {
		return _sittingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSittingLocalService(
		SittingLocalService sittingLocalService) {
		_sittingLocalService = sittingLocalService;
	}

	@Override
	public SittingLocalService getWrappedService() {
		return _sittingLocalService;
	}

	@Override
	public void setWrappedService(SittingLocalService sittingLocalService) {
		_sittingLocalService = sittingLocalService;
	}

	private SittingLocalService _sittingLocalService;
}