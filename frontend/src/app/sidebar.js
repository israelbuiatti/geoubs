import React from 'react'



const sidebar = (props) =>  (

    
    <div className="sidebar"> 


        {
            props.ubs.map(mark => (
                <div className="ubs" key={mark.id}> 
                    
                    <div className='title'> {mark.name} </div>
                    
                    <br/>

                    {mark.address}<br/>
                    {mark.city}<br/><br/>

                    <b>Telefone:</b> <br/>
                    {mark.phone}


                </div>
            ))
        }
        

    
    </div>
    

)

export default sidebar;