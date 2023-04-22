window.homeController = function ($scope, $rootScope, $location, $http) {
  $rootScope.product = {
    id: 0,
    productName: undefined,
    color: undefined,
    quantity: undefined,
    sellPrice: undefined,
    originPrice: undefined,
    desciption: undefined,
    subCategoryId: 0,
    statusId: 0,
    brandId: 0,
  };
  $rootScope.seach = "";
  $rootScope.listProduct = [];
  $rootScope.listcate = [];
  $rootScope.listbrands = [];
  $rootScope.liststatus = [];
  $http.get("http://localhost:8080/api/subcate").then(function (repon) {
    $rootScope.listcate = repon.data;
    console.log(repon.data);
  });
  $http.get("http://localhost:8080/api/status").then(function (repon) {
    $rootScope.liststatus = repon.data;
    console.log(repon.data);
  });
  $http.get("http://localhost:8080/api/brand").then(function (repon) {
    $rootScope.listbrands = repon.data;
    console.log(repon.data);
  });
  $http.get("http://localhost:8080/api/product").then(function (repon) {
    $rootScope.listProduct = repon.data;
    console.log(repon);
  });
};
window.newProductController = function ($rootScope, $location, $http) {
  if (
    $rootScope.product.productName === undefined ||
    $rootScope.product.color === undefined ||
    $rootScope.product.quantity === undefined ||
    $rootScope.product.sellPrice === undefined ||
    $rootScope.product.originPrice === undefined ||
    isNaN($rootScope.product.quantity) ||
    isNaN($rootScope.product.sellPrice) ||
    isNaN($rootScope.product.originPrice) ||
    $rootScope.product.quantity <= 0 ||
    $rootScope.product.sellPrice <= 0 ||
    $rootScope.product.originPrice < 0
  ) {
    alert("Them khong thanh cong!");
    $location.path("/trang-chu");
    return;
  } else {
    $http.post("http://localhost:8080/api/product", $rootScope.product).then(
      function (response) {
        alert("Them Thanh Cong!");
        $location.path("/trang-chu");
      },
      function (error) {
        alert(error.data.message);
      }
    );
  }
};
window.deleteController = function (
  $scope,
  $rootScope,
  $location,
  $http,
  $routeParams
) {
  $http.delete("http://localhost:8080/api/product/" + $routeParams.id).then(
    function (response) {
      alert("Xóa Thành Công!");
      $location.path("/trang-chu");
    },
    function (e) {
      alert("Xóa Không Thành Công!");
      console.log(e.message);
    }
  );
};
window.detailController = function (
  $scope,
  $rootScope,
  $location,
  $http,
  $routeParams
) {
  $http
    .get("http://localhost:8080/api/product/" + $routeParams.id)
    .then(function (repon) {
      $rootScope.product = repon.data;
      console.log($rootScope.product);
    });
};
window.UpdateController = function (
  $scope,
  $rootScope,
  $location,
  $http,
  $routeParams
) {
  if ($rootScope.product.id === 0) {
    alert("Vui lòng chọn để Sửa");
    $location.path("/trang-chu");
    return;
  } else if (
    $rootScope.product.productName === undefined ||
    $rootScope.product.color === undefined ||
    $rootScope.product.quantity === undefined ||
    $rootScope.product.sellPrice === undefined ||
    $rootScope.product.originPrice === undefined ||
    isNaN($rootScope.product.quantity) ||
    isNaN($rootScope.product.sellPrice) ||
    isNaN($rootScope.product.originPrice) ||
    $rootScope.product.quantity <= 0 ||
    $rootScope.product.sellPrice <= 0 ||
    $rootScope.product.originPrice < 0
  ) {
    alert("Sua khong thanh cong!");
    $location.path("/trang-chu");
    return;
  } else {
    $http
      .put(
        "http://localhost:8080/api/product" + "/" + $routeParams.id,
        $rootScope.product
      )
      .then(
        function (response) {
          alert("Sua Thanh Cong!");
          $location.path("/trang-chu");
        },
        function (error) {
          alert(error.data.message);
          $location.path("/trang-chu");
        }
      );
  }
};
window.SeachController = function (
  $scope,
  $rootScope,
  $location,
  $http,
  $routeParams
) {
  $http
    .get("http://localhost:8080/api/product/seach/" + $routeParams.seach)
    .then(function (response) {
      $rootScope.listProduct = response.data;
    });
};
