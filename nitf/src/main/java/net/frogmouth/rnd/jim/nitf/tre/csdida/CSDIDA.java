package net.frogmouth.rnd.jim.nitf.tre.csdida;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class CSDIDA extends TaggedRecordExtension {

    private static final String TRE_TAG = "CSDIDA";
    private int day;
    private String month;
    private int year;
    private String platformCode;
    private int vehicleId;
    private int passNumber;
    private int operationNumber;
    private String sensorId;
    private String productId;
    private String time;
    private String processTime;
    private String softwareVersionNumber;

    public CSDIDA() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREField(label = "DAY")
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @TREOrder(order = 2)
    @TREField(label = "MONTH")
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @TREOrder(order = 3)
    @TREField(label = "YEAR")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @TREOrder(order = 4)
    @TREField(label = "PLATFORM CODE")
    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    @TREOrder(order = 5)
    @TREField(label = "VEHICLE ID")
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @TREOrder(order = 6)
    @TREField(label = "PASS")
    public int getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    @TREOrder(order = 7)
    @TREField(label = "OPERATION")
    public int getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(int operationNumber) {
        this.operationNumber = operationNumber;
    }

    @TREOrder(order = 8)
    @TREField(label = "SENSOR ID")
    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    @TREOrder(order = 9)
    @TREField(label = "PRODUCT ID")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @TREOrder(order = 10)
    @TREField(label = "TIME")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @TREOrder(order = 11)
    @TREField(label = "PROCESS TIME")
    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    @TREOrder(order = 12)
    @TREField(label = "SOFTWARE VERSION NUMBER")
    public String getSoftwareVersionNumber() {
        return softwareVersionNumber;
    }

    public void setSoftwareVersionNumber(String softwareVersionNumber) {
        this.softwareVersionNumber = softwareVersionNumber;
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
