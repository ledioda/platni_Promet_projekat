(function() {

var app = angular.module('platniPromet');

app.controller('MainController', MainController);
MainController.$inject = [ '$scope' ];
function MainController($scope) {
console.log("CONTROLLER MAIN");
}
})();
