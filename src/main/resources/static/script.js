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