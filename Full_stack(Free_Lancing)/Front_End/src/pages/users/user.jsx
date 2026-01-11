import Userprov from "../../APIs_AND_Context/context";
import "../styleforpages/pages.css"
import Userform from "./userform";
import Userlist from "./userlist";
const User=()=>{
    return (
        <Userprov>
            <div className="outer">
           <div className="left">
            <Userform/>
           </div>
           <div className="right">
                <Userlist/>
           </div>
        </div>
        </Userprov>
    )
}
export default User;