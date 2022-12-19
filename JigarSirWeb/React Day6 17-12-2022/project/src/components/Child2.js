import React, { Component } from 'react'
import Child3 from './Child3'

export default class Child2 extends Component {
  render() {
    return (
      <div>
        <h1>Child2 Component, {this.props.b}</h1>
        <Child3 />

      </div>
    )
  }
}
