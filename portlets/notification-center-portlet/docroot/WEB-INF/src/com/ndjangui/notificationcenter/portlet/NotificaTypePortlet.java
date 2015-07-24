package com.ndjangui.notificationcenter.portlet;

import com.xpiping.notificationcenter.model.Notifica;
import com.xpiping.notificationcenter.model.NotificaType;
import com.xpiping.notificationcenter.service.NotificaServiceUtil;
import com.xpiping.notificationcenter.service.NotificaTypeServiceUtil;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.ndjangui.notificationcenter.util.WebKeys;

/**
 * Portlet implementation class NotificaTypePortlet
 */
public class NotificaTypePortlet extends MVCPortlet {
 

	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException, IOException {

		try {
			
			long notificaTypeId = ParamUtil.getLong(renderRequest, "notificaTypeId");
			
			NotificaType notificaType = null;

			if (notificaTypeId > 0) {
				notificaType = NotificaTypeServiceUtil.getNotificaType(notificaTypeId);
			}

			renderRequest.setAttribute(WebKeys.NOTIFICA_TYPE, notificaType);

		}
		catch (Exception e) {
			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);
	}
	

}
