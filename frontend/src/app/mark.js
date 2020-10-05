import React from 'react';

const Mark = ({ name, address, index }) => (


    <div>
      <div className="hint hint--html hint--info hint--top mark">
          <div>{index}</div>
          <div className="seta-baixo-mark"></div>
      </div>
      <div className='info'> 
          <div>
            <div className='info-title'>{name}</div>
            <div className='info-address'>{address}</div>
          </div>
          <div className="seta-baixo-info"></div>
      </div>
      
    </div>

);

export default Mark;
