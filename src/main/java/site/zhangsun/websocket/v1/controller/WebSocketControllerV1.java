package site.zhangsun.websocket.v1.controller;

import org.springframework.stereotype.Controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Functions: Web Socket Controller.
 *
 * @author Murphy Zhang Sun
 * @date 2019-07-31 18:08
 * @since v4.0.1
 */
@Controller
@ServerEndpoint("/ws/w1/{message}")
public class WebSocketControllerV1 {

    private static List<Session> sessions = new ArrayList<>();

    @OnOpen
    public void onOpen(@PathParam("message") String message, Session session) {
        System.out.println(message);
        System.out.println("on open");
        sessions.add(session);
    }

    @OnClose
    public void onClose(@PathParam("message") String message, Session session) {
        System.out.println(message);
        System.out.println("on close");
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println(message);
        System.out.println("on message");
    }

    public static List<Session> getSessions() {
        return sessions;
    }
}
