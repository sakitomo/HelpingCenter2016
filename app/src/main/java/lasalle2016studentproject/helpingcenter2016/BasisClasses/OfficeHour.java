package lasalle2016studentproject.helpingcenter2016.BasisClasses;

/**
 * Created by sakitomo on 2016/02/26.
 */
public class OfficeHour {
    private int hourId;
    private String staffName;
    private int day;
    private int startTime;
    private int endTime;
    private int serviceId;

    public OfficeHour(int hourId, String staffName, int day, int startTime, int endTime, int serviceId) {
        this.hourId = hourId;
        this.staffName = staffName;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.serviceId = serviceId;
    }

    public int getHourId() {
        return hourId;
    }

    public void setHourId(int hourId) {
        this.hourId = hourId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
