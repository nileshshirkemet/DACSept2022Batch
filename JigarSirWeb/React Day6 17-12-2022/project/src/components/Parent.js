import React, { Component } from 'react'
import Child1 from './Child1'

import x1 from './context'

export default class Parent extends Component {
    constructor(){
        super()
        this.state={
            name:"kiran",age:20
        }
    }
  render() {
    return (
      <div>
        <h1>Parent Component ,{this.state.name}</h1>
        <x1.Provider value={this.state.age}>
            <Child1 a={this.state.name}/>
        </x1.Provider>
      </div>
    )
  }
}
