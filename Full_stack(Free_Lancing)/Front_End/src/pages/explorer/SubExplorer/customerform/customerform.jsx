import { useContext } from "react";
import "./customerform.css"
import { cartitem } from "../../../../APIs_AND_Context/context";
const CustomerForm=()=>{
    const cntxt=useContext(cartitem).obj;
    return(
        <div>
            <h1>Customer Form</h1>
            <div className="mb-3 customer">
                <span>Customer Name      </span><input type="text" onInput={(e)=>cntxt.setname(e.target.value)} value={cntxt.name}
                                        className="form-control" style={{width:"350px",border:"none"}}></input>
            </div>
            <br></br>
           <div className="mb-3 customer">
             <span>Mobile Number          </span><input className="form-control" value={cntxt.phone}
                                            onInput={(e)=>cntxt.setphone(e.target.value)}
                                            style={{width:"350px"}}></input>
           </div>
        </div>
    )
}
export default CustomerForm;