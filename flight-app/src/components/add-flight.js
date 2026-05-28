import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';

export default class AddFlight extends Component {

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

            code: '',
            carrier: '',
            source: '',
            destination: '',
            cost: ''
        };
    }

    handleInput = (event) => {

        const name = event.target.name;
        const value = event.target.value;

        this.setState({

            [name]: value
        });
    }

    onSave = () => {

        this.service.saveFlight(this.state)

        .then(data => {

            alert("Flight Saved Successfully");

            window.location.reload();
        });
    }

    render() {

        return (
            <>
            <br />

            <div className="card p-5">

            <h2 className="page-title">
                Add Flight
            </h2>

            <hr />

            <form
                className='was-validated'
                onSubmit={(e) => {

                    e.preventDefault();

                    this.onSave();
                }}
            >

                <div className="mb-3">

                    <input
                        name="code"
                        onChange={this.handleInput}
                        placeholder="Enter Flight Code"
                        className="form-control"
                        required
                    />

                </div>

                <div className="mb-3">

                    <select
                        name="carrier"
                        value={this.state.carrier}
                        onChange={this.handleInput}
                        className="form-control"
                        required
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

                </div>

                <div className="mb-3">

                    <input
                        name="source"
                        onChange={this.handleInput}
                        placeholder="Enter Source"
                        className="form-control"
                        required
                    />

                </div>

                <div className="mb-3">

                    <input
                        name="destination"
                        onChange={this.handleInput}
                        placeholder="Enter Destination"
                        className="form-control"
                        required
                    />

                </div>

                <div className="mb-3">

                    <input
                        name="cost"
                        onChange={this.handleInput}
                        placeholder="Enter Flight Cost"
                        className="form-control"
                        required
                    />

                </div>

                <div className="text-center">

                    <button
                        className="save-btn"
                        type='submit'
                    >

                        Save Flight

                    </button>

                </div>

            </form>

            </div>
            </>
        );
    }
}