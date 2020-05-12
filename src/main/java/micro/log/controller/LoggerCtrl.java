package micro.log.controller;

import micro.log.model.Log;
import micro.log.model.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/log")
public class LoggerCtrl {

    private final LogService logService;

    @Autowired
    public LoggerCtrl(LogService logService) {
        this.logService = logService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public CompletableFuture<List<Log>> getAllLogs() {
        return CompletableFuture.supplyAsync(logService::getLogs);
    }

}
