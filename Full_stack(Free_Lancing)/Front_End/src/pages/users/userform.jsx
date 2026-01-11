import {  useContext, useState } from "react";
import { adduser } from "../../APIs_AND_Context/api";
import { toast } from "react-toastify";
import  { Usercontext } from "../../APIs_AND_Context/context";

const Userform = () => {
  const [loading, setLoading] = useState(false);
  let [name, setName] = useState("");
  let [email, setEmail] = useState("");
  let [password, setPassword] = useState("");
  const context=useContext(Usercontext);
  const submitAll = async (e) => {
    e.preventDefault();
    const data = { name, email, password, role: "ROLE_ADMIN" };
    setLoading(true);
    try {
      const res = await adduser(data);
      if (res.status === 200 || res.status === 201) {
        toast.success("User successfully added");
       setEmail("");setName("");setPassword("");
        context.obj.setuser((pre)=>[...pre,res.data]);
      }
    } catch (err) {
      toast.error("Unable to add user");
      
      console.error("Error:", err);
    } finally {
      setLoading(false);
    }
     name="";password="";email="";
  };

  return (
    <div className="card">
      <div className="card-body">
        <form onSubmit={submitAll}>
          <div className="mb-3">
            <label htmlFor="name" className="form-label">
              Name
            </label>
            <input
              id="name"
              type="text"
              placeholder="shreyash.."
              className="form-control"
              required
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </div>

          <div className="mb-3">
            <label htmlFor="email" className="form-label">
              Email
            </label>
            <input
              id="email"
              placeholder="example@gmail.com"
              className="form-control"
              type="email"
              required
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>

          <div className="mb-3">
            <label className="form-label" htmlFor="pass">
              Password
            </label>
            <input
              type="password"
              id="pass"
              className="form-control"
              required
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>

          <button className="btn btn-primary w-100" type="submit" disabled={loading}>
            {loading ? "Saving..." : "Save"}
          </button>
        </form>
      </div>
    </div>
  );
};

export default Userform;
