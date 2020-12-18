package glover.mike.cs6314assignment1;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {
    String name;
    String position;
    String squadNumber;
    int image_id;
    String bio;
    int bioPages;
    String youtubeID;
    String dob;
    String joined;
    String joinedFrom;
    String unitedDebut;
    String appearances;
    String premAppearances;
    String premWins;
    String premLosses;
    String premSignificantStat;


    public Player(String name, String position, String squadNumber, int image_id, String bio, int bioPages,
                  String youtubeID, String dob, String joined, String joinedFrom, String unitedDebut,
                  String appearances, String premAppearances, String premWins, String premLosses,
                  String premSignificantStat) {
        this.name = name;
        this.position = position;
        this.squadNumber = squadNumber;
        this.image_id = image_id;
        this.bio = bio;
        this.bioPages = bioPages;
        this.youtubeID = youtubeID;
        this.dob = dob;
        this.joined = joined;
        this.joinedFrom = joinedFrom;
        this.unitedDebut = unitedDebut;
        this.appearances = appearances;
        this.premAppearances = premAppearances;
        this.premWins = premWins;
        this.premLosses = premLosses;
        this.premSignificantStat = premSignificantStat;
    }


    public String getName(){
        return this.name;
    }

    public String getPosition(){
        return this.position;
    }

    public String getSquadNumber(){
        return this.squadNumber;
    }

    public int getImageId(){
        return this.image_id;
    }

    public String getBio(){
        return this.bio;
    }

    public int getBioPages() {
        return bioPages;
    }

    public String getYoutubeId() {
        return youtubeID;
    }

    public String getDob() {
        return dob;
    }

    public String getJoined() {
        return joined;
    }

    public String getJoinedFrom() {
        return joinedFrom;
    }

    public String getUnitedDebut() {
        return unitedDebut;
    }

    public String getAppearances() {
        return appearances;
    }

    public String getPremAppearances() {
        return premAppearances;
    }

    public String getPremWins() {
        return premWins;
    }

    public String getPremLosses() {
        return premLosses;
    }

    public String getPremSignificantStat() {
        return premSignificantStat;
    }

    protected Player(Parcel in) {
        name = in.readString();
        position = in.readString();
        squadNumber = in.readString();
        image_id = in.readInt();
        bio = in.readString();
        bioPages = in.readInt();
        youtubeID = in.readString();
        dob = in.readString();
        joined = in.readString();
        joinedFrom = in.readString();
        unitedDebut = in.readString();
        appearances = in.readString();
        premAppearances = in.readString();
        premWins = in.readString();
        premLosses = in.readString();
        premSignificantStat = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(position);
        dest.writeString(squadNumber);
        dest.writeInt(image_id);
        dest.writeString(bio);
        dest.writeInt(bioPages);
        dest.writeString(youtubeID);
        dest.writeString(dob);
        dest.writeString(joined);
        dest.writeString(joinedFrom);
        dest.writeString(unitedDebut);
        dest.writeString(appearances);
        dest.writeString(premAppearances);
        dest.writeString(premWins);
        dest.writeString(premLosses);
        dest.writeString(premSignificantStat);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };


}
