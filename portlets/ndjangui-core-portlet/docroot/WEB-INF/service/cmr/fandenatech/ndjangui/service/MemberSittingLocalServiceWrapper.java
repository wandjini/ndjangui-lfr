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
 * Provides a wrapper for {@link MemberSittingLocalService}.
 *
 * @author guyw
 * @see MemberSittingLocalService
 * @generated
 */
public class MemberSittingLocalServiceWrapper
	implements MemberSittingLocalService,
		ServiceWrapper<MemberSittingLocalService> {
	public MemberSittingLocalServiceWrapper(
		MemberSittingLocalService memberSittingLocalService) {
		_memberSittingLocalService = memberSittingLocalService;
	}

	/**
	* Adds the member sitting to the database. Also notifies the appropriate model listeners.
	*
	* @param memberSitting the member sitting
	* @return the member sitting that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting addMemberSitting(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.addMemberSitting(memberSitting);
	}

	/**
	* Creates a new member sitting with the primary key. Does not add the member sitting to the database.
	*
	* @param memberSittingId the primary key for the new member sitting
	* @return the new member sitting
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting createMemberSitting(
		long memberSittingId) {
		return _memberSittingLocalService.createMemberSitting(memberSittingId);
	}

	/**
	* Deletes the member sitting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberSittingId the primary key of the member sitting
	* @return the member sitting that was removed
	* @throws PortalException if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting deleteMemberSitting(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.deleteMemberSitting(memberSittingId);
	}

	/**
	* Deletes the member sitting from the database. Also notifies the appropriate model listeners.
	*
	* @param memberSitting the member sitting
	* @return the member sitting that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting deleteMemberSitting(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.deleteMemberSitting(memberSitting);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _memberSittingLocalService.dynamicQuery();
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
		return _memberSittingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _memberSittingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _memberSittingLocalService.dynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _memberSittingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting fetchMemberSitting(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.fetchMemberSitting(memberSittingId);
	}

	/**
	* Returns the member sitting with the primary key.
	*
	* @param memberSittingId the primary key of the member sitting
	* @return the member sitting
	* @throws PortalException if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting getMemberSitting(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.getMemberSitting(memberSittingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the member sittings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of member sittings
	* @param end the upper bound of the range of member sittings (not inclusive)
	* @return the range of member sittings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> getMemberSittings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.getMemberSittings(start, end);
	}

	/**
	* Returns the number of member sittings.
	*
	* @return the number of member sittings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMemberSittingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.getMemberSittingsCount();
	}

	/**
	* Updates the member sitting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param memberSitting the member sitting
	* @return the member sitting that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting updateMemberSitting(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.updateMemberSitting(memberSitting);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _memberSittingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_memberSittingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _memberSittingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting addMemberSitting(
		long groupId, long userId, long memberId, long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.addMemberSitting(groupId, userId,
			memberId, sittingId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting updateMemberSitting(
		long memberSittingId, long userId, long memberId, long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.updateMemberSitting(memberSittingId,
			userId, memberId, sittingId);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.MemberSitting removeMemberSitting(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.removeMemberSitting(memberSittingId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> getMembersSittingByGroupId(
		long groupId, long sittingId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.getMembersSittingByGroupId(groupId,
			sittingId, start, end);
	}

	@Override
	public int contMembersSittingByGroupId(long groupId, long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberSittingLocalService.contMembersSittingByGroupId(groupId,
			sittingId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MemberSittingLocalService getWrappedMemberSittingLocalService() {
		return _memberSittingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMemberSittingLocalService(
		MemberSittingLocalService memberSittingLocalService) {
		_memberSittingLocalService = memberSittingLocalService;
	}

	@Override
	public MemberSittingLocalService getWrappedService() {
		return _memberSittingLocalService;
	}

	@Override
	public void setWrappedService(
		MemberSittingLocalService memberSittingLocalService) {
		_memberSittingLocalService = memberSittingLocalService;
	}

	private MemberSittingLocalService _memberSittingLocalService;
}