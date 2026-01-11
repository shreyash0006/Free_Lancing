import React, { useContext, useEffect, useState } from "react";
import "./display.css"
import { getitem } from "../../../../APIs_AND_Context/api";
import { cartitem, Explorecntxt } from "../../../../APIs_AND_Context/context";
import { toast } from "react-toastify";
const Cart=()=>{
    const [items,setitems]=useState([]);
    const cntxt=useContext(Explorecntxt);
    const cartcntxt=useContext(cartitem);
    useEffect(()=>{
        const ge= async()=>{
            const res=(await getitem()).data;
            if(cntxt.partcat.length!=0)
                setitems(cntxt.partcat);
            else
            setitems(res);
        console.log(cntxt.partcat);
        }
        ge();
        
    },[cntxt?.partcat])
    const call=(data)=>{
        const d=cartcntxt.items.some((d)=>d.itemid==data.itemid); 
        if(!d)
            cartcntxt.setitems(prev => [...prev, {...data, qty: 1 }]);

        else
            toast.success("item already in the cart");
    }
    return(
        <div className="itemsout">
            {
                items && items.map((data)=>(
                    <div className="item" onClick={()=>call(data)}>
                        <img src={data.imgurl} alt="error" />
                        <div>
                            <h3>{data.categoryname}</h3>
                            <p>price:₹{data.price}</p>
                        </div>
                    </div>
                ))
            }
        </div>
    )
}
export default Cart;