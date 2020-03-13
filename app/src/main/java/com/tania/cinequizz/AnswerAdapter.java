package com.tania.cinequizz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {

private List<Answer> answers;

    public AnswerAdapter(List<Answer> answers) {
        this.answers = answers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_answer, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Answer answer = answers.get(position);
        if(answer.mediaType.equals("image")) {
            holder.mediaI.setVisibility(View.VISIBLE);
            holder.mediaA.setVisibility(View.INVISIBLE);
            holder.mediaI.setImageResource(answer.media);
        }else if (answer.mediaType.equals("audio")){
            holder.mediaA.setVisibility(View.VISIBLE);
            holder.mediaI.setVisibility(View.INVISIBLE);
        }
        holder.question.setText(answer.question);
        holder.allAnswer.setText("-"+answer.rightAnswer +"\n -"+answer.falseAnswer1+"\n-"+answer.falseAnswer2);
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView mediaI;
        final Button mediaA;
        final TextView question;
        final TextView allAnswer;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mediaI = itemView.findViewById(R.id.mediaImageView);
            mediaA= itemView.findViewById(R.id.audioButton);
            question = itemView.findViewById(R.id.questionTextView);
            allAnswer = itemView.findViewById(R.id.answerTextView);
        }
    }
}
