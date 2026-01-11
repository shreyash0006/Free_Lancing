import { useContext, useEffect, useState } from "react";
import { AppContext, Explorecntxt, Itemcontext } from "../../../../APIs_AND_Context/context";
import "./category.css"
import { getcount, getitemofcat } from "../../../../APIs_AND_Context/api";
const Excategory=()=>{
    let cntxt=useContext(AppContext);
    const [data,setdata]=useState([]);
    const [count,setcounts]=useState(null);
    useEffect(()=>{
        if(cntxt?.obj?.cat)
           { setdata(cntxt.obj.cat);
        }
    },[cntxt?.obj?.cat])
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
          console.error(`Error fetching count for category ₹{cat.id}`, err);
          result[cat.id] = 0;
        }
      }
      setcounts(result);
    };
    fetchCounts();
  }, [data]);
  const explcntxt=useContext(Explorecntxt);
  const set=async (id)=>{
    const res=await getitemofcat(id);
    explcntxt.setpartcat(res.data);
    console.log(explcntxt.partcat);
  }
    return(
        <div className="o">
          
           {

            data && data.map((data)=>(
                <div className="in" style={{backgroundColor:data.bgcolor}} onClick={()=>set(data.id)}>
                    <div>
                    <img src={data.imgurl}></img>
                    </div>
                    <div>
                        <div>
                            {data.name}
                        </div>
                        <div>
                            items : {count? count[data.id]: "Loading..."}
                        </div>
                    </div>
                </div>
            ))
           }
        </div>
    )
}
export default Excategory;