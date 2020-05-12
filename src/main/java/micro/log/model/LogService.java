package micro.log.model;

import java.util.List;

public interface LogService {
    void createLog(Log log);

    List<Log> getLogs();
}
