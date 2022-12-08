function myFunction(){
    console.log('func called');

    var amount = document.getElementById('x1').value;
    var roi = document.getElementById('x2').value;
    var duration = document.getElementById('x3').value;

    if(amount=="" || roi=="" || duration==""){
        alert('All values Required')
    }
    else{
        amount = parseInt(amount);
        roi = parseInt(roi);
        duration = parseInt(duration);

        var emi = Math.round(amount*roi*duration/100);

        document.getElementsByTagName('p')[0].innerHTML = ` EMI = ${emi}`;
        document.getElementsByTagName('p')[1].innerHTML = `FINAL = ${amount+emi}` ;
    }
}