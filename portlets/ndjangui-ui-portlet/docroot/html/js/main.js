var SittingService = function($http, $q,ENDPOINT_URI){
	var SERVICE_URI = '/api/jsonws/ndjangui-services-portlet.sittingmanagement';
	var getFundMembers = function(sittingId,fundId){
		var deferred = $q.defer();
		
		var url = SERVICE_URI +'/get-fund-members/group-id/'+themeDisplay.getScopeGroupId()+
				 '/sitting-id/'+sittingId+'/fund-id/'+fundId+'?p_auth=' + Liferay.authToken;
		$http.get(url).success(deferred.resolve).error(deferred.reject);
		  
        return deferred.promise;


				
		
	};
	var addMemberContribution = function(budgetPeriodId, memberId,
											sittingId, fundId, amount){
		var deferred = $q.defer();
		var url = SERVICE_URI +'/add-member-contribution/group-id/'+themeDisplay.getScopeGroupId()+'/user-id/'+themeDisplay.getUserId()+
				 '/sitting-id/'+sittingId+'/fund-id/'+fundId+'/member-id/'+memberId+'/budget-period-id/'+budgetPeriodId+
				 '/amount/'+amount+'?p_auth=' + Liferay.authToken;
		$http.get(url).success(deferred.resolve).error(deferred.reject);
		  
        return deferred.promise;


				
		
	};

	var getAllMembers = function(sittingId){
		var deferred = $q.defer();
		var url = SERVICE_URI +'/get-member-sanctions/group-id/'+themeDisplay.getScopeGroupId()+
		          '/sitting-id/'+sittingId+'?p_auth=' + Liferay.authToken;
		$http.get(url).success(deferred.resolve).error(deferred.reject);
		
		return deferred.promise;
	};
	
	return{
		getFundMembers:getFundMembers,
		addMemberContribution:addMemberContribution,
		getAllMembers:getAllMembers
	};
}

 function initializeApp(app){
	 app.constant('ENDPOINT_URI','/api/jsonws/ndjangui-services-portlet.sittingmanagement');
	 app.factory('SittingService',['$http','$q','ENDPOINT_URI',SittingService]);
	 
 }