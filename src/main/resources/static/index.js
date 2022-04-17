angular.module('market', []).controller('indexController', function ($scope, $http) {
    $scope.fillTable = function () {
        $http.get('http://localhost:8189/market/api/v1/products')
            .then(function (response) {
                $scope.products = response.data;
                // console.log(response);
            });
    };


    $scope.deleteProduct = function (id) {
        $http.delete('http://localhost:8189/market/api/v1/products/' + id)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.createNewProduct = function () {
        // console.log($scope.newProduct);
        $http.post('http://localhost:8189/market/api/v1/products', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    }

     $scope.addProductToCart = function (id) {
         $http.get('http://localhost:8189/market/api/v1/cart/add/' + id)
                .then(function (response) {
                    $scope.fillCart();
                });
        }


     $scope.minusProductFromCart = function (productId){
                $http.get('http://localhost:8189/market/api/v1/cart/remove/' + productId)
                    .then(function (response){
                    $scope.fillCart();
                    console.log(response);
                })
            }


     $scope.clearCart = function (){
                $http.get('http://localhost:8189/market/api/v1/cart/clear')
                    .then(function (response){
                        $scope.fillCart();
                        console.log(response);
                    })
            }

     $scope.fillCart = function (){
            $http.get('http://localhost:8189/market/api/v1/cart')
                .then(function (response){
                    $scope.cartList = response.data.items;
                })
        }

    $scope.fillCart();
    $scope.fillTable();
});