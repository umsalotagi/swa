var app = angular.module('myapp', []);

app.controller('myctrl', function($scope) {
    $scope.carname = "Maruti800";
    
    $scope.select=function(BookTitleId)
	{
    	//$scope.b="Welcome to Angular";
    	$http.get("select.jsp?BookTitleId="+$scope.BookTitleId).then(function(response)
				{
	//		var popupWinindow = window.open('', '_blank', 'width=600,height=700,scrollbars=no,menubar=no,toolbar=no,location=no,status=no,titlebar=no');
		//     popupWinindow.document.open();
    		
    		$scope.arr =  response.tostring().toJSON();
			//$scope.empArr=response.json();
			
				});
    	alert($scope.BookId);
	}
    
});