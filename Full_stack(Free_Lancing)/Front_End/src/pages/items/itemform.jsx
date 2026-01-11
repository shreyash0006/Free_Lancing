import { useContext, useEffect, useState } from "react";
import { toast } from "react-toastify";
import { additem } from "../../APIs_AND_Context/api";
import { AppContext, Itemcontext, Usercontext } from "../../APIs_AND_Context/context";

const Itemform=()=>{
    const [img,setimg]=useState(null);
    const [name,setname]=useState("");
    const [price,setprice]=useState("");
    const [description,setdes]=useState("");
    const [save,setsave]=useState(false);
    const [categoryid,setcat]=useState("");
    const [category,setcategory]=useState([]);
    const context=useContext(AppContext);
    const usectxt=useContext(Itemcontext);
    useEffect(()=>{
        if(context?.obj?.cat) setcategory(context.obj.cat);
    },[context?.obj?.cat])
    const savedetails=async(e)=>{
        e.preventDefault();
        if(!img)
        {toast.error("Add image file");
            return;
        }
        setsave(true);
        const data={name,price,description,categoryid};
        
        try{
            const form=new FormData();
            form.append("item",JSON.stringify(data));
            form.append("file",img);
            const res=await additem(form);
            if(res.status==200)
                toast.success("successfully item added");
            usectxt.obj.setitem((prev)=>[...prev,res.data]);
            setdes("");setimg(null);setname("");setprice("");
        }catch(e)
        {
            toast.error("unable to add the item");
            console.log(e);
        }
        finally{
            setsave(false);
            setcat("");setdes("");setimg("");setname("");setprice("");
        }
    }
    return (
        <div className="card">
         <div className="card-body">
            <form onSubmit={savedetails}>
                <div className="mb-3">
                    <label htmlFor="image"></label>
                    <input id="image" alt="click"  src="#" type="file"
                    onChange={(e)=>setimg(e.target.files[0])}
                    // value={img}
                    ></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="itemname" className="form-label">Name</label>
                    <input id="itemname" type="text" placeholder="item name" className="form-control"
                    onChange={(e)=>setname(e.target.value)}
                    value={name}
                    ></input>
                </div>
                <div className="mb-3">
                    <label htmlfor="options" className="form-label">Category</label>
                    <select className="mb-3 form-control" id="options" onChange={(e)=>setcat(e.target.value)}>
                        <option value="">--SELECT CATEGORY--</option>
                        {
                            category?.map((e,index)=>{
                              return <option key={index} value={e.catid}>{e.name}</option>
                            })
                        }
                    </select>
                </div>  
                  <div className="mb-3">
                    <label htmlFor="price" className="form-label">Price</label>
                    <input id="price" type="number" placeholder="$200" className="form-control"
                    onChange={(e)=>setprice(e.target.value)}
                    value={price}
                    ></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="description" className="form-label">description</label>
                    <textarea rows="5" id="description" placeholder="write content" className="form-control"
                    value={description}
                    onChange={(e)=>setdes(e.target.value)}
                    >
                    </textarea>
                </div>
             
                <button className="btn btn-primary w-100" type="submit" disabled={save}>{save?"saving":"save"}</button>
            </form>
            
         </div>
        </div>
    )
}
export default Itemform;