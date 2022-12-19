import React from "react";

//export {user,role}
// export default xyz

export default class Register extends React.Component {
    constructor(){
    super()
        this.state={
            api:[]
        }
   }

   componentDidMount(){
    fetch("http://localhost:9000/api/users")
    .then(res=> res.json())
    .then(apivalue=>{
       console.log(apivalue);
        this.setState({api:apivalue})
    })
   }
    componentWillUnmount(){
        console.log("unmount cycle activated");
    }
    render(){
        var xyz=this.state.api
        return(
<div>
      <table className='table'>
      {
        xyz.length>0 && xyz.map((val)=>
          <tr>
            <td>{val._id}</td>
            <td>{val.name}</td>
            <td>{val.age}</td>
            
          </tr>
        )
      }
      </table>
      
    </div>
        )
        
    }
}