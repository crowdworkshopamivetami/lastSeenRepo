package lastSeen.rest.services.result;
import java.io.Serializable;
/**
 * Created by kabessa on 17/11/2015.
 */

public class RestResult<T> implements Serializable{

    private boolean success;
    private String  message;
    private T  data;

    public RestResult() {}

    public RestResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public RestResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
