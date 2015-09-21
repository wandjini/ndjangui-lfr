var app = angular.module('myApp',  ['ui.bootstrap','ngSanitize'] );
initializeApp(app);

app.controller('SittingController', 
		['$scope',  'SittingService',
	function ($scope,  SittingService) {
			
	$scope.members={};
	$scope.messages=null;
	$scope.errors=null;
	$scope.allMembers={};
	$scope.operations=[];
	
	$scope.$watch('currentFundId', function(newValue, oldValue) {
		
		if(parseInt(newValue))
			$scope.getMembersByFund($scope.currentSittingId,newValue);	
	  	
  	});
	
	$scope.getMembersByFund = function(sittingId, fundId){
		SittingService.getFundMembers(sittingId,fundId ).then(function (result) {
            
			$scope.members = (result !== 'null') ? result.data : {};
        }, function (reason) {
            console.log('ERROR', reason);
        });
		
		
	};
	$scope.addMemberContribution = function(member){
		
		SittingService.addMemberContribution($scope.budgetPeriodId,member.memberId,
					$scope.currentSittingId, $scope.currentFundId, member.amount).then(function (result) {
            
			   var operation = (result !== 'null') ? result.data : {};
			   $scope.operations.push(operation);
			}, function (reason) {
            console.log('ERROR', reason);
        });
		
		
	};
	$scope.saveOperations = function(){
		_.each($scope.members, function(member){
			if(!member.amount || (member.amount&& !angular.isNumber(member.amount)) ){
				$scope.errors=Liferay.Language.get('amount-is-mandatory');
				return;
			}
		});
		if($scope.errors){
			return;
		}
		_.each($scope.members, function(member){
			$scope.addMemberContribution(member);
		});
		$scope.messages=Liferay.Language.get('conributions-successfully-saved');
		
	};
	$scope.init = function(){
		$scope.currentSittingId = window.initData.currentSittingId;
		$scope.budgetPeriodId = window.initData.budgetPeriodId;
		$scope.currentFundId = window.initData.fundId;
		$scope.getMembersByFund($scope.currentSittingId,$scope.currentFundId);

	}
	$scope.getAllMembers = function(){
		SittingService.getAllMembers(window.initData.currentSittingId).then(function (result) {
            
			$scope.allMembers = (result !== 'null') ? result.data : {};
        }, function (reason) {
            console.log('ERROR', reason);
        });
		
		
	};
	$scope.getAllMembers();

}]);

app.directive('ngConfirmClick', [
                 		        function(){
                 		            return {
                 		                link: function (scope, element, attr) {
                 		                    var msg = attr.ngConfirmClick || "Are you sure?";
                 		                    var clickAction = attr.confirmedClick;
                 		                    element.bind('click',function (event) {
                 		                        if ( window.confirm(msg) ) {
                 		                            scope.$eval(clickAction)
                 		                        }else{
                 		                        	event.stopImmediatePropagation();
                 		                        	event.preventDefault();
                 		                        }
                 		                    });
                 		                 
                 		                }
                 		            };
                 		    }]);	 
                  
angular.element(document).ready(function() {
	 angular.bootstrap(document, ['myApp']);
  })