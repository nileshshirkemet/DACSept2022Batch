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
                for(val of  answer){
                    console.log(val);
                    x=x+`
                    <div class="col-xl-3 text-center">
                        <img src="${val.image}" class="img-fluid" />
                        <h2>${val.price}</h2>
                        <p>${val.title}</p>
                    </div>
                    `
                }

                console.log(x);
                document.getElementById('result').innerHTML=x;

            }
        }

    }
    
    record.open("get","https://fakestoreapi.com/products")
    record.send(null) //2,3,4

}