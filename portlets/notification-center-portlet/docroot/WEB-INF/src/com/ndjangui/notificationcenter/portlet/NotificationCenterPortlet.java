package com.ndjangui.notificationcenter.portlet;


import com.xpiping.notificationcenter.model.Notifica;
import com.xpiping.notificationcenter.service.NotificaServiceUtil;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.ndjangui.notificationcenter.util.WebKeys;

/**
 * Portlet implementation class NotificationCenterPortlet
 */
public class NotificationCenterPortlet extends MVCPortlet {
	
	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException, IOException {

		try {
			
			long notificaId = ParamUtil.getLong(renderRequest, "notificaId");
			
			Notifica notifica = null;

			if (notificaId > 0) {
				notifica = NotificaServiceUtil.getNotifica(notificaId);
			}

			renderRequest.setAttribute(WebKeys.NOTIFICA, notifica);

		}
		catch (Exception e) {
			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);
	}
	
	

}
