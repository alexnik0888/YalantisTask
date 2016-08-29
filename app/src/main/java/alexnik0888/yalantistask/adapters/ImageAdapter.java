package alexnik0888.yalantistask.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import alexnik0888.yalantistask.R;

/**
 *  Adapter for images in RecyclerView in Task class.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> mUrlArray;
    private LayoutInflater mInflater;

    public ImageAdapter(Context context, List<String> urlArray) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mUrlArray = urlArray;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.mImageView = (ImageView)itemView.findViewById(R.id.image);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.image_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageAdapter.MyViewHolder holder, int position) {
        Picasso.with(mContext).load(mUrlArray.get(position)).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mUrlArray.size();
    }
}
