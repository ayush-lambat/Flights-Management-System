import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';

export default class ShowFlight extends Component {

    constructor(props) {

        super(props);

        this.service = new FlightRestService();
    }

    deleteFlight = (code) => {

        this.service.deleteFlight(code)
        .then(data => {

            alert(data);

            window.location.reload();
        });
    }

    render() {

        const f = this.props.flight;

        return (

            <tr>

                <td>{f.code}</td>

                <td>{f.carrier}</td>

                <td>{f.source}</td>

                <td>{f.destination}</td>

                <td>{f.cost}</td>

                <td>

                    <button
                        className='btn btn-danger'
                        onClick={() =>
                            this.deleteFlight(f.code)
                        }>

                        Delete

                    </button>

                </td>

            </tr>
        );
    }
}