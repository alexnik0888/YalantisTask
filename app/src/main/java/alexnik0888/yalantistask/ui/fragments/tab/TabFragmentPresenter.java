package alexnik0888.yalantistask.ui.fragments.tab;

import java.util.List;

import alexnik0888.yalantistask.adapters.FragRecyclerAdapter;
import alexnik0888.yalantistask.model.Task;

/**
 * Contract for TabFragment presenter.
 */
public interface TabFragmentPresenter {
    List<Task> getModel(String state);
    void downloadData(String state, int offset, final FragRecyclerAdapter adapter, final List<Task> list);

}
