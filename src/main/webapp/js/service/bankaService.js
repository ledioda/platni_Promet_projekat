(function(){
'use strict';
angular.module("platniPromet").factory("BankaService", BankaService);
BankaService.$inject = [ '$http', '$stateParams', '$q' ];
function BankaService($http, $stateParams, $q) {

return {
createBank : function(bank) {
return $http({
method : "POST",
url : "api/v1/bank",
params : {
name : bank.name,
pib : bank.pib,
street : bank.street,
city : bank.city,
country : bank.country
}
}).then(function(response) {
return {
client : response.data,
};
}, function(response) {
return $q.reject(response);
});
},
getBanks :  function() {
return $http({
method : "GET",
url : "api/v1/bank"
}).then(function(response) {
return {
banks : response.data,
};
}, function(response) {
return $q.reject(response);
});
}
};

}

})();


