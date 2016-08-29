package alexnik0888.yalantistask.ui.activities.task;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import alexnik0888.yalantistask.R;
import alexnik0888.yalantistask.adapters.ImageAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Activity for the task.
 */
public class TaskActivity extends AppCompatActivity implements TaskView {
    @BindView(R.id.deadline_date) TextView mDeadline;
    @BindView(R.id.created_date) TextView mCreated;
    @BindView(R.id.registered_date) TextView mRegistered;
    @BindView(R.id.descriprion) TextView mDescription;
    @BindView(R.id.task_head) TextView mHead;
    @BindView(R.id.responsible) TextView mResponsible;
    @BindView(R.id.image_recycler_view) RecyclerView mRecycler;
    @BindView(R.id.toolbar) Toolbar mToolbar;

    private TaskPresenter mPresenter;
    private List<String> mUrls;
    private int mId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_activity);
        mId = getIntent().getExtras().getInt("id");
        setPresenter();
        initViews();
    }

    private void setPresenter(){
        mPresenter = new TaskPresenterImpl(this, mId);
    }

    private void initViews(){
        ButterKnife.bind(this);
        setValues();
        setSupportActionBar(mToolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(mPresenter.getTitle());
        }
        initRecyclerView();
    }


    //    init RecyclerView
    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        RecyclerView.Adapter adapter = new ImageAdapter(this, mUrls);
        if (mRecycler != null) {
            mRecycler.setHasFixedSize(true);
            mRecycler.setAdapter(adapter);
            mRecycler.setLayoutManager(layoutManager);
        }
    }

    // Back(home) button close application
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //  onClickResItem for views
    public void onViewClick(View v) {
        Toast.makeText(this, v.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setValues() {
        mUrls =  mPresenter.getUrls();
        mCreated.setText( mPresenter.getCreated());
        mDeadline.setText( mPresenter.getDeadline());
        mDescription.setText( mPresenter.getDescription());
        mHead.setText( mPresenter.getHead());
        mResponsible.setText( mPresenter.getResponsible());
        mRegistered.setText( mPresenter.getRegistered());
    }
}
