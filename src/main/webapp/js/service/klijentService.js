(function(){
'use strict';
angular.module("platniPromet").factory("KlijentService", KlijentService);
KlijentService.$inject = [ '$http', '$stateParams', '$q' ];
function KlijentService($http, $stateParams, $q) {

return {
createClient : function(client) {
return $http({
method : "POST",
url : "api/v1/client",
params : {
name : client.name,
surname : client.surname,
email : client.email,
password : client.password,
bankName : client.bankName,
street : client.street,
city : client.city,
country : client.country
}
}).then(function(response) {
return {
client : response.data,
};
}, function(response) {
return $q.reject(response);
});
},
getClients :  function() {
return $http({
method : "GET",
url : "api/v1/client/admin"
}).then(function(response) {
return {
clients : response.data,
};
}, function(response) {
return $q.reject(response);
});
}
};

}

})();
