
(function() {

var app = angular.module('platniPromet');

app.controller('PrikazSvihTransakcijaController', PrikazSvihTransakcijaController);
PrikazSvihTransakcijaController.$inject = [ '$scope', 'TransakcijaService', '$q' ];
function PrikazSvihTransakcijaController($scope, TransakcijaService, $q) {
$q.all([TransakcijaService.getTransactions()]).then(function(data){
$scope.transactions = data[0].transactions;
});
}
})();
