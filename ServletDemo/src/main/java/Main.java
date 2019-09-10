
import org.apache.catalina.Session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user_randomNum=req.getParameter("randomNum");
        String server_randomNum=(String)req.getSession().getAttribute("randomNum");
        String name=req.getParameter("username");


        System.out.println(name);

//        if(user_randomNum==null||server_randomNum==null||
//        !user_randomNum.equals(server_randomNum)){
//            resp.getOutputStream().write("Number is wrong".getBytes());
//            return;
//        }

        HttpSession session=req.getSession();

//        if(session.getAttribute("username")!=null){
//            resp.getOutputStream().write("User name is already exist!".getBytes());
//            return ;
//        }

        req.getSession().setAttribute("username",name);
//        resp.sendRedirect("/ChatRoom.html?username="+name);
//        OutputStream os=resp.getOutputStream();
//        String script="<script type=\"text/javascript\">var username="+name+"</script>";
//        os.write(script.getBytes());

        resp.sendRedirect("/ChatRoom.html");

        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
