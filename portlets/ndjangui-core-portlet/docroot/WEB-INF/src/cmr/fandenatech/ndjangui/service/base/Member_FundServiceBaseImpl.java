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

package cmr.fandenatech.ndjangui.service.base;

import cmr.fandenatech.ndjangui.model.Member_Fund;
import cmr.fandenatech.ndjangui.service.Member_FundService;
import cmr.fandenatech.ndjangui.service.persistence.AddressPersistence;
import cmr.fandenatech.ndjangui.service.persistence.BudgetPeriodPersistence;
import cmr.fandenatech.ndjangui.service.persistence.FundPersistence;
import cmr.fandenatech.ndjangui.service.persistence.FundTypePersistence;
import cmr.fandenatech.ndjangui.service.persistence.MemberPersistence;
import cmr.fandenatech.ndjangui.service.persistence.Member_FundPersistence;
import cmr.fandenatech.ndjangui.service.persistence.OperationPersistence;
import cmr.fandenatech.ndjangui.service.persistence.OperationTypePersistence;
import cmr.fandenatech.ndjangui.service.persistence.Operation_FundPersistence;
import cmr.fandenatech.ndjangui.service.persistence.SanctionPersistence;
import cmr.fandenatech.ndjangui.service.persistence.SanctionTypePersistence;
import cmr.fandenatech.ndjangui.service.persistence.SittingPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the member_ fund remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link cmr.fandenatech.ndjangui.service.impl.Member_FundServiceImpl}.
 * </p>
 *
 * @author guyw
 * @see cmr.fandenatech.ndjangui.service.impl.Member_FundServiceImpl
 * @see cmr.fandenatech.ndjangui.service.Member_FundServiceUtil
 * @generated
 */
public abstract class Member_FundServiceBaseImpl extends BaseServiceImpl
	implements Member_FundService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link cmr.fandenatech.ndjangui.service.Member_FundServiceUtil} to access the member_ fund remote service.
	 */

	/**
	 * Returns the address local service.
	 *
	 * @return the address local service
	 */
	public cmr.fandenatech.ndjangui.service.AddressLocalService getAddressLocalService() {
		return addressLocalService;
	}

	/**
	 * Sets the address local service.
	 *
	 * @param addressLocalService the address local service
	 */
	public void setAddressLocalService(
		cmr.fandenatech.ndjangui.service.AddressLocalService addressLocalService) {
		this.addressLocalService = addressLocalService;
	}

	/**
	 * Returns the address remote service.
	 *
	 * @return the address remote service
	 */
	public cmr.fandenatech.ndjangui.service.AddressService getAddressService() {
		return addressService;
	}

	/**
	 * Sets the address remote service.
	 *
	 * @param addressService the address remote service
	 */
	public void setAddressService(
		cmr.fandenatech.ndjangui.service.AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * Returns the address persistence.
	 *
	 * @return the address persistence
	 */
	public AddressPersistence getAddressPersistence() {
		return addressPersistence;
	}

	/**
	 * Sets the address persistence.
	 *
	 * @param addressPersistence the address persistence
	 */
	public void setAddressPersistence(AddressPersistence addressPersistence) {
		this.addressPersistence = addressPersistence;
	}

	/**
	 * Returns the budget period local service.
	 *
	 * @return the budget period local service
	 */
	public cmr.fandenatech.ndjangui.service.BudgetPeriodLocalService getBudgetPeriodLocalService() {
		return budgetPeriodLocalService;
	}

	/**
	 * Sets the budget period local service.
	 *
	 * @param budgetPeriodLocalService the budget period local service
	 */
	public void setBudgetPeriodLocalService(
		cmr.fandenatech.ndjangui.service.BudgetPeriodLocalService budgetPeriodLocalService) {
		this.budgetPeriodLocalService = budgetPeriodLocalService;
	}

	/**
	 * Returns the budget period remote service.
	 *
	 * @return the budget period remote service
	 */
	public cmr.fandenatech.ndjangui.service.BudgetPeriodService getBudgetPeriodService() {
		return budgetPeriodService;
	}

	/**
	 * Sets the budget period remote service.
	 *
	 * @param budgetPeriodService the budget period remote service
	 */
	public void setBudgetPeriodService(
		cmr.fandenatech.ndjangui.service.BudgetPeriodService budgetPeriodService) {
		this.budgetPeriodService = budgetPeriodService;
	}

	/**
	 * Returns the budget period persistence.
	 *
	 * @return the budget period persistence
	 */
	public BudgetPeriodPersistence getBudgetPeriodPersistence() {
		return budgetPeriodPersistence;
	}

	/**
	 * Sets the budget period persistence.
	 *
	 * @param budgetPeriodPersistence the budget period persistence
	 */
	public void setBudgetPeriodPersistence(
		BudgetPeriodPersistence budgetPeriodPersistence) {
		this.budgetPeriodPersistence = budgetPeriodPersistence;
	}

	/**
	 * Returns the fund local service.
	 *
	 * @return the fund local service
	 */
	public cmr.fandenatech.ndjangui.service.FundLocalService getFundLocalService() {
		return fundLocalService;
	}

	/**
	 * Sets the fund local service.
	 *
	 * @param fundLocalService the fund local service
	 */
	public void setFundLocalService(
		cmr.fandenatech.ndjangui.service.FundLocalService fundLocalService) {
		this.fundLocalService = fundLocalService;
	}

	/**
	 * Returns the fund remote service.
	 *
	 * @return the fund remote service
	 */
	public cmr.fandenatech.ndjangui.service.FundService getFundService() {
		return fundService;
	}

	/**
	 * Sets the fund remote service.
	 *
	 * @param fundService the fund remote service
	 */
	public void setFundService(
		cmr.fandenatech.ndjangui.service.FundService fundService) {
		this.fundService = fundService;
	}

	/**
	 * Returns the fund persistence.
	 *
	 * @return the fund persistence
	 */
	public FundPersistence getFundPersistence() {
		return fundPersistence;
	}

	/**
	 * Sets the fund persistence.
	 *
	 * @param fundPersistence the fund persistence
	 */
	public void setFundPersistence(FundPersistence fundPersistence) {
		this.fundPersistence = fundPersistence;
	}

	/**
	 * Returns the fund type local service.
	 *
	 * @return the fund type local service
	 */
	public cmr.fandenatech.ndjangui.service.FundTypeLocalService getFundTypeLocalService() {
		return fundTypeLocalService;
	}

	/**
	 * Sets the fund type local service.
	 *
	 * @param fundTypeLocalService the fund type local service
	 */
	public void setFundTypeLocalService(
		cmr.fandenatech.ndjangui.service.FundTypeLocalService fundTypeLocalService) {
		this.fundTypeLocalService = fundTypeLocalService;
	}

	/**
	 * Returns the fund type remote service.
	 *
	 * @return the fund type remote service
	 */
	public cmr.fandenatech.ndjangui.service.FundTypeService getFundTypeService() {
		return fundTypeService;
	}

	/**
	 * Sets the fund type remote service.
	 *
	 * @param fundTypeService the fund type remote service
	 */
	public void setFundTypeService(
		cmr.fandenatech.ndjangui.service.FundTypeService fundTypeService) {
		this.fundTypeService = fundTypeService;
	}

	/**
	 * Returns the fund type persistence.
	 *
	 * @return the fund type persistence
	 */
	public FundTypePersistence getFundTypePersistence() {
		return fundTypePersistence;
	}

	/**
	 * Sets the fund type persistence.
	 *
	 * @param fundTypePersistence the fund type persistence
	 */
	public void setFundTypePersistence(FundTypePersistence fundTypePersistence) {
		this.fundTypePersistence = fundTypePersistence;
	}

	/**
	 * Returns the member local service.
	 *
	 * @return the member local service
	 */
	public cmr.fandenatech.ndjangui.service.MemberLocalService getMemberLocalService() {
		return memberLocalService;
	}

	/**
	 * Sets the member local service.
	 *
	 * @param memberLocalService the member local service
	 */
	public void setMemberLocalService(
		cmr.fandenatech.ndjangui.service.MemberLocalService memberLocalService) {
		this.memberLocalService = memberLocalService;
	}

	/**
	 * Returns the member remote service.
	 *
	 * @return the member remote service
	 */
	public cmr.fandenatech.ndjangui.service.MemberService getMemberService() {
		return memberService;
	}

	/**
	 * Sets the member remote service.
	 *
	 * @param memberService the member remote service
	 */
	public void setMemberService(
		cmr.fandenatech.ndjangui.service.MemberService memberService) {
		this.memberService = memberService;
	}

	/**
	 * Returns the member persistence.
	 *
	 * @return the member persistence
	 */
	public MemberPersistence getMemberPersistence() {
		return memberPersistence;
	}

	/**
	 * Sets the member persistence.
	 *
	 * @param memberPersistence the member persistence
	 */
	public void setMemberPersistence(MemberPersistence memberPersistence) {
		this.memberPersistence = memberPersistence;
	}

	/**
	 * Returns the member_ fund local service.
	 *
	 * @return the member_ fund local service
	 */
	public cmr.fandenatech.ndjangui.service.Member_FundLocalService getMember_FundLocalService() {
		return member_FundLocalService;
	}

	/**
	 * Sets the member_ fund local service.
	 *
	 * @param member_FundLocalService the member_ fund local service
	 */
	public void setMember_FundLocalService(
		cmr.fandenatech.ndjangui.service.Member_FundLocalService member_FundLocalService) {
		this.member_FundLocalService = member_FundLocalService;
	}

	/**
	 * Returns the member_ fund remote service.
	 *
	 * @return the member_ fund remote service
	 */
	public cmr.fandenatech.ndjangui.service.Member_FundService getMember_FundService() {
		return member_FundService;
	}

	/**
	 * Sets the member_ fund remote service.
	 *
	 * @param member_FundService the member_ fund remote service
	 */
	public void setMember_FundService(
		cmr.fandenatech.ndjangui.service.Member_FundService member_FundService) {
		this.member_FundService = member_FundService;
	}

	/**
	 * Returns the member_ fund persistence.
	 *
	 * @return the member_ fund persistence
	 */
	public Member_FundPersistence getMember_FundPersistence() {
		return member_FundPersistence;
	}

	/**
	 * Sets the member_ fund persistence.
	 *
	 * @param member_FundPersistence the member_ fund persistence
	 */
	public void setMember_FundPersistence(
		Member_FundPersistence member_FundPersistence) {
		this.member_FundPersistence = member_FundPersistence;
	}

	/**
	 * Returns the operation local service.
	 *
	 * @return the operation local service
	 */
	public cmr.fandenatech.ndjangui.service.OperationLocalService getOperationLocalService() {
		return operationLocalService;
	}

	/**
	 * Sets the operation local service.
	 *
	 * @param operationLocalService the operation local service
	 */
	public void setOperationLocalService(
		cmr.fandenatech.ndjangui.service.OperationLocalService operationLocalService) {
		this.operationLocalService = operationLocalService;
	}

	/**
	 * Returns the operation remote service.
	 *
	 * @return the operation remote service
	 */
	public cmr.fandenatech.ndjangui.service.OperationService getOperationService() {
		return operationService;
	}

	/**
	 * Sets the operation remote service.
	 *
	 * @param operationService the operation remote service
	 */
	public void setOperationService(
		cmr.fandenatech.ndjangui.service.OperationService operationService) {
		this.operationService = operationService;
	}

	/**
	 * Returns the operation persistence.
	 *
	 * @return the operation persistence
	 */
	public OperationPersistence getOperationPersistence() {
		return operationPersistence;
	}

	/**
	 * Sets the operation persistence.
	 *
	 * @param operationPersistence the operation persistence
	 */
	public void setOperationPersistence(
		OperationPersistence operationPersistence) {
		this.operationPersistence = operationPersistence;
	}

	/**
	 * Returns the operation_ fund local service.
	 *
	 * @return the operation_ fund local service
	 */
	public cmr.fandenatech.ndjangui.service.Operation_FundLocalService getOperation_FundLocalService() {
		return operation_FundLocalService;
	}

	/**
	 * Sets the operation_ fund local service.
	 *
	 * @param operation_FundLocalService the operation_ fund local service
	 */
	public void setOperation_FundLocalService(
		cmr.fandenatech.ndjangui.service.Operation_FundLocalService operation_FundLocalService) {
		this.operation_FundLocalService = operation_FundLocalService;
	}

	/**
	 * Returns the operation_ fund remote service.
	 *
	 * @return the operation_ fund remote service
	 */
	public cmr.fandenatech.ndjangui.service.Operation_FundService getOperation_FundService() {
		return operation_FundService;
	}

	/**
	 * Sets the operation_ fund remote service.
	 *
	 * @param operation_FundService the operation_ fund remote service
	 */
	public void setOperation_FundService(
		cmr.fandenatech.ndjangui.service.Operation_FundService operation_FundService) {
		this.operation_FundService = operation_FundService;
	}

	/**
	 * Returns the operation_ fund persistence.
	 *
	 * @return the operation_ fund persistence
	 */
	public Operation_FundPersistence getOperation_FundPersistence() {
		return operation_FundPersistence;
	}

	/**
	 * Sets the operation_ fund persistence.
	 *
	 * @param operation_FundPersistence the operation_ fund persistence
	 */
	public void setOperation_FundPersistence(
		Operation_FundPersistence operation_FundPersistence) {
		this.operation_FundPersistence = operation_FundPersistence;
	}

	/**
	 * Returns the operation type local service.
	 *
	 * @return the operation type local service
	 */
	public cmr.fandenatech.ndjangui.service.OperationTypeLocalService getOperationTypeLocalService() {
		return operationTypeLocalService;
	}

	/**
	 * Sets the operation type local service.
	 *
	 * @param operationTypeLocalService the operation type local service
	 */
	public void setOperationTypeLocalService(
		cmr.fandenatech.ndjangui.service.OperationTypeLocalService operationTypeLocalService) {
		this.operationTypeLocalService = operationTypeLocalService;
	}

	/**
	 * Returns the operation type remote service.
	 *
	 * @return the operation type remote service
	 */
	public cmr.fandenatech.ndjangui.service.OperationTypeService getOperationTypeService() {
		return operationTypeService;
	}

	/**
	 * Sets the operation type remote service.
	 *
	 * @param operationTypeService the operation type remote service
	 */
	public void setOperationTypeService(
		cmr.fandenatech.ndjangui.service.OperationTypeService operationTypeService) {
		this.operationTypeService = operationTypeService;
	}

	/**
	 * Returns the operation type persistence.
	 *
	 * @return the operation type persistence
	 */
	public OperationTypePersistence getOperationTypePersistence() {
		return operationTypePersistence;
	}

	/**
	 * Sets the operation type persistence.
	 *
	 * @param operationTypePersistence the operation type persistence
	 */
	public void setOperationTypePersistence(
		OperationTypePersistence operationTypePersistence) {
		this.operationTypePersistence = operationTypePersistence;
	}

	/**
	 * Returns the sanction local service.
	 *
	 * @return the sanction local service
	 */
	public cmr.fandenatech.ndjangui.service.SanctionLocalService getSanctionLocalService() {
		return sanctionLocalService;
	}

	/**
	 * Sets the sanction local service.
	 *
	 * @param sanctionLocalService the sanction local service
	 */
	public void setSanctionLocalService(
		cmr.fandenatech.ndjangui.service.SanctionLocalService sanctionLocalService) {
		this.sanctionLocalService = sanctionLocalService;
	}

	/**
	 * Returns the sanction remote service.
	 *
	 * @return the sanction remote service
	 */
	public cmr.fandenatech.ndjangui.service.SanctionService getSanctionService() {
		return sanctionService;
	}

	/**
	 * Sets the sanction remote service.
	 *
	 * @param sanctionService the sanction remote service
	 */
	public void setSanctionService(
		cmr.fandenatech.ndjangui.service.SanctionService sanctionService) {
		this.sanctionService = sanctionService;
	}

	/**
	 * Returns the sanction persistence.
	 *
	 * @return the sanction persistence
	 */
	public SanctionPersistence getSanctionPersistence() {
		return sanctionPersistence;
	}

	/**
	 * Sets the sanction persistence.
	 *
	 * @param sanctionPersistence the sanction persistence
	 */
	public void setSanctionPersistence(SanctionPersistence sanctionPersistence) {
		this.sanctionPersistence = sanctionPersistence;
	}

	/**
	 * Returns the sanction type local service.
	 *
	 * @return the sanction type local service
	 */
	public cmr.fandenatech.ndjangui.service.SanctionTypeLocalService getSanctionTypeLocalService() {
		return sanctionTypeLocalService;
	}

	/**
	 * Sets the sanction type local service.
	 *
	 * @param sanctionTypeLocalService the sanction type local service
	 */
	public void setSanctionTypeLocalService(
		cmr.fandenatech.ndjangui.service.SanctionTypeLocalService sanctionTypeLocalService) {
		this.sanctionTypeLocalService = sanctionTypeLocalService;
	}

	/**
	 * Returns the sanction type remote service.
	 *
	 * @return the sanction type remote service
	 */
	public cmr.fandenatech.ndjangui.service.SanctionTypeService getSanctionTypeService() {
		return sanctionTypeService;
	}

	/**
	 * Sets the sanction type remote service.
	 *
	 * @param sanctionTypeService the sanction type remote service
	 */
	public void setSanctionTypeService(
		cmr.fandenatech.ndjangui.service.SanctionTypeService sanctionTypeService) {
		this.sanctionTypeService = sanctionTypeService;
	}

	/**
	 * Returns the sanction type persistence.
	 *
	 * @return the sanction type persistence
	 */
	public SanctionTypePersistence getSanctionTypePersistence() {
		return sanctionTypePersistence;
	}

	/**
	 * Sets the sanction type persistence.
	 *
	 * @param sanctionTypePersistence the sanction type persistence
	 */
	public void setSanctionTypePersistence(
		SanctionTypePersistence sanctionTypePersistence) {
		this.sanctionTypePersistence = sanctionTypePersistence;
	}

	/**
	 * Returns the sitting local service.
	 *
	 * @return the sitting local service
	 */
	public cmr.fandenatech.ndjangui.service.SittingLocalService getSittingLocalService() {
		return sittingLocalService;
	}

	/**
	 * Sets the sitting local service.
	 *
	 * @param sittingLocalService the sitting local service
	 */
	public void setSittingLocalService(
		cmr.fandenatech.ndjangui.service.SittingLocalService sittingLocalService) {
		this.sittingLocalService = sittingLocalService;
	}

	/**
	 * Returns the sitting remote service.
	 *
	 * @return the sitting remote service
	 */
	public cmr.fandenatech.ndjangui.service.SittingService getSittingService() {
		return sittingService;
	}

	/**
	 * Sets the sitting remote service.
	 *
	 * @param sittingService the sitting remote service
	 */
	public void setSittingService(
		cmr.fandenatech.ndjangui.service.SittingService sittingService) {
		this.sittingService = sittingService;
	}

	/**
	 * Returns the sitting persistence.
	 *
	 * @return the sitting persistence
	 */
	public SittingPersistence getSittingPersistence() {
		return sittingPersistence;
	}

	/**
	 * Sets the sitting persistence.
	 *
	 * @param sittingPersistence the sitting persistence
	 */
	public void setSittingPersistence(SittingPersistence sittingPersistence) {
		this.sittingPersistence = sittingPersistence;
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
	}

	public void destroy() {
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
		return Member_Fund.class;
	}

	protected String getModelClassName() {
		return Member_Fund.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = member_FundPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = cmr.fandenatech.ndjangui.service.AddressLocalService.class)
	protected cmr.fandenatech.ndjangui.service.AddressLocalService addressLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.AddressService.class)
	protected cmr.fandenatech.ndjangui.service.AddressService addressService;
	@BeanReference(type = AddressPersistence.class)
	protected AddressPersistence addressPersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.BudgetPeriodLocalService.class)
	protected cmr.fandenatech.ndjangui.service.BudgetPeriodLocalService budgetPeriodLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.BudgetPeriodService.class)
	protected cmr.fandenatech.ndjangui.service.BudgetPeriodService budgetPeriodService;
	@BeanReference(type = BudgetPeriodPersistence.class)
	protected BudgetPeriodPersistence budgetPeriodPersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.FundLocalService.class)
	protected cmr.fandenatech.ndjangui.service.FundLocalService fundLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.FundService.class)
	protected cmr.fandenatech.ndjangui.service.FundService fundService;
	@BeanReference(type = FundPersistence.class)
	protected FundPersistence fundPersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.FundTypeLocalService.class)
	protected cmr.fandenatech.ndjangui.service.FundTypeLocalService fundTypeLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.FundTypeService.class)
	protected cmr.fandenatech.ndjangui.service.FundTypeService fundTypeService;
	@BeanReference(type = FundTypePersistence.class)
	protected FundTypePersistence fundTypePersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.MemberLocalService.class)
	protected cmr.fandenatech.ndjangui.service.MemberLocalService memberLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.MemberService.class)
	protected cmr.fandenatech.ndjangui.service.MemberService memberService;
	@BeanReference(type = MemberPersistence.class)
	protected MemberPersistence memberPersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.Member_FundLocalService.class)
	protected cmr.fandenatech.ndjangui.service.Member_FundLocalService member_FundLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.Member_FundService.class)
	protected cmr.fandenatech.ndjangui.service.Member_FundService member_FundService;
	@BeanReference(type = Member_FundPersistence.class)
	protected Member_FundPersistence member_FundPersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.OperationLocalService.class)
	protected cmr.fandenatech.ndjangui.service.OperationLocalService operationLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.OperationService.class)
	protected cmr.fandenatech.ndjangui.service.OperationService operationService;
	@BeanReference(type = OperationPersistence.class)
	protected OperationPersistence operationPersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.Operation_FundLocalService.class)
	protected cmr.fandenatech.ndjangui.service.Operation_FundLocalService operation_FundLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.Operation_FundService.class)
	protected cmr.fandenatech.ndjangui.service.Operation_FundService operation_FundService;
	@BeanReference(type = Operation_FundPersistence.class)
	protected Operation_FundPersistence operation_FundPersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.OperationTypeLocalService.class)
	protected cmr.fandenatech.ndjangui.service.OperationTypeLocalService operationTypeLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.OperationTypeService.class)
	protected cmr.fandenatech.ndjangui.service.OperationTypeService operationTypeService;
	@BeanReference(type = OperationTypePersistence.class)
	protected OperationTypePersistence operationTypePersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.SanctionLocalService.class)
	protected cmr.fandenatech.ndjangui.service.SanctionLocalService sanctionLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.SanctionService.class)
	protected cmr.fandenatech.ndjangui.service.SanctionService sanctionService;
	@BeanReference(type = SanctionPersistence.class)
	protected SanctionPersistence sanctionPersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.SanctionTypeLocalService.class)
	protected cmr.fandenatech.ndjangui.service.SanctionTypeLocalService sanctionTypeLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.SanctionTypeService.class)
	protected cmr.fandenatech.ndjangui.service.SanctionTypeService sanctionTypeService;
	@BeanReference(type = SanctionTypePersistence.class)
	protected SanctionTypePersistence sanctionTypePersistence;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.SittingLocalService.class)
	protected cmr.fandenatech.ndjangui.service.SittingLocalService sittingLocalService;
	@BeanReference(type = cmr.fandenatech.ndjangui.service.SittingService.class)
	protected cmr.fandenatech.ndjangui.service.SittingService sittingService;
	@BeanReference(type = SittingPersistence.class)
	protected SittingPersistence sittingPersistence;
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
	private Member_FundServiceClpInvoker _clpInvoker = new Member_FundServiceClpInvoker();
}