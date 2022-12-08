document.getElementById("btn").onclick = function(){
    // alert()
    var a = document.getElementById("x1").value;
    var b = document.getElementById("x2").value;
    var c = document.getElementById("x3").value;

    // console.log(a,b,c);
    var jsObj = {
        customerId:a,
        productNo:b,
        quantity:c
    };

    console.log(jsObj);

    //objecxt to striong

    var params = JSON.stringify(jsObj);
    console.log(params);

    var rec = new XMLHttpRequest();
    

    rec.onreadystatechange = function(){
        console.log(rec.readyState , rec.status);
    }

    rec.open('POST','http://localhost:8080/ModernWebApp/api/orders/');

    rec.setRequestHeader('Content-Type', 'application/json');

    rec.send(params);
}