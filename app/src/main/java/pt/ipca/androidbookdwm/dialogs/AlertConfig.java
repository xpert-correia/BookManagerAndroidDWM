package pt.ipca.androidbookdwm.dialogs;

public class AlertConfig {

    private String title;

    private String message;

    private String ok;

    public AlertConfig(String title, String message, String ok) {
        this.title = title;
        this.message = message;
        this.ok = ok;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
