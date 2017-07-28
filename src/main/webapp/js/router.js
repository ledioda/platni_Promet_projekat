(function() {
"use strict";
angular.module('platniPromet').config(config);

config.$inject = [ '$stateProvider', '$urlRouterProvider', '$httpProvider' ];
function config($stateProvider, $urlRouterProvider, $httpProvider) {

$urlRouterProvider.otherwise('/main');

$stateProvider
.state('main', {
url : '/main',
templateUrl : 'template/main.html',
controller : 'MainController'
}).state('login', {
url : '/login',
templateUrl : 'template/login.html',
controller : 'MainController'
})
.state('kreirajKlijenta', {
url : '/kreirajKlijenta',
templateUrl : 'template/kreirajKlijenta.html',
controller : 'KreirajKlijentaController'
})
.state('kreirajBanku', {
url : '/kreirajBanku',
templateUrl : 'template/kreirajBanku.html',
controller : 'KreirajBankuController'
})
.state('prikazSvihKlijenata', {
url : '/prikazSvihKlijenata',
templateUrl : 'template/prikazSvihKlijenata.html',
controller : 'PrikazSvihKlijenataController'
})
.state('prikazSvihBanaka', {
url : '/prikazSvihBanaka',
templateUrl : 'template/prikazSvihBanaka.html',
controller : 'PrikazSvihBanakaController'
})
.state('transakcija', {
url : '/transakcija',
templateUrl : 'template/uplatnica.html',
controller : 'TransakcijaController'
})
.state('prikazSvihTransakcija', {
url : '/prikazSvihTransakcija',
templateUrl : 'template/prikazSvihTransakcija.html',
controller : 'PrikazSvihTransakcijaController'
});

$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}
})();

