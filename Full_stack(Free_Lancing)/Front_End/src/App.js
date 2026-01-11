import "./header/style.css";
import './App.css';
import { useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js'; 
import Dash from "./pages/dashboard/dashboard";
import Expl from "./pages/explorer/explorer";
import Item from "./pages/items/items";
import User from "./pages/users/user";
import Cate from "./pages/categories/categories";
import { Route, Routes, useLocation, useNavigate } from "react-router-dom";
import Navbar from "./header/skeletal";
import { ToastContainer } from "react-toastify";
import Login from "./Login_and_Logout/login";
import ProtectedRoute from "./ProtectedRoute";
import { CartItem, ExploreContext} from "./APIs_AND_Context/context";
import OrderH from "./pages/orderhistory/Order_History";

function App() {
  const loc = useLocation();
  const nav = useNavigate();

  useEffect(() => {
    if (loc.pathname === "/") {
      nav("/login");
      return;
    }
  }, [loc, nav]);

  const isLoginPage = loc.pathname === "/login";

  return (
    <div className="heightadjuster">
     
      {!isLoginPage && <Navbar /> }
     <CartItem>
       <ExploreContext>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/dashboard" element={<ProtectedRoute element={Dash} />} />
        <Route path="/explorer" element={<ProtectedRoute element={Expl} />} />
        <Route path="/category" element={<ProtectedRoute element={Cate} />} />
        <Route path="/users" element={<ProtectedRoute element={User} />} />
        <Route path="/items" element={<ProtectedRoute element={Item} />} />
        <Route path="/orderhistory" element={<ProtectedRoute element={OrderH}/>}/>
      </Routes>
      </ExploreContext>
     </CartItem>
    </div>
  );
}

export default App;
