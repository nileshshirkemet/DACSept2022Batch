import React, { Component } from 'react'
import x1 from './context'

export default class Child3 extends Component {
  render() {
    return (
      <div>
        child 3
        <x1.Consumer>
        {value =>(
            <div> test {value}</div>
        )}
        </x1.Consumer>
      </div>
    )
  }
}
