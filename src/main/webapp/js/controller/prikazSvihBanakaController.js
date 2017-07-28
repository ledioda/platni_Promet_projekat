(function() {

var app = angular.module('platniPromet');

app.controller('PrikazSvihBanakaController', PrikazSvihBanakaController);
PrikazSvihBanakaController.$inject = [ '$scope', 'BankaService', '$q' ];
function PrikazSvihBanakaController($scope, BankaService, $q) {
$q.all([BankaService.getBanks()]).then(function(data){
$scope.banks = data[0].banks;
});
}
})();
