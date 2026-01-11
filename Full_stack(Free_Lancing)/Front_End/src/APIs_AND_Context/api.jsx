    import axios from "axios";

    //category API
    const caturl="http://localhost:8080/category/admin/categories";
    export const getcat=async ()=>{return await axios.get(caturl,{headers:{'Authorization':`Bearer ${localStorage.getItem("token")}`}});}
    export const del=async (id)=>{await axios.delete(`${caturl}/${id}`,{headers:{'Authorization':`Bearer ${localStorage.getItem("token")}`}});}
    export const post=async (category)=> { return await axios.post(caturl,category,{headers:{'Authorization':`Bearer ${localStorage.getItem("token")}`}});}
   
    //items API
    const itemurl="http://localhost:8080/items";
    export const getitem=async()=>{return await axios.get(itemurl+"/getitems",{headers:{'Authorization':`Bearer ${localStorage.getItem("token")}`}});}
    export const delitem=async(itemid)=>{ await axios.delete(itemurl+"/admin/deleteitem/"+`${itemid}`,{headers:{'Authorization':`Bearer ${localStorage.getItem("token")}`}})}
    export const additem=async(item)=>{return await axios.post(itemurl+"/admin/additem",item,{headers:{'Authorization':`Bearer ${localStorage.getItem("token")}`}});}
    export const getcount=async(catid)=>{return await axios.get(itemurl+"/admin/itemnumbers/"+`${catid}`,{headers:{"Authorization":`Bearer ${localStorage.getItem("token")}`}})}
    export const getitemofcat=async(id)=>{return await axios.get(itemurl+"/admin/partitem/"+`${id}`,{headers:{"Authorization":`Bearer ${localStorage.getItem("token")}`}})}
    export const getsingleitem=async(id)=>{return await axios.get(itemurl+"/admin/singleitem/"+`${id}`,{headers:{'Authorization':`Bearer${localStorage.getItem("token")}`}})}
    //User API
    const userurl="http://localhost:8080/admin";
    export const getuser=async()=>{return await axios.get(userurl+"/users",{headers:{'Authorization':`Bearer ${localStorage.getItem("token")}`}});}
    export const adduser=async(user)=>{return await axios.post(userurl+"/register",user,{headers:{'Authorization':`Bearer ${localStorage.getItem("token")}`}});}
    export const deluser=async(id)=>{await axios.delete(userurl+`/delete/${id}`,{headers:{'Authorization':`Bearer ${localStorage.getItem("token")}`}})}

    //login API || Authentication API
    const loginurl="http://localhost:8080/access/login";
    export const login=async(data)=>{return await axios.post(loginurl,data);}

    //Explore API'S

    //Order API
    const orderurl="http://localhost:8080/orders";
    export const createorder=async(order)=>{return await axios.post(orderurl,order,{headers:{'Authorization':`Bearer ${localStorage.getItem("token")}`}});}
    export const delorder=async(id)=>{await axios.delete(orderurl+`/${id}`,{headers:{"Authorization":`Bearer ${localStorage.getItem("token")}`}});}
    export const getorders=async()=>{return await axios.get(orderurl,{headers:{"Authorization":`Bearer ${localStorage.getItem("token")}`}});}

    //Razorpay API
    const Razorpayurl="http://localhost:8080/payment";
    export const crorrazor=async(obj)=>{return await axios.post(Razorpayurl,obj,{headers:{'Authorization': `Bearer ${localStorage.getItem("token")}`}});}
    export const verify=async(obj2)=>{return await axios.post(Razorpayurl+"/verify",obj2,{headers:{"Authorization":`Bearer ${localStorage.getItem("token")}`}});}

    //DASHBOARD API
    const dashboardurl="http://localhost:8080/dashboard";
    export const dashboard=async()=>{return await axios.get(dashboardurl,{headers:{"Authorization":`Bearer ${localStorage.getItem("token")}`}})}