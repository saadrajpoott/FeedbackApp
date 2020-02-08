package com.example.feedbackapp.FeedbackList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feedbackapp.R;

import java.util.ArrayList;

public class FeedbackListAdapter extends RecyclerView.Adapter<FeedbackListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FeedbackData> feedbackDataList;

    public FeedbackListAdapter(Context context, ArrayList<FeedbackData> feedbackDataList ){
        this.context = context;
        this.feedbackDataList = feedbackDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.feedback_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackListAdapter.ViewHolder holder, int position) {
        FeedbackData currentFeedback = feedbackDataList.get(position);
        holder.bindTo(currentFeedback);
    }

    @Override
    public int getItemCount() {
        return feedbackDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView fullname;
        private TextView feedbackText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.fullname_display);
            feedbackText = itemView.findViewById(R.id.feedback_display);
        }

        public void bindTo(FeedbackData currentFeedback){
            fullname.setText(currentFeedback.getFullname());
            feedbackText.setText(currentFeedback.getFeedback());
        }

    }
}
