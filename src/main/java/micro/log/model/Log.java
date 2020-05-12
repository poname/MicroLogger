package micro.log.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Log implements Serializable {

    @Id
    private String id;

    private String brokerId;

    private BrokerType broker;

    private String referenceId;

    private LogReference reference;

    private LogLevel level;

    private Date date;

    private String message;

    private Object data;

    private LogFunction function;

    public String getId() {
        return id;
    }

    public Log setId(String id) {
        this.id = id;
        return this;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public Log setBrokerId(String brokerId) {
        this.brokerId = brokerId;
        return this;
    }

    public BrokerType getBroker() {
        return broker;
    }

    public Log setBroker(BrokerType broker) {
        this.broker = broker;
        return this;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public Log setReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    public LogReference getReference() {
        return reference;
    }

    public Log setReference(LogReference reference) {
        this.reference = reference;
        return this;
    }

    public LogLevel getLevel() {
        return level;
    }

    public Log setLevel(LogLevel level) {
        this.level = level;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Log setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Log setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Log setData(Object data) {
        this.data = data;
        return this;
    }

    public LogFunction getFunction() {
        return function;
    }

    public Log setFunction(LogFunction function) {
        this.function = function;
        return this;
    }
}
