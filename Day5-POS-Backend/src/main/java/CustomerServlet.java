import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/api/v1/customer")
public class CustomerServlet extends HttpServlet {
    BasicDataSource ds;
    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        ds = (BasicDataSource) servletContext.getAttribute("datasource");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(req.getReader(), JsonObject.class);
        String id = jsonObject.get("cid").getAsString();
        String name = jsonObject.get("cname").getAsString();
        String address = jsonObject.get("caddress").getAsString();

        try {
            Connection connection=ds.getConnection();
            String query="INSERT INTO customer (id,name,address) VALUES (?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,address);
            int rowInserted=preparedStatement.executeUpdate();
            if(rowInserted>0){
                resp.getWriter().println("Customer Saved Successfully");
            }else {
                resp.getWriter().println("Customer Saved Failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(req.getReader(), JsonObject.class);
        String id = jsonObject.get("cid").getAsString();
        String name = jsonObject.get("cname").getAsString();
        String address = jsonObject.get("caddress").getAsString();

        try {
            Connection connection=ds.getConnection();
            String query="UPDATE customer SET name=?,address=? WHERE id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,address);
            preparedStatement.setString(3,id);
            int rowInserted=preparedStatement.executeUpdate();
            if(rowInserted>0){
                resp.getWriter().println("Customer Updated Successfully");
            }else {
                resp.getWriter().println("Customer Updated Failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do get method invoked");
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("cid");
        try {
            Connection connection=ds.getConnection();
            String query="delete from customer WHERE id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,id);
            int rowInserted=preparedStatement.executeUpdate();
            if(rowInserted>0){
                resp.getWriter().println("Customer Deleted Successfully");
            }else {
                resp.getWriter().println("Customer Deleted Failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
