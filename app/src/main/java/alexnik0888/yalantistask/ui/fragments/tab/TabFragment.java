package alexnik0888.yalantistask.ui.fragments.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import alexnik0888.yalantistask.R;
import alexnik0888.yalantistask.adapters.FragRecyclerAdapter;
import alexnik0888.yalantistask.model.Task;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment for ViewPager in MainActivity.
 */
public class TabFragment extends Fragment implements TabFragmentView {
    @BindView(R.id.frag_rv) RecyclerView mRecycler;

    private TabFragmentPresenter mPresenter;
    private List<Task> mModel;
    private View mRootView;
    private FragRecyclerAdapter mAdapter;
    private int mCounter;
    private static String mState;
    private String STATE;


    public static TabFragment createFragment(String state){
        TabFragment frag = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(mState, state);
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.tab_frag, container, false);
        initModel();
        initFields();
        initViews();
        return mRootView;
    }

    private void initFields(){
        refresh();
        mAdapter = new FragRecyclerAdapter(mModel, getContext());
    }
    private void initViews(){
        ButterKnife.bind(this, mRootView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setAdapter(mAdapter);
        mRecycler.setLayoutManager(layoutManager);
    }
    private void refresh(){
        mPresenter.downloadData(STATE, mCounter,  mAdapter, mModel);
        mCounter = mModel.size();
    }

    @Override
    public void initModel() {
        STATE = getArguments().getString(mState);
        mPresenter = new TabFragmentPresenterImpl();
        mModel = mPresenter.getModel(STATE);
    }
}
