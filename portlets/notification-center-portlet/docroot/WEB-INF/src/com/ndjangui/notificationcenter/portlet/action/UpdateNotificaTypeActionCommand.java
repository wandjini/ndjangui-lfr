
package com.ndjangui.notificationcenter.portlet.action;

import com.xpiping.notificationcenter.model.NotificaType;
import com.xpiping.notificationcenter.service.NotificaTypeServiceUtil;

import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.ActionCommand;
import com.ndjangui.notificationcenter.util.PortletKeys;
import com.ndjangui.notificationcenter.util.WebKeys;

public class UpdateNotificaTypeActionCommand implements ActionCommand {

	private Log _log =
		LogFactoryUtil.getLog(UpdateNotificaTypeActionCommand.class);

	public boolean processCommand(
		PortletRequest portletRequest, PortletResponse portletResponse)
		throws PortletException {

		NotificaType notificaType = null;

		try {

			String cmd = ParamUtil.getString(portletRequest, Constants.CMD);

			long notificaTypeId =
				ParamUtil.getLong(portletRequest, "notificaTypeId");

			String name = ParamUtil.getString(portletRequest, "name");
			String description =
				ParamUtil.getString(portletRequest, "description");
			String messageDestination =
				ParamUtil.getString(portletRequest, "messageDestination");
			String placeHolders =
				ParamUtil.getString(portletRequest, "placeHolders");
			Boolean aviable = ParamUtil.getBoolean(portletRequest, "aviable");

			ServiceContext serviceContext;

			serviceContext =
				ServiceContextFactory.getInstance(
					NotificaType.class.getName(), portletRequest);

			if (cmd.equals(Constants.ADD)) {

				notificaType =
					NotificaTypeServiceUtil.addNotificaType(
						name, description, messageDestination, aviable,
						placeHolders, serviceContext);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				notificaType =
					NotificaTypeServiceUtil.updateNotificaType(
						notificaTypeId, description, messageDestination,
						aviable, placeHolders, serviceContext);
			}

		}
		catch (Exception e) {

			SessionErrors.add(portletRequest, "error-update-notifica-type");

			_log.error(e);

			return false;

		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PortletURL myUrl =
			PortletURLFactoryUtil.create(
				portletRequest, PortletKeys.NOTIFICA_TYPE,
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		myUrl.setWindowState(WindowState.MAXIMIZED);
		myUrl.setPortletMode(PortletMode.VIEW);
		myUrl.setParameter(
			"notificaTypeId", String.valueOf(notificaType.getNotificaTypeId()));
		myUrl.setParameter(
			"mvcPath", "/html/notificatype/edit_notifica_type.jsp");

		portletRequest.setAttribute(WebKeys.REDIRECT, myUrl.toString());

		return true;

	}
}
