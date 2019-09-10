package entry;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message {
    @Expose(serialize = false)
    private ArrayList<String> userList=new ArrayList<String>();
    private String content=new String();
    private Gson gson=new Gson();

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<String> userList) {
        this.userList = userList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContent(String name,String content){
        this.content=name+" "+new Date().getTime()+":<br/>";
        this.content+=content+"<br/>";
    }

    public String toJson(){
        return gson.toJson(this);
    }
}
