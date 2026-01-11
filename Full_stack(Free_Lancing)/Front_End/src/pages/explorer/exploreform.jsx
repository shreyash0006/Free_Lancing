
import { useContext } from "react";
import "./explore.css"
import Cart from "./SubExplorer/displayitems/displayitems";
import Excategory from "./SubExplorer/cat/categoryexpl";
import { Explorecntxt, ExploreContext } from "../../APIs_AND_Context/context";
import { getitem } from "../../APIs_AND_Context/api";
import { ToastContainer } from "react-toastify";

const Explform=()=>{
   const cntxt=useContext(Explorecntxt);
    const setallitems=async()=>{
        const res=await getitem();
        cntxt.setpartcat(res.data);
    }
    return(
       
        
         <div className="explouter">
            
            <div className="form1row">
                <button className="btnn" onClick={()=>setallitems()}>All Items</button> 
                <h1>CATEGORY LIST</h1>
                <ToastContainer/>
                <Excategory/>
                
            </div>
            <hr></hr>
            <div className="form2row">
                <Cart/>
            </div>
        </div>
 
    )
}
export default Explform;