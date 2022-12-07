// alert("Hello")
// confirm("Exit")

function myFunction(a,b,c)
{
    // console.log("hello",a,b,c)
    // console.log(document);
    // console.log(typeof document);

    // console.log(document.getElementById('x1'));
    // console.log(typeof document.getElementById('x1'));

    //DOM Method--getElementById()
    //DOM Property--value
    var amount=document.getElementById('x1').value;
    var instrest=document.getElementById('x2').value;
    var duration=document.getElementById('x3').value;

    // console.log(amount,instrest,duration);
    // console.log(typeof amount,typeof instrest,typeof duration);

    if(amount==""||instrest==""||duration=="")
    {
        alert("Please Pass all Value")
    }
    else
    {
        amt=parseInt(amount);
        roi=parseFloat(instrest);
        duration=parseInt(duration);

        var openingBalance= 0;
        var x="";
        for(var i=1;i<=duration;i++)
        {   
            var instrestEarned= Math.round((openingBalance+amt)*roi/100);
            var closingBalance= openingBalance+amt+instrestEarned;
            console.log(i,openingBalance,amt,instrestEarned,closingBalance);

            x=x+`
                <tr>
                    <td>${i}</td>
                    <td>${openingBalance}</td>
                    <td>${amt}</td>
                    <td>${instrestEarned}</td>
                    <td>${closingBalance}</td>
                </tr>
            `
            openingBalance=closingBalance;
        }
        console.log(x);
        console.log(document.getElementById("result"));
        //DOM Property innerHTML
        document.getElementById("result").innerHTML= x

    }

    


    

}