const app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix("");
  $routeProvider
    .when("/trang-chu", {
      templateUrl: "pages/home.html",
      controller: homeController,
    })
    .when("/product/new", {
      templateUrl: "pages/home.html",
      controller: newProductController,
    })
    .when("/product/delete/:id", {
      templateUrl: "pages/home.html",
      controller: deleteController,
    })
    .when("/product/update/:id", {
      templateUrl: "pages/home.html",
      controller: UpdateController,
    })
    .when("/product/detail/:id", {
      templateUrl: "pages/home.html",
      controller: detailController,
    })
    .when("/product/seach/:seach", {
      templateUrl: "pages/home.html",
      controller: SeachController,
    })
    .otherwise({
      redirectTo: "/trang-chu",
    });
});
