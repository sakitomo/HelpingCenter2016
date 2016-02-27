package lasalle2016studentproject.helpingcenter2016.BasisClasses;

/**
 * Created by sakitomo on 2016/02/26.
 */
public class HelpService {
    private int serviceId;
    private String serviceName;
    private String desc;

    public HelpService(int serviceId, String serviceName, String desc) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.desc = desc;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
