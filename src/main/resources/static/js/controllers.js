/**
 * Created by wangtao on 2018/1/12.
 */

actionApp.controller('View1Controller', ['$rootScope', '$scope', '$http',
    function ($rootScope, $scope, $http) {
        $scope.$on('$viewContentLoaded', function () {
            console.log("页面加载完成");
        });
        $scope.search = function () {
            personName = $scope.personName;
            console.log('personName is : ' + personName);
            $http.get('search', {params: {"personName": personName}})
                .success(function (data) {
                    $scope.person = data;
                });
        };
    }]);

actionApp.controller('View2Controller', ['$rootScope', '$scope', function ($rootScope, $scope) {
    $scope.$on('$viewContentLoaded', function () {
        console.log("页面加载完成222");
    });
}]);

