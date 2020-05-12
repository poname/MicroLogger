package micro.log.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void createLog(Log log) {
        log.setId(UUID.randomUUID().toString());
        logRepository.insert(log);
    }

    @Override
    public List<Log> getLogs() {
        return logRepository.findAll();
    }

}
