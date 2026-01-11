    import  {  useContext, useEffect, useState } from "react";
    import { deluser } from "../../APIs_AND_Context/api";
    import { toast } from "react-toastify";
    import { Usercontext } from "../../APIs_AND_Context/context";
    const Userlist=()=>{
        const [users,setusers]=useState([]);
        const [searchvalue,setsearch]=useState("");
        const context=useContext(Usercontext);
        const filte=()=>users.filter((e)=>
            e?.name?.toLowerCase().includes(searchvalue.toLowerCase())
        );
        useEffect(()=>{
            async function get()
            {
                if(context?.obj?.user) setusers(context.obj.user);
            }
            get();
        }  
        ,[context?.obj?.user]);
        const del=async(id)=>
        {
            try
            {
                await deluser(id);
                toast.success(`user ${id} successfully deleted`);
                setusers(u=>u.filter(e=>e.userid!==id));
                context.obj.setuser(e=>e.filter((r)=>r.userid!==id));
            }
            catch(e)
            {
                toast.error("Unable to delete user");
                console.log("error occured"+e);
            }
        }
        return (
            <div>
                <div>
                    <input className="form-control" placeholder="Search..." name="category"
                    onChange={e=>setsearch(e.target.value)} value={searchvalue}
                    />
                </div>
                <div>
                    {filte().map((e, index) => (
                        <div key={index}>
                            <div className="card mb-3 mt-3 out" style={{width:"100%",borderRadius:"10px",border:"5px solid black"} }>
                                <div className="card align" style={{backgroundColor:e.bgcolor ,borderRadius:"5px"}}>
                                
                                    <div>
                                        <h4>{e.name}</h4>
                                        <p>{e.email}</p>
                                    </div>
                                    <div>
                                        <button className="btn btn-warning" onClick={()=>del(e.userid)}>Delete</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        );
    };

    export default Userlist;