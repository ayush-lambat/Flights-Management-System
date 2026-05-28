import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';
import ShowFlight from './show-flight';

export default class FindPrice extends Component {

    constructor(props) {

        super(props);

        this.service = new FlightRestService();

        this.state = {
            min: '',
            max: '',
            flights: []
        };
    }

    handleInput = (event) => {

        const name = event.target.name;
        const value = event.target.value;

        this.setState({
            [name]: value
        });
    }

    searchFlight = () => {

        this.service
        .getFlightByPriceRange(
            this.state.min,
            this.state.max
        )

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

                Find Flight By Price

            </h2>

            <hr />

            <input
                name='min'
                placeholder='Enter Minimum Price'
                className='form-control'
                onChange={this.handleInput}
            />

            <br />

            <input
                name='max'
                placeholder='Enter Maximum Price'
                className='form-control'
                onChange={this.handleInput}
            />

            <br />

            <div className='text-center'>

                <button
                    className='search-btn'
                    onClick={this.searchFlight}
                >

                    Search

                </button>

            </div>

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