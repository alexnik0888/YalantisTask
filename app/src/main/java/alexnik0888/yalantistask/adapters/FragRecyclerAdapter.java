package alexnik0888.yalantistask.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import alexnik0888.yalantistask.R;
import alexnik0888.yalantistask.model.Task;
import alexnik0888.yalantistask.ui.activities.task.TaskActivity;
import alexnik0888.yalantistask.utils.DateHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter for TabFragments. Set data for frag views from model.
 */
public class FragRecyclerAdapter extends RecyclerView.Adapter<FragRecyclerAdapter.ViewHolder>{
    private List<Task> mModel;
    private Context mContext;

    public FragRecyclerAdapter(List<Task> mModel, Context context) {
        this.mModel = mModel;
        mContext = context;
    }

    @Override
    public FragRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //TODO getData
        final Task model = mModel.get(position);
        holder.mCount.setText(String.valueOf(model.getLikesCounter()));
        holder.mTitle.setText(model.getCategory().getName());
        holder.mAdress.setText(DateHelper.getFullAddress(model));



        holder.mTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TaskActivity.class);
                intent.putExtra("id", model.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_img) ImageView mImage;
        @BindView(R.id.item_title) TextView mTitle;
        @BindView(R.id.item_like_count) TextView mCount;
        @BindView(R.id.item_date) TextView mDate;
        @BindView(R.id.item_address) TextView mAdress;
        @BindView(R.id.task_item) CardView mTask;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
