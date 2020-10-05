import React from 'react';

import Navbar from '../app/navbar'

import 'bootswatch/dist/flatly/bootstrap.css'
import '../css/custom.css'

import 'primeicons/primeicons.css';
import UbsMap from '../app/map';

class App extends React.Component {

  render(){
    return(
      <>
        <Navbar />
        <UbsMap></UbsMap>
      </>
    )
  }
}

export default App