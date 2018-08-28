app.controller('blogCtrl', function($scope,$http,$rootScope,$location,$cookieStore) 
		{
	$scope.Blog={blogName:"","blogContent":""};
	$scope.BASEURL="http://localhost:8080/middleware/blog/";
		 $scope.addBlog= function() {
			  console.log("In Add Blog",$scope.Blog)
		       
		    	   $http.post( $scope.BASEURL+"addBlog",$scope.Blog)
		       	.then(function(response)
		       			{
		       		      alert($scope.Blog.blogName+"blog added Successfully");
		       			},
		       			function(error)
		       			{
		       			 alert($scope.Blog.blogName+"blog added Successfully");
		       			}
		       			)
	  $location.path("/")
		       };
});