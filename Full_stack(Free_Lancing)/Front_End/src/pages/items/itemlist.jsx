import { useContext, useEffect, useState } from "react";
import { AppContext, Itemcontext } from "../../APIs_AND_Context/context";
import { del, delitem, getcat } from "../../APIs_AND_Context/api";
import { toast } from "react-toastify";
import "./items.css"
const ItemList = () => {
    const [data, setdata] = useState([]);
    const context = useContext(Itemcontext);
    const [searchvalue,setsearch]=useState("");
    useEffect(() => {
        if (context?.obj?.item) setdata(context.obj.item);
        
    }, [context?.obj?.item]);

    const filte=()=>data.filter((e)=>
        e?.name?.toLowerCase().includes(searchvalue.toLowerCase())
    );
    const dele=async (deleitem)=>{
        try{
            await delitem(deleitem);
            setdata(pr=>pr.filter(e=>e.itemid!=deleitem));
            context.obj.setitem(pr=>pr.filter(e=>e.itemid!=deleitem));
            toast.success("deleted successfully");
        }
        catch(er)
        {
            toast.error("unable to delete");
            console.log(er);
        }
    }
    return (
        <div className="scroll">
            <div>
                <input className="form-control search" placeholder="Search..." name="category"
                   onChange={e=>setsearch(e.target.value)} value={searchvalue}
                />
            </div>
            <div >
                {filte().map((e, index) => (
                    <div key={index}>
                        <div className="card mb-3 mt-3 out" style={{width:"100%",borderRadius:"10px",border:"5px solid black"} }>
                            <div className="card align" style={{backgroundColor:e.bgcolor ,borderRadius:"5px"}}>
                                <div>
                                    <img src={e.imgurl} alt={e.name} />
                                </div>
                                <div>
                                    <h4>{e.name}</h4>
                                    <h4>category :{e.categoryname}</h4>
                                    <p>Price :₹{e.price}</p>
                                  
                                </div>
                                <div>
                                    <button className="btn btn-warning" onClick={()=>dele(e.itemid)}>Delete</button>
                                </div>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default ItemList;
