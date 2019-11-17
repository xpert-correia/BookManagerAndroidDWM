package pt.ipca.androidbookdwm.dialogs;

public class ConfirmConfig {

    private String title;

    private String message;

    private String ok;

    private String cancel;

    public ConfirmConfig(String title, String message, String ok, String cancel) {
        this.title = title;
        this.message = message;
        this.ok = ok;
        this.cancel = cancel;
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

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }
}
