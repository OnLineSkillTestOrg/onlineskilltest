
    var myapplication=angular.module("myapp", [
        'ngSanitize',
        'ngAnimate',
        'ngQuantum'
        ]);
    myapplication.controller("HelloController", function($scope) {
    $scope.helloTo = {};
    $scope.helloTo.title = "World, AngularJS";
	$scope.helloTo.showIt=true;
	$scope.myData = {};
	$scope.myData.whichNewsletter="Note Selected"
	$scope.myData.switch=3;
	$scope.myData.showIt=true;
	 $scope.myData.doClick = function(event) {
                    alert("clicked: " + event.clientX + ", " + event.clientY);
                }
	$scope.myData.items=[ {text : "one"}, {text : "two"}, {text : "three"} ];
	$scope.itemFilter = function(item) {
        if(item.text == "two") return false;
          return true;
        }
      
    });
