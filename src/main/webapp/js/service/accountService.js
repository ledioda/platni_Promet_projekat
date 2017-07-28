(function(){
'use strict';
angular.module("platniPromet").factory("AccountService", AccountService);
AccountService.$inject = [ '$http', '$stateParams', '$q' ];
function AccountService($http, $stateParams, $q) {

return {
getAccounts :  function() {
return $http({
method : "GET",
url : "api/v1/account"
}).then(function(response) {
return {
accounts : response.data,
};
}, function(response) {
return $q.reject(response);
});
}
};

}

})();

