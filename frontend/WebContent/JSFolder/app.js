var app = angular.module('myApp', ['ngRoute','ngCookies']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "views/home.html"
    })
    .when("/signup", {
        templateUrl : "User/registration.html"
    })
    .when("/login", {
        templateUrl : "User/Login.html"
    })
    .when("/blog", {
        templateUrl : "views/Blog.html"
    })
});

app.run( function ($rootScope, $location, $cookieStore, $http) 
		{
	
				// to keep the user logged in after page refresh
				    $rootScope.currentuser = $cookieStore.get('user') || {};
				    if ($rootScope.currentuser)
				    {
				        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentuser; 
				    }
		});

