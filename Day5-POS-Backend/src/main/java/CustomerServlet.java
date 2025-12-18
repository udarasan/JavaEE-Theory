import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/v1/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(req.getReader(), JsonObject.class);
        String id = jsonObject.get("cid").getAsString();
        String name = jsonObject.get("cname").getAsString();
        String address = jsonObject.get("caddress").getAsString();
        System.out.println(id+name+address);


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do put method invoked");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do get method invoked");
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do delete method invoked");
    }
    //what is cors ?
    //cors origin resource sharing is a mechanism that allows a server to tell browser
    //"this origin is allowed to access my resources"

    // WHY CORS? - To protect users
    // WHAT? - Browser Security rule
    // How? - Sever sends permission headers
    // Where? - Happens only in browsers
    // Fix? - Add CORS headers

}
