package site.zhangsun.websocket.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import java.io.IOException;
import java.util.List;

/**
 * Functions: Message Trigger Rest API
 *
 * @author Murphy Zhang Sun
 * @date 2019-07-31 18:52
 * @since v4.0.1
 */
@RestController
public class MessageTrigger {

    @GetMapping("/trigger/{id}")
    public String trigger(@PathVariable("id") String id) throws IOException {
        List<Session> sessions = WebSocketControllerV1.getSessions();
        System.out.println(sessions);
        for (int i = 0; i < sessions.size(); i++) {
            sessions.get(i).getBasicRemote().sendText("received: " + i);
        }
        return "OK: " + id;
    }
}
