import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    List<Customer> customerList=new ArrayList<Customer>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String address=req.getParameter("address");
        System.out.println(id+name+address);
        customerList.add(new Customer(id,name,address));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(Customer c:customerList){
            System.out.println(
                    "CID :"+c.getId()
                    +"CName :"+ c.getName()
                    +"CAddress :"+c.getAddress()
            );
        }
    }

}