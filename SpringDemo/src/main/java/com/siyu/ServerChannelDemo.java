package com.siyu;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

@Component
public class ServerChannelDemo {

    public void serverStart() throws IOException {
        Selector selector=Selector.open();
        ServerSocketChannel ssc=ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(2333));
        ssc.register(selector, SelectionKey.OP_ACCEPT);


        while(selector.select()>0){
            Iterator<SelectionKey> it=selector.selectedKeys().iterator();
            while(it.hasNext()){
                SelectionKey key=it.next();
                it.remove();
                if(key.isAcceptable()){
                    System.out.println("Have client connect");
                    SocketChannel channel=((ServerSocketChannel) key.channel()).accept();
                    channel.configureBlocking(false);
                    channel.register(selector,SelectionKey.OP_READ);
                }
                if(key.isReadable()){
                    ByteBuffer buffer=ByteBuffer.allocate(12);
                    SocketChannel channel=(SocketChannel) key.channel();
                    int temp;
                    while((temp = channel.read(buffer)) != -1){
                        System.out.println("\nRead..."+temp);
                        buffer.flip();
                        System.out.print(Charset.forName("UTF-8").newDecoder().decode(buffer).toString());
                        buffer.clear();
                    }


                    System.out.println();
                    channel.close();
                }

            }
        }
    }

}
