package com.tania.cinequizz;

import android.os.Parcel;
import android.os.Parcelable;

public class AboutInfo implements Parcelable {
    public final String nameApp;
    public final String member1;
    public final String member2;
    public final String member3;
    public final String member4;
    public final String version;

    @Override
    public String toString() {
        return   nameApp +
                " est développée par une équipe de choc composé d'un grand écrivain " + member1 +
                ", d'un membre de la mafia martiniquaise " + member2 +
                ", d'un groos NOOB sur League of legends " + member3 +
                " et du menuisier de l'extrême " + member4 +
                ", version de l'APP '" + version + '\'';
    }

    public AboutInfo(String App, String n1, String n2, String n3, String n4, String version){
        this.nameApp = App;
        this.member1 = n1;
        this.member2 = n2;
        this.member3 = n3;
        this.member4 = n4;
        this.version = version;
    }

    protected AboutInfo(Parcel in) {
        nameApp = in.readString();
        member1 = in.readString();
        member2 = in.readString();
        member3 = in.readString();
        member4 = in.readString();
        version = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameApp);
        dest.writeString(member1);
        dest.writeString(member2);
        dest.writeString(member3);
        dest.writeString(member4);
        dest.writeString(version);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AboutInfo> CREATOR = new Creator<AboutInfo>() {
        @Override
        public AboutInfo createFromParcel(Parcel in) {
            return new AboutInfo(in);
        }

        @Override
        public AboutInfo[] newArray(int size) {
            return new AboutInfo[size];
        }
    };
}
