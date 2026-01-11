import { useContext } from "react";
import { cartitem } from "../../../../APIs_AND_Context/context";
import "./cartitems.css";

const Cartitems = () => {
  const cntxt = useContext(cartitem);
  const { items, setitems } = cntxt;

  const removeItem = (id) => {
    setitems(prev => prev.filter(d => d.itemid !== id));
  };

  const increaseQty = (id) => {
    setitems(prev =>
      prev.map(d =>
        d.itemid === id
          ? { ...d, qty: (d.qty || 1) + 1 }
          : d
      )
    );
  };

  const decreaseQty = (id) => {
    setitems(prev =>
      prev.map(d =>
        d.itemid === id && (d.qty || 1) > 1
          ? { ...d, qty: (d.qty || 1) - 1 }
          : d
      )
    );
  };

  return (
    <div className="cartsiuu">
      <h3><u>Cart items</u></h3>

      {items && items.map((d) => (
        <div className="out" key={d.itemid}>
          <div className="c1">
              
            <img src={d.imgurl} />
            <span style={{marginLeft:"20px"}}>item =  {d.name}</span>
            <div className="hack">
              <button className="cartbtn" style={{backgroundColor:"blue",color:"white"}} onClick={() => decreaseQty(d.itemid)}>-</button>
              <span>{d.qty || 1}</span>
              <button className="cartbtn" style={{backgroundColor:"red"}} onClick={() => increaseQty(d.itemid)}>+</button>
            </div>
          </div>

          <div className="c2">
          
            <button className="X" onClick={() => removeItem(d.itemid)}>X</button>

            <h4>price : ₹{d.price * (d.qty || 1)}</h4>
          </div>
        </div>
      ))}
    </div>
  );
};

export default Cartitems;
