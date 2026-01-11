import "./Receipt.css"
const Receipt=(prop)=>{
    const ord=prop.value.details;
    return(
       <div className="R_outer">
         <div className="R_inner">
            <h1 style={{textAlign:"center"}}>Order Receipt</h1>
            <h3>Order ID:</h3>
            <span>{ord.orderid}</span>
            <br></br>
           <div className="flex"> <h3>Name :</h3><span>{ord.customername}</span></div>
            <div className="flex"><h3>Contact Number :</h3><span>{ord.phone_number}</span></div>
            <hr />
            <h2><u>Items Ordered</u></h2>
            <div className="items">
                {
                ord && ord.cartitems.map((d)=>(
                    <div className="flex">
                        <h4>{d.name}:</h4>
                        <h4>{d.price}</h4>
                    </div>
                ))
            }
            </div>
            <hr></hr>
            
               <div>
                <div className="money">
                    <span>subtotal:</span>
                    <span>₹{ord.subtotal}</span>
                </div>
                <div className="money">
                    <span>Tax(1%):</span>
                    <span>₹{ord.tax}</span>
                </div>
                <div className="money">
                    <span>GrandTotal:</span>
                    <span>₹{ord.total}</span>
                </div>
                <div className="money">
                    <h4>Payment Method</h4><h4>:{ord.paymentmethod}</h4>
                </div>
                {ord.paymentmethod=="UPI"?<><strong>Razorpay OrderID :</strong>{ord.paymentdetails.razorpayorderid}<br></br>
                <strong>Razorpay Payment ID :</strong>{ord.paymentdetails.razorpaypaymentmethod}</>:<></>}
               </div>
            
            <div className="btn">
                <button className="green" onClick={()=>{window.print();prop.value.setshow(false);;prop.value.setdetails({})}}>Print</button>
                <button className="red" onClick={()=>{prop.value.setshow(false);prop.value.setdetails({})}}>Cancel</button>
            </div>
        </div>
       </div>
    )
}
export default Receipt;