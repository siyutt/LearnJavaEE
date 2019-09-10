package Service;

import entry.ChatRoomBean;
import entry.Message;
import entry.UserBean;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.*;
import java.io.IOException;
import java.util.*;

import com.google.gson.*;
import entry.UserContent;

@ServerEndpoint("/WepSocket")
public class MainService {
    private String username;
    private List<Session> sessionsList=new LinkedList<Session>();
    private Map<String,Session> userMap=new HashMap<String, Session>();
    private ArrayList<String> userList=new ArrayList<String>();
    private Gson gson=new Gson();

    @OnOpen
    public void open(Session session){
        String name=session.getRequestParameterMap().get("username").get(0);
        System.out.println("add user:"+name);
        username=name;
        sessionsList.add(session);
        userMap.put(name,session);
        userList.add(name);

        String text=this.username+"enter this room";
        Message msg=new Message();
        msg.setContent("Room",text);
        msg.setUserList(this.userList);
        this.broadcat(this.sessionsList,msg.toJson());
    }

    @OnClose
    public void close(Session session){
        sessionsList.remove(session);
        userList.remove(userMap.get(session));
        userMap.remove(username);
    }

    @OnMessage
    public void messge(Session session,String json){
        UserContent content=gson.fromJson(json,UserContent.class);
        System.out.println(this.username+" send a message");
        Message msg=new Message();
        if(content.getType()==1){
            msg.setContent(this.username,content.getMessge());
            msg.setUserList(this.userList);
            this.broadcat(sessionsList,msg.toJson());
        }
        else{
            String[] to=content.getTo().split(",");
            for(String user:to){
                Session toSession=userMap.get(user);
                if(toSession==null)
                    continue;
                try {
                    toSession.getBasicRemote().sendText(msg.toJson());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void broadcat(List<Session> list,String msg){
        for(Session session:list){
            try{
                session.getBasicRemote().sendText(msg);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
