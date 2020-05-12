package micro.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import micro.log.model.Log;
import micro.log.model.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LogMessageListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final LogService logService;

    @Autowired
    public LogMessageListener(LogService logService) {
        this.logService = logService;
    }

    @RabbitListener(queues = "${log.queue}")
    public void handleMessage(final Message message) {
        try {
            Log log = new ObjectMapper().readValue(message.getBody(), Log.class);
            logService.createLog(log);
        } catch (IOException e) {
            logger.error("LogMessageListener, handleMessage, message: {}, error: {}", message.toString(), e.getMessage());
        }
    }

}
