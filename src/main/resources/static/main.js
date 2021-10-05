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
console.log("is it working");
    $('.product-list').click(function(){
        console.log("here")
        var id = $(this).attr("data-productId")
        if(cart.includes(id)) {
            $(this).removeClass("selected");
            removeFromCart(id);
        } else {
            $(this).addClass("selected");
            addToCart(id);
        }
    });

    $('#submit-order').click( function() {
        window.location.href = "http://localhost:8080/product/sale-summary?productIds=" + cart.join(",");
    })
});
