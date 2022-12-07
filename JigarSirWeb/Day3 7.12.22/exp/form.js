var someFunction=function()
{
    // alert("hello")

    var txtData=document.getElementById('x1').value
    console.log(txtData)

    /******* pincode */
    // var expression=/^[1-9][0-9][0-9][0-9][0-9][0-9]$/
    // var expression=/^[1-9][0-9]{5}$/ 
    /******* pincode */

    /***Mobile no */
    // var expression=/^[6-9][0-9]{9}$/
    /***Mobile no */

     /***Pancard no */
    // var expression=/^[A-Z]{5}[0-9]{4}[A-Z]$/
    /***Pancard no */

     /***Name  -  het  {1,} ==>  + */
    // var expression=/^[a-zA-Z]([a-zA-Z ]{1,})?[a-zA-Z]$/
    var expression=/^[a-zA-Z]([a-zA-Z ]+)?[a-zA-Z]$/
    /***Name*/

     /***email */
// var expression=/^(om.patil)@(gmail).(co)(.in)?$/
// var expression=/^(om.patil)@(gmail).([a-zA-Z]{2,})(.in)?$/

// var expression=/^(om.patil)@(gmail)\.([a-zA-Z]{2,})(\.[a-zA-Z]{2,})?$/

// var expression=/^suraj12@([a-zA-Z0-9]([a-zA-Z0-9\-]+)?[a-zA-Z0-9])\.([a-zA-Z]{2,})(\.[a-zA-Z]{2,})?$/

// var expression=/^([a-zA-Z0-9]([a-zA-Z0-9_\.]+)?[a-zA-Z0-9])@([a-zA-Z0-9]([a-zA-Z0-9\-]+)?[a-zA-Z0-9])\.([a-zA-Z]{2,})(\.[a-zA-Z]{2,})?$/

// var expression=/^([a-zA-Z0-9]([a-zA-Z0-9_\.]+)?[a-zA-Z0-9])@([a-zA-Z0-9]([a-zA-Z0-9\-]+)?[a-zA-Z0-9])\.([a-zA-Z]{2,})(\.[a-zA-Z]{2,})?$/
    
    /***email*/

    /***Password*/
    var expression=/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#]).{4,12}$/
    
    // var expression=/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\-\.\\\/\^]).{4,12}$/

    // var expression=/^[a-zA-Z0-9@#]{4,8}$/
    /***Password*/



    var answer=expression.test(txtData)

    console.log(answer)
}