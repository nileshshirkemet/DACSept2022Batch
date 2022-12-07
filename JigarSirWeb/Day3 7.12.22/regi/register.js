function myFunction()
{
    console.log('tstt');

    var a1=document.getElementById('x1').value;
    var a2=document.getElementById('x2').value;
    var a3=document.getElementById('x3').value;
    var a4=document.getElementById('x4').value;
    var a5=document.getElementById('x5').value;

    var exp_mob=/^[6-9][0-9]{9}$/;
    var exp_name=/^[a-zA-Z]([a-zA-Z ]+)?[a-zA-Z]$/;
    var exp_email=/^([a-zA-Z0-9]([a-zA-Z0-9_\.]+)?[a-zA-Z0-9])@([a-zA-Z0-9]([a-zA-Z0-9\-]+)?[a-zA-Z0-9])\.([a-zA-Z]{2,})(\.[a-zA-Z]{2,})?$/;
    var exp_pass=/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#]).{4,12}$/;

    if(!exp_name.test(a1))
    {
        var msg='invalid name';
    }
    else if(!exp_mob.test(a2))
    {
        var msg='invalid number';
    }
    else if(!exp_email.test(a3))
    {
        var msg='invalid email';
    }
    else if(!exp_pass.test(a4))
    {
        var msg='invalid password';
    }
    else if(a4!=a5)
    {
        var msg='invalid confirm password';
    }
    else
    {
        var msg='do Registration Process'
    }

    document.getElementById('result').innerHTML=msg;
}