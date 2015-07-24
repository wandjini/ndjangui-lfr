package com.ndjangui.notificationcenter.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

	public class NotificationCenterUtils {
		public static  String formatOrganizationsIds(String orgsIds) 
				throws PortalException, SystemException{
			
				long[] organizationIds = 	StringUtil.split(orgsIds,  StringPool.COMMA , (long)0);
					
				
				Long[] retValue = formatOrganizationsIds(organizationIds);
				
				return StringUtil.merge(retValue);
			}
		
		public static Long[] formatOrganizationsIds(long[] organizationIds) 
				throws PortalException, SystemException{
					
			Organization topOrganization = null;
			String topOrganizationTreePath = StringPool.BLANK;
			
			long parentOrganizationId =  0;
			
			if(parentOrganizationId > 0){
				try{
					topOrganization = OrganizationLocalServiceUtil.getOrganization(parentOrganizationId);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
			if(topOrganization != null){
				topOrganizationTreePath = topOrganization.getTreePath();
			}
				
			ArrayList<Long> topOrganizationIds = new ArrayList<Long>();
			
			
			Arrays.sort(organizationIds);
			
			organizationIds = ArrayUtil.unique(organizationIds);
			
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(organizationIds);
			
			for(Organization organization: organizations){
				
				if(organization.getOrganizationId() == topOrganization.getOrganizationId())
					continue;
				
				// Elimino dal trePath tutte le organizzazioni topLevel
				String treePath = organization.getTreePath();
				treePath = StringUtil.replace(treePath, topOrganizationTreePath , "");
				
				long[] parentOrganizationIds = StringUtil.split(treePath , StringPool.SLASH , (long)0);
				
				boolean exist = false;
				
				for(Long parentOrgId : parentOrganizationIds){
					
					if(topOrganizationIds.contains(parentOrgId)){
						exist = true;
						break;
					}
				}
				
				if(!exist){
					topOrganizationIds.add(organization.getOrganizationId());
				}
			}
			
			
			
			Long[] retValue = new Long[topOrganizationIds.size()]; //
			
			retValue = topOrganizationIds.toArray(retValue); 
			
			Arrays.sort(retValue);
			
			return retValue;
		}
		
		

		public static String[] getOrganizationsIdsNames(String organizationIds)
			throws PortalException, SystemException {

			long[] organizationIdsArray =
				GetterUtil.getLongValues(StringUtil.split(organizationIds));

			String organizationNames = StringPool.BLANK;

			if (organizationIdsArray.length == 0) {
				organizationIds = StringPool.BLANK;
			}
			else {
				StringBundler sb =
					new StringBundler(organizationIdsArray.length * 2);

				for (long organizationId : organizationIdsArray) {
					Organization organization =
						OrganizationLocalServiceUtil.getOrganization(organizationId);

					organization = organization.toEscapedModel();

					sb.append(organization.getName());
					sb.append(WebKeys.ORGANIZATON_SEPARATOR);
				}

				sb.setIndex(sb.index() - 1);

				organizationIds = StringUtil.merge(organizationIdsArray);
				organizationNames = sb.toString();
			}

			return new String[] {
				organizationIds, organizationNames
			};
		}


}
