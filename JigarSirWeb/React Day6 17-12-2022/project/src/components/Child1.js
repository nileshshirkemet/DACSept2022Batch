import React, { Component } from 'react'
import Child2 from './Child2'

export default class Child1 extends Component {
  render() {
    return (
      <div>
        <h1>Child1 Component ,{this.props.a}</h1>
        <Child2 b={this.props.a}/>
      </div>
    )
  }
}
