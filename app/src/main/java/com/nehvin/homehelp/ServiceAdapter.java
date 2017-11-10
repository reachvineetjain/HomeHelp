package com.nehvin.homehelp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Neha on 09-Nov-17.
 */

class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    private static final String TAG = ServiceAdapter.class.getSimpleName();
    public Context context;
    public List<ServiceView> list;
    final private ListItemClickListener mOnItemClickListener;

    public ServiceAdapter(Context context, List<ServiceView> list, ListItemClickListener listener) {

        this.context = context;
        this.list = list;
        mOnItemClickListener = listener;
    }

    @Override
    public ServiceViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewPosition) {
//        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.num_list_item;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        ServiceViewHolder viewHolder = new ServiceViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ServiceViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.title.setText(list.get(position).name);
        holder.phone_no.setText(list.get(position).contactno);
        holder.rb.setRating(Float.parseFloat(list.get(position).rating));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    /**
     * Cache of the children views for a list item.
     */
    class ServiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // Will display the position in the list, ie 0 through getItemCount() - 1
        TextView title;
        TextView phone_no;
        RatingBar rb;


        public ServiceViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_name);
            phone_no = (TextView) itemView.findViewById(R.id.tv_phone_number);
            rb = (RatingBar) itemView.findViewById(R.id.ratingBar);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnItemClickListener.onListItemClick(clickedPosition);
        }
    }

    public interface ListItemClickListener
    {
        void onListItemClick(int clickedItemIndex);
    }

}
