package com.tania.cinequizz;

import android.os.Parcel;
import android.os.Parcelable;


public class Answer implements Parcelable {
    public final int media;
    public final String mediaType;
    public final String question;
    public final String rightAnswer;
    public final String falseAnswer1;
    public final String falseAnswer2;

    public Answer(int media, String mediaType, String question, String rightAnswer, String falseAnswer1, String falseAnswer2) {
        this.media = media;
        this.mediaType = mediaType;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.falseAnswer1 = falseAnswer1;
        this.falseAnswer2 = falseAnswer2;
    }

    protected Answer(Parcel in) {
        media = in.readInt();
        mediaType = in.readString();
        question = in.readString();
        rightAnswer = in.readString();
        falseAnswer1 = in.readString();
        falseAnswer2 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(media);
        dest.writeString(mediaType);
        dest.writeString(question);
        dest.writeString(rightAnswer);
        dest.writeString(falseAnswer1);
        dest.writeString(falseAnswer2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Answer> CREATOR = new Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel in) {
            return new Answer(in);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };

    public int getMedia() {
        return media;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getQuestion() {
        return question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getFalseAnswer1() {
        return falseAnswer1;
    }

    public String getFalseAnswer2() {
        return falseAnswer2;
    }
}