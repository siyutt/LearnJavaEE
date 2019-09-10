import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;

public class imgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage image=new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D=(Graphics2D)image.getGraphics();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, 80, 20);
        graphics2D.setFont(new Font(null,Font.BOLD,20));
        graphics2D.setColor(Color.BLACK);
        String num=randomNum();
        graphics2D.drawString(num,0,20);

        req.getSession().setAttribute("randomNum",num);

        resp.setHeader("Expires", "-1");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");

        resp.setHeader("Content-type", "image/jpeg");

        ImageIO.write(image,"jpg",resp.getOutputStream());

    }

    private String randomNum(){
        //100000~999999
        int num=0;
        num+=new Random().nextInt(9999);

        StringBuffer str=new StringBuffer(Integer.toString(num));
        while(str.length()<4){
            str.insert(0,'0');
        }

        return str.toString();
    }

}
