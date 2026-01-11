import "../styleforpages/pages.css"
import Catform from "./categoryform";
import Catlist from "./categorylist";
const Cate=()=>{
    return (
        <div className="outer">
           <div className="left">
                <Catform/>
           </div>
           <div className="right">
                <Catlist/>
           </div>
        </div>
    )
}
export default Cate;