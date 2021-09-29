var cart = [];

function addToCart(id) {
    cart.push(id);
}

function removeFromCart(id) {
    for (var i = 0; i < cart.length; i++) {
        if (cart[i] === id) {
            cart.splice(i, 1);
        }
    }
}
$( document ).ready(function() {

    $('.product-list').click(function(){
        var product = $(this).text(); //$(this) is what you clicked!
    });
});
