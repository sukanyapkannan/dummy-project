app.controller('UserCtrl', function($scope,$http,$cookieStore,$rootScope,$location) {
	
	$scope.User={username:"","email":"","address":"","phone":"","password":""};
  
    
    $scope.BASEURL="http://localhost:8080/middleware/user/";
    $scope.register = function()
    {
       
    	$http.post( $scope.BASEURL+"register",$scope.User)
    	.then(function(response)
    			{
    		      alert($scope.User.email+"Registered Successfully");
    			},
    			function(error)
    			{
    			 alert($scope.User.email+"Registered unSuccessfully");
    			})
    	 $location.path("/")
    };
  
    $scope.login = function()
    {
    	console.log($scope.User);
    	$http.post( $scope.BASEURL+"login",$scope.User)
    	.then(function(response)
    			{
    					$rootScope.tempuser=response.data;
    					console.log("user"+ $rootScope.tempuser);
 		 			    alert($scope.User.email+"login Successfully")
 		 			    $rootScope.currentuser=$rootScope.tempuser;
 		 			    $cookieStore.put('user', $rootScope.currentuser);		 			    
 		 			    $location.path("/");
    			},
 			function(error)
 				{
 					alert($scope.User.email+"login unSuccessfully");
 				}
 			)
 	
 };

 $scope.logout=function()
 {
 
	 console.log( $rootScope.currentuser.email)
		$http.get($scope.BASEURL+"logout/"+$rootScope.currentuser.email)
			.then(function(response)
			{
				 $rootScope.currentuser={};
				 $cookieStore.remove('user');
			
				 $location.path("/login")
				
			},function(error)
			{
				
			});
 }
	
});