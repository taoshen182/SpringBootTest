/**
 * Created by wangtao on 2018/1/12.
 */

var actionApp = angular.module('actionApp', ['ngRoute']);


actionApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/oper',
            {
                controller: 'View1Controller',
                templateUrl: 'view1',
            }
        )
        .when('/directive',
            {
                controller: 'View2Controller',
                templateUrl: 'view2',
            }
        )
}])
