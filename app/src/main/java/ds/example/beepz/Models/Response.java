package ds.example.beepz.Models;

public class Response {
    private Services data;
    private String message;
    private int code;
    private boolean isSuccess;

    public Response() {
    }

    public Response(Services data, String message, int code, boolean isSuccess) {
        this.data = data;
        this.message = message;
        this.code = code;
        this.isSuccess = isSuccess;
    }

    public Services getData() {
        return data;
    }

    public void setData(Services data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
