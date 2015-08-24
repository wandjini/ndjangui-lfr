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
 * Provides a wrapper for {@link Member_FundLocalService}.
 *
 * @author guyw
 * @see Member_FundLocalService
 * @generated
 */
public class Member_FundLocalServiceWrapper implements Member_FundLocalService,
	ServiceWrapper<Member_FundLocalService> {
	public Member_FundLocalServiceWrapper(
		Member_FundLocalService member_FundLocalService) {
		_member_FundLocalService = member_FundLocalService;
	}

	/**
	* Adds the member_ fund to the database. Also notifies the appropriate model listeners.
	*
	* @param member_Fund the member_ fund
	* @return the member_ fund that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund addMember_Fund(
		cmr.fandenatech.ndjangui.model.Member_Fund member_Fund)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _member_FundLocalService.addMember_Fund(member_Fund);
	}

	/**
	* Creates a new member_ fund with the primary key. Does not add the member_ fund to the database.
	*
	* @param memberFundId the primary key for the new member_ fund
	* @return the new member_ fund
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund createMember_Fund(
		long memberFundId) {
		return _member_FundLocalService.createMember_Fund(memberFundId);
	}

	/**
	* Deletes the member_ fund with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberFundId the primary key of the member_ fund
	* @return the member_ fund that was removed
	* @throws PortalException if a member_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund deleteMember_Fund(
		long memberFundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _member_FundLocalService.deleteMember_Fund(memberFundId);
	}

	/**
	* Deletes the member_ fund from the database. Also notifies the appropriate model listeners.
	*
	* @param member_Fund the member_ fund
	* @return the member_ fund that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund deleteMember_Fund(
		cmr.fandenatech.ndjangui.model.Member_Fund member_Fund)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _member_FundLocalService.deleteMember_Fund(member_Fund);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _member_FundLocalService.dynamicQuery();
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
		return _member_FundLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.Member_FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _member_FundLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.Member_FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _member_FundLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _member_FundLocalService.dynamicQueryCount(dynamicQuery);
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
		return _member_FundLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund fetchMember_Fund(
		long memberFundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _member_FundLocalService.fetchMember_Fund(memberFundId);
	}

	/**
	* Returns the member_ fund with the primary key.
	*
	* @param memberFundId the primary key of the member_ fund
	* @return the member_ fund
	* @throws PortalException if a member_ fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund getMember_Fund(
		long memberFundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _member_FundLocalService.getMember_Fund(memberFundId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _member_FundLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the member_ funds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.Member_FundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of member_ funds
	* @param end the upper bound of the range of member_ funds (not inclusive)
	* @return the range of member_ funds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<cmr.fandenatech.ndjangui.model.Member_Fund> getMember_Funds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _member_FundLocalService.getMember_Funds(start, end);
	}

	/**
	* Returns the number of member_ funds.
	*
	* @return the number of member_ funds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMember_FundsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _member_FundLocalService.getMember_FundsCount();
	}

	/**
	* Updates the member_ fund in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param member_Fund the member_ fund
	* @return the member_ fund that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public cmr.fandenatech.ndjangui.model.Member_Fund updateMember_Fund(
		cmr.fandenatech.ndjangui.model.Member_Fund member_Fund)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _member_FundLocalService.updateMember_Fund(member_Fund);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _member_FundLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_member_FundLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _member_FundLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Member_FundLocalService getWrappedMember_FundLocalService() {
		return _member_FundLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMember_FundLocalService(
		Member_FundLocalService member_FundLocalService) {
		_member_FundLocalService = member_FundLocalService;
	}

	@Override
	public Member_FundLocalService getWrappedService() {
		return _member_FundLocalService;
	}

	@Override
	public void setWrappedService(
		Member_FundLocalService member_FundLocalService) {
		_member_FundLocalService = member_FundLocalService;
	}

	private Member_FundLocalService _member_FundLocalService;
}