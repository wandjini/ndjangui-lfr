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
 * Provides a wrapper for {@link SanctionLocalService}.
 *
 * @author guyw
 * @see SanctionLocalService
 * @generated
 */
public class SanctionLocalServiceWrapper implements SanctionLocalService,
	ServiceWrapper<SanctionLocalService> {
	public SanctionLocalServiceWrapper(
		SanctionLocalService sanctionLocalService) {
		_sanctionLocalService = sanctionLocalService;
	}

	/**
	* Adds the sanction to the database. Also notifies the appropriate model listeners.
	*
	* @param sanction the sanction
	* @return the sanction that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sanction addSanction(
		cmr.fandenatech.ndjangui.model.Sanction sanction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.addSanction(sanction);
	}

	/**
	* Creates a new sanction with the primary key. Does not add the sanction to the database.
	*
	* @param sanctionId the primary key for the new sanction
	* @return the new sanction
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sanction createSanction(
		long sanctionId) {
		return _sanctionLocalService.createSanction(sanctionId);
	}

	/**
	* Deletes the sanction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sanctionId the primary key of the sanction
	* @return the sanction that was removed
	* @throws PortalException if a sanction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sanction deleteSanction(
		long sanctionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.deleteSanction(sanctionId);
	}

	/**
	* Deletes the sanction from the database. Also notifies the appropriate model listeners.
	*
	* @param sanction the sanction
	* @return the sanction that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sanction deleteSanction(
		cmr.fandenatech.ndjangui.model.Sanction sanction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.deleteSanction(sanction);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sanctionLocalService.dynamicQuery();
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
		return _sanctionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sanctionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sanctionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _sanctionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _sanctionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sanction fetchSanction(
		long sanctionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.fetchSanction(sanctionId);
	}

	/**
	* Returns the sanction with the primary key.
	*
	* @param sanctionId the primary key of the sanction
	* @return the sanction
	* @throws PortalException if a sanction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sanction getSanction(long sanctionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.getSanction(sanctionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the sanctions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sanctions
	* @param end the upper bound of the range of sanctions (not inclusive)
	* @return the range of sanctions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Sanction> getSanctions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.getSanctions(start, end);
	}

	/**
	* Returns the number of sanctions.
	*
	* @return the number of sanctions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSanctionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.getSanctionsCount();
	}

	/**
	* Updates the sanction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sanction the sanction
	* @return the sanction that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Sanction updateSanction(
		cmr.fandenatech.ndjangui.model.Sanction sanction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.updateSanction(sanction);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sanctionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sanctionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sanctionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sanction addSanction(long groupId,
		long userId, java.lang.String name, long budgetPeriodId,
		long sanctionTypeId, long sittingId, java.lang.String shortDescription,
		long srcFundClassPK, long destFundClassPK,
		java.lang.String srcFundClassName, java.lang.String destFundClassName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.addSanction(groupId, userId, name,
			budgetPeriodId, sanctionTypeId, sittingId, shortDescription,
			srcFundClassPK, destFundClassPK, srcFundClassName,
			destFundClassName, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sanction updateSanction(
		long groupId, long userId, long sanctionId, java.lang.String name,
		long budgetPeriodId, long sanctionTypeId, long sittingId,
		java.lang.String shortDescription, long srcFundClassPK,
		long destFundClassPK, java.lang.String srcFundClassName,
		java.lang.String destFundClassName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.updateSanction(groupId, userId,
			sanctionId, name, budgetPeriodId, sanctionTypeId, sittingId,
			shortDescription, srcFundClassPK, destFundClassPK,
			srcFundClassName, destFundClassName, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sanction confirmSanction(
		long userId, long sanctionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.confirmSanction(userId, sanctionId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sanction openSanction(long userId,
		long sanctionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.openSanction(userId, sanctionId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Sanction deleteSanction(long userId,
		long sanctionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.deleteSanction(userId, sanctionId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Sanction> getSanctionByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.getSanctionByGroupId(groupId, start, end);
	}

	@Override
	public int countSanctionsByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.countSanctionsByGroupId(groupId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Sanction> getSanctionsByGroupId_Status(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.getSanctionsByGroupId_Status(groupId,
			status, start, end);
	}

	@Override
	public int countSanctionsByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sanctionLocalService.countSanctionsByGroupId_Status(groupId,
			status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SanctionLocalService getWrappedSanctionLocalService() {
		return _sanctionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSanctionLocalService(
		SanctionLocalService sanctionLocalService) {
		_sanctionLocalService = sanctionLocalService;
	}

	@Override
	public SanctionLocalService getWrappedService() {
		return _sanctionLocalService;
	}

	@Override
	public void setWrappedService(SanctionLocalService sanctionLocalService) {
		_sanctionLocalService = sanctionLocalService;
	}

	private SanctionLocalService _sanctionLocalService;
}