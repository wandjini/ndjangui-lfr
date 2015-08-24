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
 * Provides the local service utility for Sanction. This utility wraps
 * {@link cmr.fandenatech.ndjangui.service.impl.SanctionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author guyw
 * @see SanctionLocalService
 * @see cmr.fandenatech.ndjangui.service.base.SanctionLocalServiceBaseImpl
 * @see cmr.fandenatech.ndjangui.service.impl.SanctionLocalServiceImpl
 * @generated
 */
public class SanctionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link cmr.fandenatech.ndjangui.service.impl.SanctionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the sanction to the database. Also notifies the appropriate model listeners.
	*
	* @param sanction the sanction
	* @return the sanction that was added
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction addSanction(
		cmr.fandenatech.ndjangui.model.Sanction sanction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSanction(sanction);
	}

	/**
	* Creates a new sanction with the primary key. Does not add the sanction to the database.
	*
	* @param sanctionId the primary key for the new sanction
	* @return the new sanction
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction createSanction(
		long sanctionId) {
		return getService().createSanction(sanctionId);
	}

	/**
	* Deletes the sanction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sanctionId the primary key of the sanction
	* @return the sanction that was removed
	* @throws PortalException if a sanction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction deleteSanction(
		long sanctionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSanction(sanctionId);
	}

	/**
	* Deletes the sanction from the database. Also notifies the appropriate model listeners.
	*
	* @param sanction the sanction
	* @return the sanction that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction deleteSanction(
		cmr.fandenatech.ndjangui.model.Sanction sanction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSanction(sanction);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cmr.fandenatech.ndjangui.model.impl.SanctionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static cmr.fandenatech.ndjangui.model.Sanction fetchSanction(
		long sanctionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSanction(sanctionId);
	}

	/**
	* Returns the sanction with the primary key.
	*
	* @param sanctionId the primary key of the sanction
	* @return the sanction
	* @throws PortalException if a sanction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction getSanction(
		long sanctionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSanction(sanctionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> getSanctions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSanctions(start, end);
	}

	/**
	* Returns the number of sanctions.
	*
	* @return the number of sanctions
	* @throws SystemException if a system exception occurred
	*/
	public static int getSanctionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSanctionsCount();
	}

	/**
	* Updates the sanction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sanction the sanction
	* @return the sanction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static cmr.fandenatech.ndjangui.model.Sanction updateSanction(
		cmr.fandenatech.ndjangui.model.Sanction sanction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSanction(sanction);
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

	public static cmr.fandenatech.ndjangui.model.Sanction addSanction(
		long groupId, long userId, java.lang.String name, long budgetPeriodId,
		long sanctionTypeId, long sittingId, java.lang.String shortDescription,
		long srcFundClassPK, long destFundClassPK,
		java.lang.String srcFundClassName, java.lang.String destFundClassName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSanction(groupId, userId, name, budgetPeriodId,
			sanctionTypeId, sittingId, shortDescription, srcFundClassPK,
			destFundClassPK, srcFundClassName, destFundClassName, serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.Sanction updateSanction(
		long groupId, long userId, long sanctionId, java.lang.String name,
		long budgetPeriodId, long sanctionTypeId, long sittingId,
		java.lang.String shortDescription, long srcFundClassPK,
		long destFundClassPK, java.lang.String srcFundClassName,
		java.lang.String destFundClassName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSanction(groupId, userId, sanctionId, name,
			budgetPeriodId, sanctionTypeId, sittingId, shortDescription,
			srcFundClassPK, destFundClassPK, srcFundClassName,
			destFundClassName, serviceContext);
	}

	public static cmr.fandenatech.ndjangui.model.Sanction confirmSanction(
		long userId, long sanctionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().confirmSanction(userId, sanctionId);
	}

	public static cmr.fandenatech.ndjangui.model.Sanction openSanction(
		long userId, long sanctionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().openSanction(userId, sanctionId);
	}

	public static cmr.fandenatech.ndjangui.model.Sanction deleteSanction(
		long userId, long sanctionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSanction(userId, sanctionId);
	}

	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> getSanctionByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSanctionByGroupId(groupId, start, end);
	}

	public static int countSanctionsByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countSanctionsByGroupId(groupId);
	}

	public static java.util.List<cmr.fandenatech.ndjangui.model.Sanction> getSanctionsByGroupId_Status(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSanctionsByGroupId_Status(groupId, status, start, end);
	}

	public static int countSanctionsByGroupId_Status(long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countSanctionsByGroupId_Status(groupId, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static SanctionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SanctionLocalService.class.getName());

			if (invokableLocalService instanceof SanctionLocalService) {
				_service = (SanctionLocalService)invokableLocalService;
			}
			else {
				_service = new SanctionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SanctionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SanctionLocalService service) {
	}

	private static SanctionLocalService _service;
}