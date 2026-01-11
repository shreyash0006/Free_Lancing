import {  Itemprov } from "../../APIs_AND_Context/context";
import "../styleforpages/pages.css"
import Itemform from "./itemform";
import ItemList from "./itemlist";
import "./items.css"
const Item=()=>{
    return (
        <Itemprov>
            <div className="outer">
           <div className="left">
                <Itemform/>
           </div>
           <div className="right itemlist">
                <ItemList/>
           </div>
        </div>
        </Itemprov>
    )
}
export default Item;