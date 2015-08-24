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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for MemberFund. This utility wraps
 * {@link cmr.fandenatech.ndjangui.service.impl.MemberFundLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author guyw
 * @see MemberFundLocalService
 * @see cmr.fandenatech.ndjangui.service.base.MemberFundLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.impl.MemberFundLocalServiceImpl
 * @generated
 */
public class MemberFundLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cmr.fandenatech.ndjangui.service.impl.MemberFundLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the member fund to the database. Also notifies the appropriate model listeners.
	*
	* @param memberFund the member fund
	* @return the member fund that was added
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberFund addMemberFund(
		cmr.fandenatech.ndjangui.model.MemberFund memberFund)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMemberFund(memberFund);
	}

	/**
	* Creates a new member fund with the primary key. Does not add the member fund to the database.
	*
	* @param memberFundId the primary key for the new member fund
	* @return the new member fund
	*/
	public static cmr.fandenatech.ndjangui.model.MemberFund createMemberFund(
		long memberFundId) {
		return getService().createMemberFund(memberFundId);
	}

	/**
	* Deletes the member fund with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberFundId the primary key of the member fund
	* @return the member fund that was removed
	* @throws PortalException if a member fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberFund deleteMemberFund(
		long memberFundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMemberFund(memberFundId);
	}

	/**
	* Deletes the member fund from the database. Also notifies the appropriate model listeners.
	*
	* @param memberFund the member fund
	* @return the member fund that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberFund deleteMemberFund(
		cmr.fandenatech.ndjangui.model.MemberFund memberFund)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMemberFund(memberFund);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberFundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberFundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static cmr.fandenatech.ndjangui.model.MemberFund fetchMemberFund(
		long memberFundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMemberFund(memberFundId);
	}

	/**
	* Returns the member fund with the primary key.
	*
	* @param memberFundId the primary key of the member fund
	* @return the member fund
	* @throws PortalException if a member fund with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberFund getMemberFund(
		long memberFundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMemberFund(memberFundId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the member funds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberFundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of member funds
	* @param end the upper bound of the range of member funds (not inclusive)
	* @return the range of member funds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberFund> getMemberFunds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMemberFunds(start, end);
	}

	/**
	* Returns the number of member funds.
	*
	* @return the number of member funds
	* @throws SystemException if a system exception occurred
	*/
	public static int getMemberFundsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMemberFundsCount();
	}

	/**
	* Updates the member fund in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param memberFund the member fund
	* @return the member fund that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberFund updateMemberFund(
		cmr.fandenatech.ndjangui.model.MemberFund memberFund)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMemberFund(memberFund);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static cmr.fandenatech.ndjangui.model.MemberFund addMemberFund(
		long groupId, long userId, long memberId, long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addMemberFund(groupId, userId, memberId, fundId);
	}

	public static cmr.fandenatech.ndjangui.model.MemberFund updateMemberFund(
		long memberFundId, long userId, long memberId, long fundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateMemberFund(memberFundId, userId, memberId, fundId);
	}

	public static cmr.fandenatech.ndjangui.model.MemberFund removeMemberFund(
		long memberFundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeMemberFund(memberFundId);
	}

	public static void clearService() {
		_service = null;
	}

	public static MemberFundLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MemberFundLocalService.class.getName());

			if (invokableLocalService instanceof MemberFundLocalService) {
				_service = (MemberFundLocalService)invokableLocalService;
			}
			else {
				_service = new MemberFundLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MemberFundLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MemberFundLocalService service) {
	}

	private static MemberFundLocalService _service;
}