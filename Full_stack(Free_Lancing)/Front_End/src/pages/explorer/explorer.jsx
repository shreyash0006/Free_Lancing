import { ToastContainer } from "react-toastify";
import "../styleforpages/pages.css"
import Explform from "./exploreform";
import Expllist from "./explorelist";
const Expl=()=>{
    return (
         <div className="outer">
     <ToastContainer/>
           <div className="left">
                <Explform/>
           </div>
           <div className="right" style={{overflowX:"auto"}}>
                <Expllist/>
           </div>
        </div>
    )
}
export default Expl;