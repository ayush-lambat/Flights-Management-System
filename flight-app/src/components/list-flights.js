import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';
import ShowFlight from './show-flight';

export default class ListFlights extends Component {

    constructor(props) {

        super(props);

        this.service = new FlightRestService();

        this.state = {
            flights: []
        };
    }

    async componentDidMount() {

        const data =
            await this.service.getAllFlights();

        if (data != null) {

            this.setState({
                flights: data
            });
        }
    }

    render() {

        return (
            <>
            <br />

            <div className="card p-4">

            <h2 className="page-title">

                Flight List

            </h2>

            <hr />

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