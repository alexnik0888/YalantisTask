package alexnik0888.yalantistask.ui.activities.task;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import alexnik0888.yalantistask.R;
import alexnik0888.yalantistask.data.DbManager;
import alexnik0888.yalantistask.model.File;
import alexnik0888.yalantistask.model.Task;
import alexnik0888.yalantistask.utils.DateHelper;

/**
 * Presenter for the Task. Implements methods for getting data from db.
 */
public class TaskPresenterImpl implements TaskPresenter{
    private TaskView mTaskView;
    private Context mContext;
    private Task mTask;

    public TaskPresenterImpl(Context context, int id) {
        this.mTaskView = (TaskView)context;
        mContext = context;
        mTask = new DbManager().getTask(id);
    }


    @Override
    public void onDestroy() {
        mTaskView = null;
    }

    @Override
    public List<String> getUrls() {
        List<String> list = new ArrayList<>();
        for(File file:mTask.getFiles()){
            list.add("http://dev-contact.yalantis.com/files/ticket/"+file.getFilename());
        }
        return list;
    }

    @Override
    public String getDeadline() {
        return DateHelper.getFullDataFromMillis(mTask.getDeadline());
    }

    @Override
    public String getCreated() {
        return DateHelper.getFullDataFromMillis(mTask.getCreatedDate());
    }

    @Override
    public String getRegistered() {
        return DateHelper.getFullDataFromMillis(mTask.getStartDate());
    }

    @Override
    public String getTitle() {
        return mTask.getTitle();
    }

    @Override
    public String getDescription() {
        return mTask.getBody();
    }

    @Override
    public String getResponsible() {
        return mContext.getResources().getString(R.string.responsible_name);
    }

    @Override
    public String getHead() {
        return mTask.getCategory().getName();
    }
}
