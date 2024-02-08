package MQproject.server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MQproject.server.Interface.ServerService;
import MQproject.server.model.message.ServerProducerMessage;

@RestController
@RequestMapping("/api/server-producer")
public class ServerProducerController {
    @Autowired
    private ServerService serverService;

    @PostMapping(value = "/handle-production", consumes = "application/json")
    public ResponseEntity<Object> handleProduction(@RequestBody ServerProducerMessage message) {
        try {
            ServerProducerMessage responseMessage = serverService.handleProduction(message);
            return ResponseEntity.ok(responseMessage);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            ResponseEntity.status(500).body(errorMessage);
        }
        // not reachable
        return null;
    }
}