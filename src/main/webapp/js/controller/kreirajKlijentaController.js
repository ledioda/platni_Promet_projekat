(function() {

var app = angular.module('platniPromet');

app.controller('KreirajKlijentaController', KreirajKlijentaController);
KreirajKlijentaController.$inject = [ '$scope', 'KlijentService', '$state', '$q', 'BankaService' ];
function KreirajKlijentaController($scope, KlijentService, $state, $q, BankaService) {

$scope.client = {};
$q.all([BankaService.getBanks()]).then(function(data){
$scope.banks = data[0].banks;
$scope.saveClient = function(){
KlijentService.createClient($scope.client).then(function(result){
$state.go('prikazSvihKlijenata');
});
};
});
}
})();
