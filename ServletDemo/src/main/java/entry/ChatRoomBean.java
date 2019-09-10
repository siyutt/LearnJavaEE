package entry;

import entry.UserBean;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatRoomBean {
    private LinkedList<UserBean> userlist;
    private AtomicInteger size;
    private String owner;
    private String roomNum;

    public ChatRoomBean(String owner,String roomNum){
        this.owner=owner;
        this.roomNum=roomNum;
        size=new AtomicInteger();
    }

    public LinkedList<UserBean> getUserlist() {
        return userlist;
    }

    public int getSize() {
        return size.get();
    }

    private void setSize(int size) {
        this.size.set(size);
    }

    public String getOwner() {
        return owner;
    }

    private void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRoomNum() {
        return roomNum;
    }

    private void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public void addUser(UserBean user){

    }
}
