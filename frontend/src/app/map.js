import React, { useState, useEffect } from 'react';
import GoogleMapReact from 'google-map-react';
import Sidebar from './sidebar';
import Mark from './mark';
import api from './api'


// -23.554753, -46.633226 - sao paulo
//lat: -3.745951, -38.489308 fortaleza

const UbsMap = (props) =>  {

	const zoom = 14;
	
	const [center, setCenter] = useState({lat: -23.554753, lng: -46.633226});
	const [coord, setCoord] = useState(`${center.lat},${center.lng}`);
	const [listaUbs, setListaUbs] = useState([]);

	useEffect(() => {
		api.get(`api/v1/find_ubs?query=${center.lat},${center.lng}&page=1&per_page=100`)
		.then(res => {

			const lista = res.data.entries.map((item, index) => ({...item, index})) //adiciona o atributo index no objeto da lista

			console.log(lista);

			setListaUbs(lista);
		});
	}, [center]);
	

	const atualizarCoord = (coord) => {

		setCoord(coord);

		const arr = coord.split(',');
	
		const validaStringCoord = (/^[0-9\-\,. ]+$/.test(coord));
	
		if (arr.length != 2 || !validaStringCoord) return;

		setCenter({lat: Number(arr[0]), lng: Number(arr[1])});
				
	  }

	return (
		<div style={{ height: '100vh', width: '100%' }}>

			<Sidebar ubs={listaUbs}></Sidebar>

			<div className="pesquisar"> 

				<div className="search"> 
					<div className='div'>
						<i className="pi pi-search" style={ {fontSize:'12px'} }></i> 
						<input type='text' value={coord} placeholder='Pesquisar' onChange={e => atualizarCoord(e.target.value)}></input>
					</div>
				</div>

			</div>

			<GoogleMapReact
			bootstrapURLKeys={{ key: 'AIzaSyCO07DXW6GN2p-QcO7v9zW0Vwqd5lzyrKg' }}
			center={center}
			zoom={zoom}
			>

				{listaUbs.map(mark => 
				<Mark
					lat={mark.geocode.lat}
					lng={mark.geocode.longg}
					id={mark.id}
					name={mark.name}
					index={mark.index}
					address={mark.address}
					key={mark.id}
				/>
				)}
				
			</GoogleMapReact>

	</div>
	)

}


export default UbsMap;
