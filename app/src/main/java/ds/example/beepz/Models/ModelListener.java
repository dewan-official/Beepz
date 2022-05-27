package ds.example.beepz.Models;

public interface ModelListener {
    void onSuccess(Services cart);
    void onStart();
    void onFailure(String msg);
}
