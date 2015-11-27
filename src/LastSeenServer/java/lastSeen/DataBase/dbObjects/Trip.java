package lastSeen.DataBase.dbObjects;

import java.util.Date;
import java.util.List;

/**
 * Created by yoavsusan on 11/24/2015.
 */
public class Trip {

    private int id = -1;
    private String title;
    private Date startDate;
    private Date endDate;
    private List<CheckIn> checkIns;
    private boolean isDelayNotification;
    private int numDaysNotification;
    private List<SharingEmail> sharingList;


    public Trip () {}

    public Trip (int id, String title, Date startDate, Date endDate, List<CheckIn> checkIns, boolean isDelayNotification,
                 int numDaysNotification, List<SharingEmail> sharingList) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkIns = checkIns;
        this.isDelayNotification = isDelayNotification;
        this.numDaysNotification = numDaysNotification;
        this.sharingList = sharingList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<CheckIn> getCheckIns() {
        return checkIns;
    }

    public void setCheckIns(List<CheckIn> checkIns) {
        this.checkIns = checkIns;
    }

    public boolean getIsDelayNotification() {
        return isDelayNotification;
    }

    public void setDelayNotification(boolean delayNotification) {
        isDelayNotification = delayNotification;
    }

    public int getNumDaysNotification() {
        return numDaysNotification;
    }

    public void setNumDaysNotification(int numDaysNotification) {
        this.numDaysNotification = numDaysNotification;
    }

    public List<SharingEmail> getSharingList() {
        return sharingList;
    }

    public void setSharingList(List<SharingEmail> sharingList) {
        this.sharingList = sharingList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", id: ").append(this.getId())
                .append(", title: ").append(this.getTitle())
                .append(", startDate: ").append(this.getStartDate())
                .append(", endDate: ").append(this.getEndDate())
                .append(", checkIns: ");
        for (CheckIn checkIn : checkIns)
            sb.append(checkIn.toString());
        sb.append(", isDelayNotification: ").append(this.getIsDelayNotification())
                .append(", numDaysNotification: ").append(this.getNumDaysNotification())
                .append(", sharingList: ").append(this.getSharingList());
        for (SharingEmail sharingEmail : sharingList)
            sb.append(sharingEmail.getEmail());
        return sb.toString();
    }
}
