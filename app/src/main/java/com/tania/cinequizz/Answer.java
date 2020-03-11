package com.tania.cinequizz;

import android.os.Parcel;
import android.os.Parcelable;

public class Answer implements Parcelable  {
    private  int media;
    private  String answer1;
    private  String answer2;
    private  String answer3;

    public Answer(int media, String answer1, String answer2, String answer3) {
        this.media = media;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "media=" + media +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                '}';
    }

    protected Answer(Parcel in) {
        media = in.readInt();
        answer1 = in.readString();
        answer2 = in.readString();
        answer3 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(media);
        dest.writeString(answer1);
        dest.writeString(answer2);
        dest.writeString(answer3);
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


}
