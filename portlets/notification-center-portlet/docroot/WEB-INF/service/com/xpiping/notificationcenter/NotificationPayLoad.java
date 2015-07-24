package com.xpiping.notificationcenter;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;

public final class NotificationPayLoad {

	private static final String _DATE_FORMAT = "yyyyMMddkkmmssSSS";
	
	public NotificationPayLoad(String notificationName,String entityType, long entityId, String articleId,
			long groupId, long[] usersIds, Map<String, Object> messageTokens) {
		super();
		this.notificationName = notificationName;
		this.articleId = articleId;
		this.groupId = groupId;
		this.usersIds = usersIds;
		this.messageTokens = messageTokens;
		this.entityId = entityId;
		this.entityType = entityType;
		this.forceReSend = false;
	}
	
	public NotificationPayLoad(String notificationName,String entityType, long entityId, String articleId,
		long groupId, long[] usersIds, Map<String, Object> messageTokens,Boolean forceReSend ) {
		super();
		this.notificationName = notificationName;
		this.articleId = articleId;
		this.groupId = groupId;
		this.usersIds = usersIds;
		this.messageTokens = messageTokens;
		this.entityId = entityId;
		this.entityType = entityType;
		this.forceReSend = forceReSend;
	}
	
	public NotificationPayLoad(String serializedJson) 
			throws JSONException {
		super();
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(serializedJson);
		
		loadJSONObject(jsonObject);
	}

	public String getNotificationName() {
		return notificationName;
	}
	public String getEntityType() {
		return entityType;
	}
	public long getEntityId() {
		return entityId;
	}

	public String getArticleId() {
		return articleId;
	}

	public long getGroupId() {
		return groupId;
	}

	public long[] getUsersIds() {
		return usersIds;
	}

	public Map<String, Object> getMessageTokens() {
		return messageTokens;
	}
	
	public boolean isForceReSend() {

		return forceReSend;
	}

	public void setForceReSend(boolean forceReSend) {

		this.forceReSend = forceReSend;
	}

	private String notificationName;
	private String entityType;
	private long entityId;
	private String articleId;
	private long groupId;
	private long[] usersIds;
	private Map<String,Object> messageTokens;
	private boolean forceReSend;
	
	public JSONObject toJSON(){

		 JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		 
		 jsonObject.put("entityType", getEntityType());
		 jsonObject.put("entityId", getEntityId());
		 jsonObject.put("articleId", getArticleId());
		 jsonObject.put("forceReSend", isForceReSend());
		 jsonObject.put("groupId", getGroupId());
		 jsonObject.put("notificationName", getNotificationName());
		 
		 JSONArray usersIdsArr = JSONFactoryUtil.createJSONArray();
		 
		 for(long userId:getUsersIds()){
			 
			 usersIdsArr.put(userId);
		 }
		 
		 jsonObject.put("userIds", usersIdsArr);
		 
		 
		 JSONObject tokens = JSONFactoryUtil.createJSONObject();
		 
		 for(Map.Entry<String, Object> token:getMessageTokens().entrySet()){
			 
			 if( token.getValue() instanceof Date)
				 tokens.put(token.getKey() + "-date", _getDateFormat().format((Date)token.getValue()));
			 else
				 tokens.put(token.getKey(), token.getValue().toString());
			 
		 }
		 
		 jsonObject.put("messageTokens", tokens);
		 
		 return jsonObject;
	}
	
	public void loadJSONObject (JSONObject jsonObject){
		
		entityType =  jsonObject.getString("entityType");
		entityId = jsonObject.getLong("entityId");
		articleId = jsonObject.getString("articleId");
		groupId = jsonObject.getLong("groupId");
		notificationName = jsonObject.getString("notificationName");
		forceReSend = jsonObject.getBoolean("forceReSend");
		
		JSONArray usersIdsArr = jsonObject.getJSONArray("userIds");
		
		usersIds = new long[usersIdsArr.length()];
		
		for(int i = 0; i < usersIdsArr.length(); i++){
			usersIds[i] = usersIdsArr.getLong(i);
		}
		
		HashMap<String, Object> tokensMap = new HashMap<String, Object>();
		
		JSONObject tokens = jsonObject.getJSONObject("messageTokens");
		
		Iterator<String> itr =  tokens.keys();
		
		 while(itr.hasNext()) {
			 
	         String key = itr.next();
	         
	         
	         if(StringUtil.endsWith(key, "-date")){
	        	 
	        	Date timestamp = GetterUtil.getDate(tokens.getString(key), _getDateFormat());
	        	 
	        	String newKey = StringUtil.replace(key, "-date", "") ; 
	        	
	        	tokensMap.put(newKey, timestamp);
	         }
	         else{
	        	 tokensMap.put(key, tokens.getString(key));
	         }
	         
	      }
		 
		 messageTokens = tokensMap;
	}
	
	
	@Override
	public String toString() {
		JSONObject jsonObject = toJSON();
		
		return jsonObject.toString();
	}
	
	private DateFormat _getDateFormat() {
		return DateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT);
	}

	
	
}
