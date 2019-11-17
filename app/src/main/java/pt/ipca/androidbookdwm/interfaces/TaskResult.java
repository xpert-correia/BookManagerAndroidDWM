package pt.ipca.androidbookdwm.interfaces;

public interface TaskResult<T> {

    void onStart();

    void onResult(T success);
}
