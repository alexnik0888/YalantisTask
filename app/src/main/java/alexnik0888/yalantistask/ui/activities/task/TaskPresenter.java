package alexnik0888.yalantistask.ui.activities.task;


import java.util.List;


/**
 * Contract for the Task presenter.
 */
public interface TaskPresenter {
    void onDestroy();
    List<String> getUrls();
    String getDeadline();
    String getCreated();
    String getRegistered();
    String getTitle();
    String getDescription();
    String getResponsible();
    String getHead();

}
