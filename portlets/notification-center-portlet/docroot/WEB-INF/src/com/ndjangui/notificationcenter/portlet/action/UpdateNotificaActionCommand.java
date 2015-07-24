
package com.ndjangui.notificationcenter.portlet.action;

import com.xpiping.notificationcenter.model.Notifica;
import com.xpiping.notificationcenter.service.NotificaServiceUtil;

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

public class UpdateNotificaActionCommand implements ActionCommand {

	private Log _log = LogFactoryUtil.getLog(UpdateNotificaActionCommand.class);

	public boolean processCommand(
		PortletRequest portletRequest, PortletResponse portletResponse)
		throws PortletException {

		Notifica notifica = null;
		String cmd = ParamUtil.getString(portletRequest, Constants.CMD);

		try {

			

			long notificaId = ParamUtil.getLong(portletRequest, "notificaId");
			long notificaTypeId = ParamUtil.getLong(portletRequest, "notificaTypeId");
			String name = ParamUtil.getString(portletRequest, "name");
			String subject = ParamUtil.getString(portletRequest, "subject");
			String text = ParamUtil.getString(portletRequest, "text");
			String description = ParamUtil.getString(portletRequest, "description");
			
			Boolean aviable = ParamUtil.getBoolean(portletRequest, "aviable");
			Boolean ignoreIntersaction = ParamUtil.getBoolean(portletRequest, "ignoreIntersaction");
			String groupsIds = ParamUtil.getString(portletRequest, "userGroupsSearchContainerPrimaryKeys");
			String rolesIds = ParamUtil.getString(portletRequest, "rolesSearchContainerPrimaryKeys");
			String orgsIds = ParamUtil.getString(portletRequest, "organizationsIds"); 
			
			ServiceContext serviceContext;

			serviceContext =
				ServiceContextFactory.getInstance(
					Notifica.class.getName(), portletRequest);
			
			if (cmd.equals(Constants.ADD)) {
				
				notifica =
					NotificaServiceUtil.addNotifica(
						notificaTypeId, name, text, subject, description,
						aviable,ignoreIntersaction, orgsIds, groupsIds, rolesIds, serviceContext);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				notifica =
					NotificaServiceUtil.updateNotifica(
						notificaId, text, subject, description, aviable,ignoreIntersaction,
						orgsIds, groupsIds, rolesIds, serviceContext);
			}
			else if (cmd.equals(Constants.DELETE)) {
				notifica =
					NotificaServiceUtil.deleteNotifica(notificaId);
			}
			else if(cmd.equals("SEND_INSTANT_NOTIFICA")){
				
				notifica = NotificaServiceUtil.getNotifica(notificaId);
				
				NotificaServiceUtil.sendNotificaInstantanea(serviceContext.getScopeGroupId(),notificaId, true);
				
			}

		}
		catch (Exception e) {

			SessionErrors.add(portletRequest, "error-update-notifica");

			_log.error(e);

			return false;

		}

		if (!cmd.equals(Constants.DELETE)){
			ThemeDisplay themeDisplay =
				(ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	
			PortletURL myUrl =
				PortletURLFactoryUtil.create(
					portletRequest, PortletKeys.NOTIFICATION_CENTER,
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	
			myUrl.setWindowState(WindowState.MAXIMIZED);
			myUrl.setPortletMode(PortletMode.VIEW);
			myUrl.setParameter(
				"notificaId", String.valueOf(notifica.getNotificaId()));
			myUrl.setParameter(
				"mvcPath", "/html/notificationcenter/edit_notifica.jsp");
	
			portletRequest.setAttribute(WebKeys.REDIRECT, myUrl.toString());
		}
		return true;

	}

}
