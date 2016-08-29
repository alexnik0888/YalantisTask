package alexnik0888.yalantistask.ui.fragments.tab;

import java.util.ArrayList;
import java.util.List;

import alexnik0888.yalantistask.adapters.FragRecyclerAdapter;
import alexnik0888.yalantistask.data.DbManager;
import alexnik0888.yalantistask.model.Task;

/**
 * Presenter for TabFragment. Get model data from db.
 */
public class TabFragmentPresenterImpl implements TabFragmentPresenter {
    private List<Task> mModel;
    private DbManager mManager;

    public TabFragmentPresenterImpl() {
        mManager = new DbManager();
    }

    @Override
    public List<Task> getModel(String state) {
        mModel = new ArrayList<>(mManager.getTasks(state));
        return mModel;
    }

    @Override
    public void downloadData(String state, int offset, FragRecyclerAdapter adapter, List<Task> list) {
        mManager.downloadData(state,offset,adapter,list);
    }

}
