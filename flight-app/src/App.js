import './App.css'

import ListFlights from './components/list-flights'
import AddFlight from './components/add-flight'

import {
  BrowserRouter,
  Routes,
  Route,
  Link
} from 'react-router-dom'

import FindCarrier from './components/find-carrier'
import FindRoute from './components/find-route'
import FindPrice from './components/find-price'

export default function App() {

  return (

    <div className="container-fluid">

      <BrowserRouter>

 <nav className="navbar navbar-expand-lg custom-navbar">

  <div className="container-fluid d-flex flex-column">

    <div className="flight-logo">

      ✈

    </div>

    <h1 className="navbar-title">

      Flight Management System

    </h1>
    <p></p>

    <div className="menu-center">

      <Link to="/add" className="menu-link">
        Add Flight
      </Link>

      <Link to="/list" className="menu-link">
        Flight List
      </Link>

      <Link to="/carrier" className="menu-link">
        Search Carrier
      </Link>

      <Link to="/route" className="menu-link">
        Search Route
      </Link>

      <Link to="/price" className="menu-link">
        Search Price
      </Link>

    </div>

  </div>

</nav>
        <div className="container content-box">

          <Routes>

            <Route
              path="/"
              element={<ListFlights />}
            />

            <Route
              path="/list"
              element={<ListFlights />}
            />

            <Route
              path="/add"
              element={<AddFlight />}
            />

            <Route
              path="/carrier"
              element={<FindCarrier />}
            />

            <Route
              path="/route"
              element={<FindRoute />}
            />

            <Route
              path="/price"
              element={<FindPrice />}
            />

            <Route
              path="*"
              element={
                <div className="alert alert-danger">
                  Page Not Found
                </div>
              }
            />

          </Routes>

        </div>

      </BrowserRouter>

    </div>
  )
}