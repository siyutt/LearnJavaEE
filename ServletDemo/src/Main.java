
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        String user_randomNum=req.getParameter("randomNum");
        String server_randomNum=(String)req.getSession().getAttribute("randomNum");
        if(user_randomNum==null||server_randomNum==null||
        !user_randomNum.equals(server_randomNum)){
            resp.getOutputStream().write("Temp is wrong".getBytes());
            return;
        }
        String name=req.getParameter("id");
        String passwd=req.getParameter("passwd");

        if(name.equals("siyu")&&passwd.equals("111")){
            resp.getOutputStream().write("Login Success".getBytes());
            return;
        }

        resp.getOutputStream().write("Login False".getBytes());
        return;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
