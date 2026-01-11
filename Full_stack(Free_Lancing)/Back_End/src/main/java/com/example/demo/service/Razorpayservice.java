    package com.example.demo.service;

    import com.example.demo.entity.Orders;
    import com.example.demo.io.Orderresp;
    import com.example.demo.io.Razorpayresp;
    import com.example.demo.io.paymentdetails;
    import com.example.demo.io.paymentverifyreq;
    import com.example.demo.repo.orderrepo;
    import com.razorpay.Order;
    import com.razorpay.RazorpayClient;
    import com.razorpay.RazorpayException;
    import org.json.JSONObject;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Service;

    @Service
    public class Razorpayservice {
        @Value("${razorpay.key.id}")
        String Rkeyid;
        @Value("${razorpay.key.secret}")
        String Rkeysecret;
        @Autowired
        orderrepo Repo;
        @Autowired
        orderservice oserv;
       public  Razorpayresp createOrder(double amount,String currency) throws RazorpayException {
           RazorpayClient rpay=new RazorpayClient(Rkeyid,Rkeysecret);
           JSONObject req=new JSONObject();
           req.put("amount",(int)amount*100);
           req.put("currency",currency);
           req.put("receipt","order_recpid"+System.currentTimeMillis());
           req.put("payment_capture",1);
           Order order=rpay.orders.create(req);
           return convertToresp(order);
       }

        private Razorpayresp convertToresp(Order order) {
           return Razorpayresp.builder()
                   .id(order.get("id"))
                   .entity(order.get("entity"))
                   .amount(order.get("amount"))
                   .currency(order.get("currency"))
                   .status(order.get("status"))
                   .create_At((java.util.Date) order.get("created_at"))
                   .receipt(order.get("receipt"))
                   .build();
        }

        public Orderresp verify(paymentverifyreq req) {

            Orders en = Repo.findByOrderid(req.getOrderid())
                    .orElseThrow(() -> new RuntimeException("cant find"));

            if (!verifysignature(
                    req.getRazorpayorderid(),
                    req.getRazorpaypaymentmethod(),
                    req.getRazorpaysignature())) {
                throw new RuntimeException("Unauthorized");
            }

            paymentdetails pay = en.getDetails();
            if (pay == null) {
                pay = new paymentdetails();
            }

            pay.setRazorpayorderid(req.getRazorpayorderid());
            pay.setRazorpaypaymentmethod(req.getRazorpaypaymentmethod());
            pay.setRazorpaysignature(req.getRazorpaysignature());

            en.setDetails(pay);
            Orders or = Repo.save(en);

            return oserv.convertToorderresp(or);
        }


        private boolean verifysignature(String razorpayorderid, String razorpaypaymentmethod, String razorpaysignature) {
           return true;
        }
    }
