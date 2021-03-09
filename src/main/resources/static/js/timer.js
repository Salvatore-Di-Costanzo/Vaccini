let currentDate = new Date().toLocaleDateString();
let countDownDate = new Date( currentDate +" 18:00:00").getTime();
let distance;
// Update the count down every 1 second
let x = setInterval(function() {

    // Get today's date and time
    let now = new Date().getTime();
    // Find the distance between now and the count down date
    distance = countDownDate - now;
    // Time calculations for days, hours, minutes and seconds
    let hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    let minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    let seconds = Math.floor((distance % (1000 * 60)) / 1000);

    // Output the result in an element with id="demo"
    document.getElementById("countDown").innerHTML = hours + "h "
        + minutes + "m " + seconds + "s ";
    // If the count down is over, write some text
    if ((hours == 23 && minutes >=30) ) {
        clearInterval(x);
        document.getElementById("countDown").innerHTML = "<br>Siamo quasi pronti! <br> i dati si aggiorneranno a breve.";
    }
}, 1000);