import { useEffect, useState } from "react";
import { dashboard } from "../../APIs_AND_Context/api";
import "./dashboard.css"
const Dash=()=>{
    const [data,setdata]=useState();
    useEffect(()=>{
        const call=async()=>{
            const resp=await dashboard();
            setdata(resp.data);
        }
        call();
    },[])
    return (
        <div className="dash">
           <div className="whole">
                <div className="sales">
                    <button className="dashbtn">₹</button> 
                    <div>
                        <p>Today's sales</p>
                        <h2>₹{data?.todaysales!=null ?Number(data.todaysales).toFixed(2) : "0.0"}</h2>
                    </div> 
                </div>
                <div className="count">
                    <span className="cartpng">🛒</span>
                   <div>
                     <p>Today's Order</p>
                    <h2>{data?.todaycount!=null?Number(data.todaycount).toFixed(2):"0"}</h2>
                   </div>
                </div>
           </div>
            <div className="recent">
            <h1><u>Recent Order's</u></h1>
            <table className="tab">
                <thead>
                    <th>OrderId</th>
                    <th>Customer</th>
                    <th>Contact</th>
                    <th>Amount</th>
                    <th>Payment</th>
                    <th>Date</th>
                </thead>
                <tbody>
                    {
                        data && data.orders.map((d)=>(
                            <tr className="recrow">
                                <td>{d.orderid.substring(0,10)}...</td>
                                <td>{d.customername}</td>
                                <td>{d.phone_number}</td>
                                <td>{Number(d.total).toFixed(2)}</td>
                                <td>{d.paymentmethod}</td>
                                <td>{d.time}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
           </div>
        </div>
    )
}
export default Dash;