package com.iflytek.webapi.igrpool;

import com.iflytek.webapi.utils.JsonUtil;
import com.iflytek.webapi.wspool.IResponse;
import com.iflytek.webapi.wspool.URIBuilder;
import com.iflytek.webapi.wspool.WsConnection;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class IgrWsConnection extends WsConnection implements Runnable{

    public IgrWsConnection(URI serverUri) {
        super(serverUri);
    }
    public IgrWsConnection(String url, URIBuilder builder){
        super(url, builder);
    }
    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("success open websocket connection");
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("close=>"+i+s+b);
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }

    @Override
    protected void onException(Exception e) {
        e.printStackTrace();
    }

    @Override
    public IResponse decode(String s) {
        return  JsonUtil.fromJson(s,IgrResonse.class );
    }


}
