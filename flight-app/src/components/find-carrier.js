import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';
import ShowFlight from './show-flight';

export default class FindCarrier extends Component {

    carrierOptions = [
        'Indigo',
        'AirIndia',
        'SpiceJet',
        'Vistara'
    ];

    constructor(props) {

        super(props);

        this.service = new FlightRestService();

        this.state = {
            carrier: '',
            flights: []
        };
    }

    handleInput = (event) => {

        this.setState({
            carrier: event.target.value
        });
    }

    searchFlight = () => {

        this.service
        .getFlightByCarrier(this.state.carrier)

        .then(data => {

            this.setState({
                flights: data
            });
        });
    }

    render() {

        return (
            <>
            <br />

            <div className="card p-4">

            <h2 className="page-title">

                Find Flight By Carrier

            </h2>

            <hr />

            <select
                className='form-control'
                value={this.state.carrier}
                onChange={this.handleInput}
            >

                <option value="">
                    Select Carrier
                </option>

                {
                    this.carrierOptions.map(
                        (carrier, index) => (

                        <option
                            key={index}
                            value={carrier}
                        >

                            {carrier}

                        </option>
                    ))
                }

            </select>

            <br />
                <div className="text-center">
            <button
                className='search-btn'
                onClick={this.searchFlight}
            >

                Search

            </button>
                </div>
            <br />
            <br />

            <table className='table table-hover'>

                <thead className='table-dark'>

                    <tr>

                        <th>Code</th>
                        <th>Carrier</th>
                        <th>Source</th>
                        <th>Destination</th>
                        <th>Cost</th>
                        <th>Delete</th>

                    </tr>

                </thead>

                <tbody>

                    {
                        this.state.flights.map((flight) => (

                            <ShowFlight
                                key={flight.code}
                                flight={flight}
                            />
                        ))
                    }

                </tbody>

            </table>

            </div>
            </>
        );
    }
}