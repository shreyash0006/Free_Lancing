import { createContext, useEffect, useState } from "react";
import { getcat, getitem, getuser } from "./api";

export const AppContext=createContext(null);
export const Prov=(prop)=>
    {
    const [cat,setcat]=useState();
    useEffect(()=>{
        const load=async()=>{
        const res= await getcat();
        setcat(res.data);  
        }
        load();
    },[])
   
    const obj={
        cat,setcat
    }
    return <AppContext.Provider value={{obj}}>
        {prop.children}
    </AppContext.Provider>
}
export const Usercontext=createContext(null);
 const Userprov=(prop)=>
    {
    const [user,setuser]=useState();
    useEffect(()=>{
        const load=async()=>{
        const res= await getuser();
        setuser(res.data);  
        console.log(res.data); 
        }
        load();
    },[])
   
    const obj={
        user,setuser
    }
    return <Usercontext.Provider value={{obj}}>
        {prop.children}
    </Usercontext.Provider>
}
export default Userprov;


export const Itemcontext=createContext(null);
export const Itemprov=(prop)=>
    {
    const [item,setitem]=useState([]);
    useEffect(()=>{
        const load=async()=>{
        const res= await getitem();
        setitem(res.data);  
        console.log(res.data); 
        }
        load();
    },[])
   
    const obj={
        item,setitem
    }
    return <Itemcontext.Provider value={{obj}}>
        {prop.children}
    </Itemcontext.Provider>
}


export const Explorecntxt=createContext();
 export const ExploreContext=(prop)=>{
    const [partcat,setpartcat]=useState([]);
    return <Explorecntxt.Provider value={{partcat,setpartcat}}>
        {prop.children}
    </Explorecntxt.Provider>
}


//reltion between displayitems and the cartitem and customerform
export const cartitem=createContext();
export const CartItem=(prop)=>{
    const [items,setitems]=useState([]);
    const [name,setname]=useState();
    const [phone,setphone]=useState();
    const obj={
        name,setname,phone,setphone
    }
    return (
        <cartitem.Provider value={{items,setitems,obj}}>
            {prop.children}
        </cartitem.Provider>
    )
}
