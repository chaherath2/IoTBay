package model;

public class Device {

    private Long id; // auto-increment primary key

    private String deviceId; // device id

    private int type; // type of device. eg: 0-healthcare devices 1-smart home devices etc.

    private String deviceName; // name of device

    private String deviceDescription; // description of device

    private Double price; // unit price of device

    private Integer stock; // stock of device

    private Long cTime; // device add time in timestamp format

    private Long uTime; // device update time in timestamp format

    private Boolean isAvailable; // availability


    //no-args constructor
    public Device() {
    }

    //all-args constructor
    public Device(Long id, String deviceId, int type, String deviceName, String deviceDescription, Double price, Integer stock, Long cTime, Long uTime, Boolean isAvailable) {
        this.id = id;
        this.deviceId = deviceId;
        this.type = type;
        this.deviceName = deviceName;
        this.deviceDescription = deviceDescription;
        this.price = price;
        this.stock = stock;
        this.cTime = cTime;
        this.uTime = uTime;
        this.isAvailable = isAvailable;
    }


    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setCTime(Long cTime) {
        this.cTime = cTime;
    }

    public void setUTime(Long uTime) {
        this.uTime = uTime;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Long getId() {
        return id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public int getType() {
        return type;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public Long getCTime() {
        return cTime;
    }

    public Long getUTime() {
        return uTime;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
