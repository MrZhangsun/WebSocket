package site.zhangsun.websocket.v2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import site.zhangsun.websocket.v2.handler.MyWebSocketHandler;

import java.io.IOException;
import java.util.List;

/**
 * Functions: Web Socket Trigger.
 *
 * @author Murphy Zhang Sun
 * @date 2019-08-01 09:56
 * @since v4.0.1
 */
@RestController
public class WebSocketTrigger {

    @GetMapping("/v2/trigger/{id}")
    public String trigger(@PathVariable("id") String id) throws IOException {
        List<WebSocketSession> sessions = MyWebSocketHandler.getSessions();
        System.out.println(sessions);
        for (int i = 0; i < sessions.size(); i++) {
            WebSocketMessage<String> webSocketMessage = new TextMessage("Hello World:" + i);
            sessions.get(i).sendMessage(webSocketMessage);
        }
        return "OK:" + id;
    }

}
