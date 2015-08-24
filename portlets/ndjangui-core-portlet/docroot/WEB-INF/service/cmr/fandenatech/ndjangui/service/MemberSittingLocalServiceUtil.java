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
 * Provides the local service utility for MemberSitting. This utility wraps
 * {@link cmr.fandenatech.ndjangui.service.impl.MemberSittingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author guyw
 * @see MemberSittingLocalService
 * @see cmr.fandenatech.ndjangui.service.base.MemberSittingLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.impl.MemberSittingLocalServiceImpl
 * @generated
 */
public class MemberSittingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cmr.fandenatech.ndjangui.service.impl.MemberSittingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the member sitting to the database. Also notifies the appropriate model listeners.
	*
	* @param memberSitting the member sitting
	* @return the member sitting that was added
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting addMemberSitting(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMemberSitting(memberSitting);
	}

	/**
	* Creates a new member sitting with the primary key. Does not add the member sitting to the database.
	*
	* @param memberSittingId the primary key for the new member sitting
	* @return the new member sitting
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting createMemberSitting(
		long memberSittingId) {
		return getService().createMemberSitting(memberSittingId);
	}

	/**
	* Deletes the member sitting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberSittingId the primary key of the member sitting
	* @return the member sitting that was removed
	* @throws PortalException if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting deleteMemberSitting(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMemberSitting(memberSittingId);
	}

	/**
	* Deletes the member sitting from the database. Also notifies the appropriate model listeners.
	*
	* @param memberSitting the member sitting
	* @return the member sitting that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting deleteMemberSitting(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMemberSitting(memberSitting);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.MemberSittingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static cmr.fandenatech.ndjangui.model.MemberSitting fetchMemberSitting(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMemberSitting(memberSittingId);
	}

	/**
	* Returns the member sitting with the primary key.
	*
	* @param memberSittingId the primary key of the member sitting
	* @return the member sitting
	* @throws PortalException if a member sitting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting getMemberSitting(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMemberSitting(memberSittingId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> getMemberSittings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMemberSittings(start, end);
	}

	/**
	* Returns the number of member sittings.
	*
	* @return the number of member sittings
	* @throws SystemException if a system exception occurred
	*/
	public static int getMemberSittingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMemberSittingsCount();
	}

	/**
	* Updates the member sitting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param memberSitting the member sitting
	* @return the member sitting that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.MemberSitting updateMemberSitting(
		cmr.fandenatech.ndjangui.model.MemberSitting memberSitting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMemberSitting(memberSitting);
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

	public static cmr.fandenatech.ndjangui.model.MemberSitting addMemberSitting(
		long groupId, long userId, long memberId, long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMemberSitting(groupId, userId, memberId, sittingId);
	}

	public static cmr.fandenatech.ndjangui.model.MemberSitting updateMemberSitting(
		long memberSittingId, long userId, long memberId, long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateMemberSitting(memberSittingId, userId, memberId,
			sittingId);
	}

	public static cmr.fandenatech.ndjangui.model.MemberSitting removeMemberSitting(
		long memberSittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeMemberSitting(memberSittingId);
	}

	public static java.util.List<cmr.fandenatech.ndjangui.model.MemberSitting> getMembersSittingByGroupId(
		long groupId, long sittingId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getMembersSittingByGroupId(groupId, sittingId, start, end);
	}

	public static int contMembersSittingByGroupId(long groupId, long sittingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().contMembersSittingByGroupId(groupId, sittingId);
	}

	public static void clearService() {
		_service = null;
	}

	public static MemberSittingLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MemberSittingLocalService.class.getName());

			if (invokableLocalService instanceof MemberSittingLocalService) {
				_service = (MemberSittingLocalService)invokableLocalService;
			}
			else {
				_service = new MemberSittingLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MemberSittingLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MemberSittingLocalService service) {
	}

	private static MemberSittingLocalService _service;
}