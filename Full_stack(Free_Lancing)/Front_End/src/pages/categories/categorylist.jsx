import { useContext, useEffect, useState } from "react";
import { AppContext } from "../../APIs_AND_Context/context";
import "./categorylist.css";
import { del, getcat, getcount } from "../../APIs_AND_Context/api";
import { toast } from "react-toastify";
const Catlist = () => {
    const [data, setdata] = useState([]);
    const context = useContext(AppContext);
    const [searchvalue,setsearch]=useState("");
    const [count,setcounts]=useState();
    useEffect(() => {
        if (context?.obj?.cat) {setdata(context.obj.cat);}
       
    }, [context?.obj?.cat]);
 useEffect(() => {
    const fetchCounts = async () => {
      if (!data || data.length === 0) return;
      const result = {};

      for (const cat of data) {
        try {
          const res = await getcount(cat.id); 
          result[cat.id] = res.data; 
          console.log(result);

        } catch (err) {
          console.error(`Error fetching count for category ${cat.id}`, err);
          result[cat.id] = 0;
        }
      }
      setcounts(result);
    };
    fetchCounts();
  }, [data]);
    const filte=()=>data.filter((e)=>
        e?.name?.toLowerCase().includes(searchvalue.toLowerCase())
    );
    const dele=async (delecat)=>{
        try{
            await del(delecat);
            setdata(pr=>pr.filter(e=>e.catid!=delecat));
            context.obj.setcat(pr=>pr.filter(e=>e.catid!=delecat));
            toast.success("deleted successfully");
        }
        catch(er)
        {
            toast.error("unable to delete");
            console.log(er);
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
                                    <img src={e.imgurl} alt={e.name} />
                                </div>
                                <div>
                                    <h4>{e.name}</h4>
                    <p>items: {count?.[e.id] ?? "Loading..."}</p>

                                </div>
                                <div>
                                    <button className="btn btn-warning" onClick={()=>dele(e.catid)}>Delete</button>
                                </div>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default Catlist;
