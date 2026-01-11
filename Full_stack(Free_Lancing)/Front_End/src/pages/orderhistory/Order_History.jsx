import { useEffect, useState } from "react";
import { delorder, getorders } from "../../APIs_AND_Context/api";
import "../styleforpages/pages.css"
import "./order.css"
const OrderH=()=>{
    const [orders,setorders]=useState();
    useEffect(()=>{
        const call=async()=>{
            const resp=await getorders();
            setorders(resp.data);
        }
         call();
    
    }
    ,[])
    const del=(id)=>{
       delorder(id);
       setorders(prev=>prev.filter((d)=>d.orderid!=id)); 
    }
    return(
     <div className="hist">
          <div className="hist1">
            <table className="table">
            
        <thead className="fixed">
            <tr>
                <th>OrderID</th>
                <th>Customer_Name</th>
                <th>Phone_number</th>
                <th>Payment_Method</th>
                <th>Date</th>
                <th>total</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            {
                orders && orders.map((d)=>(
                    <tr className="rowtr">
                        <td>{d.orderid}</td>
                        <td>{d.customername}</td>
                        <td>{d.phone_number}</td>
                        <td>{d.paymentmethod}</td>
                        <td>{d.time}</td>
                        <td>₹{d.total}</td>
                        <td><button className="XX" onClick={()=>del(d.orderid)}>X</button></td>
                    </tr>
                ))
            }
        </tbody>
       </table>
          </div>
     </div>
    )
}
export default OrderH;