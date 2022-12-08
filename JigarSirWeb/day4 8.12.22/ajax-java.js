document.getElementById('btn').onclick=function(){
    // alert()
    var record=new XMLHttpRequest()
    console.log(record); //0
    console.log(record.readyState);

    //check readystate using onreadystatechange
    record.onreadystatechange=function()
    {
        console.log(record.readyState, record.status); //1
        if(record.status==200 && record.readyState==4)
        {
            console.log(record.responseText);
            var answer=JSON.parse(record.responseText)
            console.log(answer);

            if(answer.length>0)
            {   
                var x=""
                for(val of answer)
                {
                    console.log(val);
                    x=x+`
                    <tr>
                        <td>${val.orderNo}</td>
                        <td>${val.productNo}</td>
                        <td>${val.quantity}</td>
                    </tr>
                    `
                }
                console.log(x);
                document.getElementById('result').innerHTML=x;
            }

            
        }

    }
    
    record.open("get","http://localhost:8080/ModernWebApp/api/orders/CU303")
    record.send(null) //2,3,4

}