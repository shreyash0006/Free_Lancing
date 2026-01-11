import { useContext, useEffect, useState } from "react";
import "./cartsum.css"
import { cartitem } from "../../../../APIs_AND_Context/context";
import { createorder, crorrazor, delorder, verify } from "../../../../APIs_AND_Context/api";
import { toast } from "react-toastify";
import Receipt from "../../../../Receipt/receipt";
const Cartsum=()=>{
    const [price,setprice]=useState(0);
    const [tax,settax]=useState(0);
    const [total,settotal]=useState(0);
    const [details,setdetails]=useState({});
    const [show,setshow]=useState(false);
    const cntxt=useContext(cartitem);
    useEffect(()=>{
        let t=0;
       cntxt.items && cntxt.items.map((d)=>{
             t=d.price*d.qty+t;
        })
         setprice(t);
         settax((1/100)*t);
         settotal(t+(1/100)*t);
    },[cntxt?.items])
    useEffect(()=>{
        console.log(details);
    },[details])
    const loadrazorpayscript=()=>{
      return new Promise((resolve,reject)=>{
          const script=document.createElement("script");
        script.src="https://checkout.razorpay.com/v1/checkout.js";
        script.onload=()=> resolve(true);
        script.onerror=()=> resolve(false);
        document.body.appendChild(script);
      })
    }
    const deleteorder=async(id)=>{
        try{
            await delorder(id);
            toast.success("order deleted successfully");
        }
        catch(e)
        {
            console.log(e);
            toast.error("Unable to delete Order");
        }
    }

   const verifyPayment = async (response, resp) => {
    if (!response || !resp) {
        toast.error("failed");
        return;
    }

    const payment = {
        razorpayorderid: response.razorpay_order_id,
        razorpaysignature: response.razorpay_signature,
        razorpaypaymentmethod: response.razorpay_payment_id,
        orderid: resp.data.orderid 

    };

     console.log(resp.data.orderid+"dragon")
    try {
        const razorresp = await verify(payment);  
        setdetails(razorresp.data);
        console.log(details);
        toast.success("Payment verified & saved");
    } catch (e) {
        console.log(e);
        toast.error("failed UPI payment");
    }
};


    const paymentmethod=async(mode)=>{
        if(!(cntxt?.obj?.name) || !(cntxt?.obj?.phone)  || !mode)
        {
            toast.error("please add the customer details");
            return
        }
        if(cntxt?.obj?.phone.length<10 || cntxt?.obj?.phone.length>10)
        {
            toast.error("Invalid Phone Number");return;
        }
        if(cntxt.items.length==0)
        {
            toast.success("please add the cartitems !");
            return;
        }

        const data={
           "cartitems":cntxt.items,
           phone_number:cntxt.obj.phone,
           customername:cntxt.obj.name,
           total,subtotal:price,
           tax,
           "paymentmethod":mode.toUpperCase()
        }
       try{
         const resp=await createorder(data);
        if(resp.status==200 && mode=="cash")
        {
            toast.success("cash successfull received");
            setdetails(resp.data);
            return;
        }
        else if(resp.status==200 && mode=="UPI")
        {
            const razorload= await loadrazorpayscript();
            if(!razorload)
            {
                toast.error("UPI Failed");
                await deleteorder(resp.data.orderid);
                return;
            }
            const razorpayresp=await crorrazor({amount:total,currency:"INR"});
            const options  ={
                key:"rzp_test_RohDJUYjaLMzpS",
                amount:razorpayresp.data.amount,
                currency:razorpayresp.data.currency,
                order_id:razorpayresp.data.id,
                name:"Billing ",
                description:"Order payment",
                handler:async function(response){
                    verifyPayment(response,resp);
                },
                prefill:{
                    name:cntxt.obj.name,
                    contact:cntxt.obj.phone
                },
                theme:{
                    color:"#3399cc"
                },
                modal:{
                    ondismiss:async()=>{
                        deleteorder(resp.data.orderid)
                        toast.error("payment failed");
                    }
                }
            }
             const rzp=new window.Razorpay(options);
             rzp.on("payment failed",async()=>{
                deleteorder(resp.data.orderid);
                return;
             })
             rzp.open();
        }
       
       }
       catch(e)
       {
        console.log(e);
        toast.error("payment cancelled");
       }
    }

    const placeorder=()=>{
        if(!details)
        {
            toast.success("please pay");
            return;
        }
        cntxt.obj.setname("")
        cntxt.obj.setphone("")
        cntxt.setitems([]);
        setshow(true);
        // window.print();
    }
    return(
        <div className="flexout">
            <div className="flex">
                <span>item:</span>
                <span>₹{price}</span>
            </div>
            <div className="flex">
                <span>Tax(1%):</span>
                <span>₹{Math.round(tax*100.0)/100.0}</span>
            </div>
            <div className="flex">
                <span>Total:</span>
                <span>₹{Math.round(total*100.0)/100.0}</span>
            </div>
            <div className="flex">
                <button className="cash" onClick={()=>paymentmethod("cash")}>cash</button>
                <button className="upi"  onClick={()=>paymentmethod("UPI")}>UPI</button>
            </div>
            <button className="place" onClick={()=>placeorder()}>Place Order</button>
            {
                show && <Receipt value={{show,setshow,details,setdetails}}/>
            }
        </div>
      
    )
}
export default Cartsum;