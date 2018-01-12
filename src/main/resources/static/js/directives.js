/**
 * Created by wangtao on 2018/1/12.
 */

actionApp.directive('datePicker',function () {
    return {
        restrict :'AC',
        link:function (scope,elem,attrs) {
            elem.datepicker();
        }
    };
});
