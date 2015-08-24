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

import cmr.fandenatech.ndjangui.model.AddressClp;
import cmr.fandenatech.ndjangui.model.BudgetPeriodClp;
import cmr.fandenatech.ndjangui.model.FundClp;
import cmr.fandenatech.ndjangui.model.FundTypeClp;
import cmr.fandenatech.ndjangui.model.MemberClp;
import cmr.fandenatech.ndjangui.model.MemberFundClp;
import cmr.fandenatech.ndjangui.model.MemberSittingClp;
import cmr.fandenatech.ndjangui.model.OperationClp;
import cmr.fandenatech.ndjangui.model.OperationTypeClp;
import cmr.fandenatech.ndjangui.model.Operation_FundClp;
import cmr.fandenatech.ndjangui.model.SanctionClp;
import cmr.fandenatech.ndjangui.model.SanctionTypeClp;
import cmr.fandenatech.ndjangui.model.SittingClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guyw
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"ndjangui-core-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"ndjangui-core-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "ndjangui-core-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AddressClp.class.getName())) {
			return translateInputAddress(oldModel);
		}

		if (oldModelClassName.equals(BudgetPeriodClp.class.getName())) {
			return translateInputBudgetPeriod(oldModel);
		}

		if (oldModelClassName.equals(FundClp.class.getName())) {
			return translateInputFund(oldModel);
		}

		if (oldModelClassName.equals(FundTypeClp.class.getName())) {
			return translateInputFundType(oldModel);
		}

		if (oldModelClassName.equals(MemberClp.class.getName())) {
			return translateInputMember(oldModel);
		}

		if (oldModelClassName.equals(MemberFundClp.class.getName())) {
			return translateInputMemberFund(oldModel);
		}

		if (oldModelClassName.equals(MemberSittingClp.class.getName())) {
			return translateInputMemberSitting(oldModel);
		}

		if (oldModelClassName.equals(OperationClp.class.getName())) {
			return translateInputOperation(oldModel);
		}

		if (oldModelClassName.equals(Operation_FundClp.class.getName())) {
			return translateInputOperation_Fund(oldModel);
		}

		if (oldModelClassName.equals(OperationTypeClp.class.getName())) {
			return translateInputOperationType(oldModel);
		}

		if (oldModelClassName.equals(SanctionClp.class.getName())) {
			return translateInputSanction(oldModel);
		}

		if (oldModelClassName.equals(SanctionTypeClp.class.getName())) {
			return translateInputSanctionType(oldModel);
		}

		if (oldModelClassName.equals(SittingClp.class.getName())) {
			return translateInputSitting(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAddress(BaseModel<?> oldModel) {
		AddressClp oldClpModel = (AddressClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAddressRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBudgetPeriod(BaseModel<?> oldModel) {
		BudgetPeriodClp oldClpModel = (BudgetPeriodClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBudgetPeriodRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFund(BaseModel<?> oldModel) {
		FundClp oldClpModel = (FundClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFundRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFundType(BaseModel<?> oldModel) {
		FundTypeClp oldClpModel = (FundTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFundTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMember(BaseModel<?> oldModel) {
		MemberClp oldClpModel = (MemberClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMemberRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMemberFund(BaseModel<?> oldModel) {
		MemberFundClp oldClpModel = (MemberFundClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMemberFundRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMemberSitting(BaseModel<?> oldModel) {
		MemberSittingClp oldClpModel = (MemberSittingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMemberSittingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOperation(BaseModel<?> oldModel) {
		OperationClp oldClpModel = (OperationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOperationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOperation_Fund(BaseModel<?> oldModel) {
		Operation_FundClp oldClpModel = (Operation_FundClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOperation_FundRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOperationType(BaseModel<?> oldModel) {
		OperationTypeClp oldClpModel = (OperationTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOperationTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSanction(BaseModel<?> oldModel) {
		SanctionClp oldClpModel = (SanctionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSanctionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSanctionType(BaseModel<?> oldModel) {
		SanctionTypeClp oldClpModel = (SanctionTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSanctionTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSitting(BaseModel<?> oldModel) {
		SittingClp oldClpModel = (SittingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSittingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.AddressImpl")) {
			return translateOutputAddress(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.BudgetPeriodImpl")) {
			return translateOutputBudgetPeriod(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.FundImpl")) {
			return translateOutputFund(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.FundTypeImpl")) {
			return translateOutputFundType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.MemberImpl")) {
			return translateOutputMember(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.MemberFundImpl")) {
			return translateOutputMemberFund(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.MemberSittingImpl")) {
			return translateOutputMemberSitting(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.OperationImpl")) {
			return translateOutputOperation(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.Operation_FundImpl")) {
			return translateOutputOperation_Fund(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.OperationTypeImpl")) {
			return translateOutputOperationType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.SanctionImpl")) {
			return translateOutputSanction(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.SanctionTypeImpl")) {
			return translateOutputSanctionType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"cmr.fandenatech.ndjangui.model.impl.SittingImpl")) {
			return translateOutputSitting(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"cmr.fandenatech.ndjangui.DuplicateCardNumberExceptionException")) {
			return new cmr.fandenatech.ndjangui.DuplicateCardNumberExceptionException();
		}

		if (className.equals("cmr.fandenatech.ndjangui.NoSuchAddressException")) {
			return new cmr.fandenatech.ndjangui.NoSuchAddressException();
		}

		if (className.equals(
					"cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException")) {
			return new cmr.fandenatech.ndjangui.NoSuchBudgetPeriodException();
		}

		if (className.equals("cmr.fandenatech.ndjangui.NoSuchFundException")) {
			return new cmr.fandenatech.ndjangui.NoSuchFundException();
		}

		if (className.equals("cmr.fandenatech.ndjangui.NoSuchFundTypeException")) {
			return new cmr.fandenatech.ndjangui.NoSuchFundTypeException();
		}

		if (className.equals("cmr.fandenatech.ndjangui.NoSuchMemberException")) {
			return new cmr.fandenatech.ndjangui.NoSuchMemberException();
		}

		if (className.equals(
					"cmr.fandenatech.ndjangui.NoSuchMemberFundException")) {
			return new cmr.fandenatech.ndjangui.NoSuchMemberFundException();
		}

		if (className.equals(
					"cmr.fandenatech.ndjangui.NoSuchMemberSittingException")) {
			return new cmr.fandenatech.ndjangui.NoSuchMemberSittingException();
		}

		if (className.equals(
					"cmr.fandenatech.ndjangui.NoSuchOperationException")) {
			return new cmr.fandenatech.ndjangui.NoSuchOperationException();
		}

		if (className.equals(
					"cmr.fandenatech.ndjangui.NoSuchOperation_FundException")) {
			return new cmr.fandenatech.ndjangui.NoSuchOperation_FundException();
		}

		if (className.equals(
					"cmr.fandenatech.ndjangui.NoSuchOperationTypeException")) {
			return new cmr.fandenatech.ndjangui.NoSuchOperationTypeException();
		}

		if (className.equals("cmr.fandenatech.ndjangui.NoSuchSanctionException")) {
			return new cmr.fandenatech.ndjangui.NoSuchSanctionException();
		}

		if (className.equals(
					"cmr.fandenatech.ndjangui.NoSuchSanctionTypeException")) {
			return new cmr.fandenatech.ndjangui.NoSuchSanctionTypeException();
		}

		if (className.equals("cmr.fandenatech.ndjangui.NoSuchSittingException")) {
			return new cmr.fandenatech.ndjangui.NoSuchSittingException();
		}

		return throwable;
	}

	public static Object translateOutputAddress(BaseModel<?> oldModel) {
		AddressClp newModel = new AddressClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAddressRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBudgetPeriod(BaseModel<?> oldModel) {
		BudgetPeriodClp newModel = new BudgetPeriodClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBudgetPeriodRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFund(BaseModel<?> oldModel) {
		FundClp newModel = new FundClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFundRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFundType(BaseModel<?> oldModel) {
		FundTypeClp newModel = new FundTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFundTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMember(BaseModel<?> oldModel) {
		MemberClp newModel = new MemberClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMemberRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMemberFund(BaseModel<?> oldModel) {
		MemberFundClp newModel = new MemberFundClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMemberFundRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMemberSitting(BaseModel<?> oldModel) {
		MemberSittingClp newModel = new MemberSittingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMemberSittingRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOperation(BaseModel<?> oldModel) {
		OperationClp newModel = new OperationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOperationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOperation_Fund(BaseModel<?> oldModel) {
		Operation_FundClp newModel = new Operation_FundClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOperation_FundRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOperationType(BaseModel<?> oldModel) {
		OperationTypeClp newModel = new OperationTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOperationTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSanction(BaseModel<?> oldModel) {
		SanctionClp newModel = new SanctionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSanctionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSanctionType(BaseModel<?> oldModel) {
		SanctionTypeClp newModel = new SanctionTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSanctionTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSitting(BaseModel<?> oldModel) {
		SittingClp newModel = new SittingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSittingRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}