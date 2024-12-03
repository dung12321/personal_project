const next = document.querySelector('.next');
const prev = document.querySelector('.prev');
const comments = document.querySelector('#list-comments');
const commentItems = document.querySelectorAll('#list-comments .item');
var translateY = 0;

next.addEventListener('click', function (event) {
    event.preventDefault();
    if(count == 1) {
        //Xem het cmt
        return false;
    }
    translateY += -400;
    comments.style.transform = `translate(${translateY}px)`;
    count--;
})

prev.addEventListener('click', function (event) {
    event.preventDefault();
    if(count == 3) {
        //Xem het cmt
        return false;
    }
    translateY += 400;
    comments.style.transform = `translate(${translateY}px)`;
    count++;
})
$(document).ready(function() {
    $.ajax({
        url: '/api/products',
        method: 'GET',
        success: function(data) {
            data.forEach(product => {
                $('#list-products').append(`
          <div class="item">
            <img src="${product.image}" alt="${product.name}" />
            <div class="stars">
              <span><img src="images/star.png" alt="star"></span>
             
            </div>
            <div class="name">${product.name}</div>
            <div class="desc">${product.description}</div>
            <div class="price">${product.price} VND</div>
          </div>
        `);
            });
        }
    });
});
