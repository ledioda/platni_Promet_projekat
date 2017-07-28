(function() {

var app = angular.module('platniPromet');

app.controller('PrikazSvihKlijenataController', PrikazSvihKlijenataController);
PrikazSvihKlijenataController.$inject = [ '$scope', 'KlijentService', '$q' ];
function PrikazSvihKlijenataController($scope, KlijentService, $q) {
$q.all([KlijentService.getClients()]).then(function(data){
$scope.clients = data[0].clients;
});
}
})();
