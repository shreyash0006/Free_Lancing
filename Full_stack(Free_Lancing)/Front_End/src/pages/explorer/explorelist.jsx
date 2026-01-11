import "./explore.css"
import Cartitems from "./SubExplorer/cartitem/cartitems";
import Cartsum from "./SubExplorer/cartsum/cartsummary";
import CustomerForm from "./SubExplorer/customerform/customerform";
const Expllist=()=>{
    return(
        <div className="explouter">
            <div className="list1row">
                <CustomerForm/>
            </div>
            <hr style={{border:"2px dashed black"}} ></hr>
            <div className="list2row">
                <Cartitems/>
            </div>
            <hr style={{border:"2px dashed black"}}></hr>
            <div className="list3row">
                <Cartsum/>
            </div>
        </div>

    );
}
export default Expllist;