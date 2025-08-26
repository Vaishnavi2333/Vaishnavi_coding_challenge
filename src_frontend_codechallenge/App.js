import logo from './logo.svg';
import './App.css';

import { BrowserRouter,Routes, Route,Link} from 'react-router-dom';
import { GetPlayer } from './service/GetPlayer';
import { PostPlayer } from './service/PostPlayer';
import { PutPlayer } from './service/PutPlayer';

import { SearchPlayersByRole } from './service/SearchPlayersByRole';


function App() {
  return(
    <>
<h1 className="text-center">Cricket Player Management System</h1>


<BrowserRouter>
  <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
    <div className="container-fluid">
      <Link className="navbar-brand" to="/">Cricket Manager</Link>
      <div className="collapse navbar-collapse">
        <ul className="navbar-nav me-auto">
          <li className="nav-item">
            <Link to="/getall" className="nav-link">Get Players</Link>
          </li>
          <li className="nav-item">
            <Link to="/add" className="nav-link">Add Player</Link>
          </li>
          <li className="nav-item">
            <Link to="/update" className="nav-link">Edit Player</Link>
          </li>
          <li className="nav-item">
            <Link to="/getbyrole" className="nav-link">Get By Role</Link>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <Routes>
    <Route path="/getall" element={<GetPlayer />} />
    <Route path="/add" element={<PostPlayer />} />
    <Route path="/update" element={<PutPlayer />} />
    <Route path="/getbyrole" element={<SearchPlayersByRole />} />
  </Routes>
</BrowserRouter>


    </>
  )
}

export default App;
