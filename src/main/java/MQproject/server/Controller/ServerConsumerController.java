package MQproject.server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MQproject.server.Interface.ServerService;
import MQproject.server.model.message.ServerConsumerMessage;

@RestController
@RequestMapping("/api/server-consumer")
public class ServerConsumerController {
    @Autowired
    private ServerService serverService;

    @PostMapping(value = "/handle-subscription", consumes = "application/json")
    public ResponseEntity<Object> handleSubscription(@RequestBody ServerConsumerMessage message) {
        try {
            ServerConsumerMessage responseMessage = serverService.handleSubscription(message);
            return ResponseEntity.ok(responseMessage);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            ResponseEntity.status(500).body(errorMessage);
        }
        // not reachable
        return null;
    }


}