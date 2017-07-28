(function() {

var app = angular.module('platniPromet');

app.controller('KreirajBankuController', KreirajBankuController);
KreirajBankuController.$inject = [ '$scope', 'BankaService', '$state' ];
function KreirajBankuController($scope, BankaService, $state) {
$scope.bank = {};
$scope.saveBank = function(){
BankaService.createBank($scope.bank).then(function(result){
$state.go('prikazSvihBanaka');
});
};
}
})();
