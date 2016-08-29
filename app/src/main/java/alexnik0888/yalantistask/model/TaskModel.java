package alexnik0888.yalantistask.model;

/**
 * Created by Alex on 04.08.2016.
 */
public class TaskModel {
    private String mTitle;
    private String mAdress;
    private String mLikeCount;
    private String mImage;
    private String mDate;

    public TaskModel(String mTitle, String mAdress, String mLikeCount, String mImage, String mDate) {
        this.mTitle = mTitle;
        this.mAdress = mAdress;
        this.mLikeCount = mLikeCount;
        this.mImage = mImage;
        this.mDate = mDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmAdress() {
        return mAdress;
    }

    public String getmLikeCount() {
        return mLikeCount;
    }

    public String getmImage() {
        return mImage;
    }

    public String getmDate() {
        return mDate;
    }
}
