(function() {

var app = angular.module('platniPromet');

app.controller('TransakcijaController', TransakcijaController);
TransakcijaController.$inject = [ '$scope', 'AccountService', '$q', 'TransakcijaService', '$state' ];
function TransakcijaController($scope, AccountService, $q, TransakcijaService, $state) {
$scope.transaction = {};
$q.all([AccountService.getAccounts()]).then(function(data){
$scope.accounts = data[0].accounts;
$scope.doTransaction = function(){
$scope.transaction.accountRecepient = $scope.transaction.accountRecepient.accountNumber;
$scope.transaction.accountSender = $scope.transaction.accountSender.accountNumber;
TransakcijaService.createTransaction($scope.transaction).then(function(result){
$state.go("prikazSvihTransakcija");
});
};
});
}
})();
