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
 * Provides a wrapper for {@link MemberLocalService}.
 *
 * @author guyw
 * @see MemberLocalService
 * @generated
 */
public class MemberLocalServiceWrapper implements MemberLocalService,
	ServiceWrapper<MemberLocalService> {
	public MemberLocalServiceWrapper(MemberLocalService memberLocalService) {
		_memberLocalService = memberLocalService;
	}

	/**
	* Adds the member to the database. Also notifies the appropriate model listeners.
	*
	* @param member the member
	* @return the member that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member addMember(
		cmr.fandenatech.ndjangui.model.Member member)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.addMember(member);
	}

	/**
	* Creates a new member with the primary key. Does not add the member to the database.
	*
	* @param memberId the primary key for the new member
	* @return the new member
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member createMember(long memberId) {
		return _memberLocalService.createMember(memberId);
	}

	/**
	* Deletes the member with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberId the primary key of the member
	* @return the member that was removed
	* @throws PortalException if a member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member deleteMember(long memberId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.deleteMember(memberId);
	}

	/**
	* Deletes the member from the database. Also notifies the appropriate model listeners.
	*
	* @param member the member
	* @return the member that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member deleteMember(
		cmr.fandenatech.ndjangui.model.Member member)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.deleteMember(member);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _memberLocalService.dynamicQuery();
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
		return _memberLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _memberLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _memberLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _memberLocalService.dynamicQueryCount(dynamicQuery);
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
		return _memberLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member fetchMember(long memberId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.fetchMember(memberId);
	}

	/**
	* Returns the member with the primary key.
	*
	* @param memberId the primary key of the member
	* @return the member
	* @throws PortalException if a member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member getMember(long memberId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.getMember(memberId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of members
	* @param end the upper bound of the range of members (not inclusive)
	* @return the range of members
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Member> getMembers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.getMembers(start, end);
	}

	/**
	* Returns the number of members.
	*
	* @return the number of members
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMembersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.getMembersCount();
	}

	/**
	* Updates the member in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param member the member
	* @return the member that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member updateMember(
		cmr.fandenatech.ndjangui.model.Member member)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.updateMember(member);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _memberLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_memberLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _memberLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member addMember(long companyId,
		long groupId, long userId, java.lang.String name,
		java.lang.String surname, java.lang.String email,
		java.lang.String cardNumber, java.lang.String phoneNumber,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.addMember(companyId, groupId, userId, name,
			surname, email, cardNumber, phoneNumber, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member updateMember(long memberId,
		long userId, java.lang.String name, java.lang.String surname,
		java.lang.String email, java.lang.String cardNumber,
		java.lang.String phoneNumber,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.updateMember(memberId, userId, name,
			surname, email, cardNumber, phoneNumber, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member deleteMember(long memberId,
		long userId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.deleteMember(memberId, userId, serviceContext);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member activateMember(long memberId,
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.activateMember(memberId, userId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Member> getMembersByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.getMembersByGroupId(groupId, start, end);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member removeMember(long memberId,
		long userId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.removeMember(memberId, userId, serviceContext);
	}

	@Override
	public int countMembersByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.countMembersByGroupId(groupId);
	}

	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Member> getMembersByGroupId_Status(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.getMembersByGroupId_Status(groupId, status,
			start, end);
	}

	@Override
	public int countMembersByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _memberLocalService.countMembersByGroupId_Status(groupId, status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MemberLocalService getWrappedMemberLocalService() {
		return _memberLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMemberLocalService(
		MemberLocalService memberLocalService) {
		_memberLocalService = memberLocalService;
	}

	@Override
	public MemberLocalService getWrappedService() {
		return _memberLocalService;
	}

	@Override
	public void setWrappedService(MemberLocalService memberLocalService) {
		_memberLocalService = memberLocalService;
	}

	private MemberLocalService _memberLocalService;
}