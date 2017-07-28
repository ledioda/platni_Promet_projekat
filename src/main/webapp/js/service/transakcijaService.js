(function(){
'use strict';
angular.module("platniPromet").factory("TransakcijaService", TransakcijaService);
TransakcijaService.$inject = [ '$http', '$stateParams', '$q' ];
function TransakcijaService($http, $stateParams, $q) {

return {
createTransaction : function(transaction) {
return $http({
method : "POST",
url : "api/v1/transaction",
params : {
amount : transaction.amount,
purpose : transaction.purpose,
accountRecipient : transaction.accountRecepient,
accountSender : transaction.accountSender
}
}).then(function(response) {
return {
transaction : response.data,
};
}, function(response) {
return $q.reject(response);
});
},
getTransactions :  function() {
return $http({
method : "GET",
url : "api/v1/transaction"
}).then(function(response) {
return {
transactions : response.data,
};
}, function(response) {
return $q.reject(response);
});
}
};

}

})();

