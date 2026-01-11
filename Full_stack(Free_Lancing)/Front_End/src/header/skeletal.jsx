import "./style.css";
import "../Login_and_Logout/logout.css";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
const Navbar = () => {
  const nav=useNavigate();
  const logout=()=>{
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    toast.success("succesfully Loged Out")
    nav("/login");
  }
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-2">
        <a className="navbar-brand" href="#">
          <img
            src="https://www.svgrepo.com/show/303109/adobe-xd-logo.svg"
            alt="Logo"
            height="40"
          />
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse p-2" id="navbarNav">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <Link className="nav-link active" to={"/dashboard"}>
                DASHBOARD
              </Link>
            </li>
            <li className="nav-item">
             <Link className="nav-link active" to={"/explorer"}>
                EXPLORER
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link active" to={"/items"}>
                MANAGE ITEMS
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link active" to={"/category"}>
                MANAGE CATEGORIES
              </Link>
            </li>
            <li className="nav-item">
            <Link className="nav-link active" to={"/users"}>
                MANAGE USERS
              </Link>
            </li>
            <li className="nav-item">
            <Link className="nav-link active" to={"/orderhistory"}>
                ORDER HISTORY
              </Link>
            </li>
          </ul>
          <form className="d-flex">
           
            <button className="btn btn-outline-light" type="submit">
              Search
            </button>
          </form>
        </div>
        <button className="logout" onClick={logout}>Logout</button>
      </nav>
    </div>
  );
};

export default Navbar;
