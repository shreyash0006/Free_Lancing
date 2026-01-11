import { useState,useContext } from "react";
import { toast } from "react-toastify";
import { post} from "../../APIs_AND_Context/api";
import { AppContext } from "../../APIs_AND_Context/context";
const Catform=()=>{
    const [Load,setLoad]=useState(false);
    const [img,setimg]=useState(false);
    const [name,setname]=useState("");
    const [description,setdescription]=useState("");
    const [color,setcolor]=useState("#c43636ff");
    const context=useContext(AppContext);
    
    const submitall=async(e)=>{
        e.preventDefault();
        if(!img)
        {
            toast.error("please select the image");return;
        }
        const obj={
            name:name,description:description,bgcolor:color
        }
        console.log(color);
        try{
            const formd=new FormData();
        setLoad(true);
            formd.append("category",JSON.stringify(obj));
            formd.append("file",img);
            const res=await post(formd);
            setimg(false);
           context.obj.setcat((prev) => [...prev, res.data]);
           setname("");setcolor("#fff");setdescription("");
           toast("categeoty successfully added");
        }
        catch(e){
            toast.error("unable to add Category");
        }
        finally{
            setLoad(false);
        }
    }
    return(
        <div className="card">
         <div className="card-body">
            <form onSubmit={submitall}>
                <div className="mb-3">
                    <label htmlFor="image"></label>
                    <input id="image" alt="click"  src="#" type="file" 
                    onChange={(e)=>setimg(e.target.files[0])}
                    >
                    
                    </input>
                </div>
                <div className="mb-3">
                    <label htmlFor="name" className="form-label">Name</label>
                    <input id="name" type="text" placeholder="category name"
                     className="form-control"
                     onChange={(e)=>setname(e.target.value)}
                     value={name}
                     ></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="description" className="form-label">description</label>
                    <textarea rows="5" id="description" placeholder="write content" 
                    className="form-control"
                    onChange={(e)=>setdescription(e.target.value)}
                    value={description}
                    >
                    </textarea>
                </div>
                <div className="mb-3">
                    <label className="form-label" htmlfor="color">Background-color</label>
                    <br></br>
                    <input type="color" id="color"
                    onChange={(e)=>setcolor(e.target.value)}
                    value={color}
                    ></input>
                </div>
                <button className="btn btn-primary w-100" type="submit" >{Load?"Uploading...":"submit"}</button>
            </form>
            
         </div>
        </div>
    )
}
export default Catform;