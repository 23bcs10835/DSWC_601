package day2;
abstract class SmartDevice{
    protected String deviceId;
    protected String deviceName;
    SmartDevice(String deviceID, String deviceName){
        this.deviceId = deviceID;
        this.deviceName = deviceName;
    }

    public abstract void runDiagnostic();
}

interface BatteryOperated{
    int getBatteryLevel();
    void triggerRechargeAlert();
}

class SmartLight extends SmartDevice{
    public SmartLight(String deviceID, String deviceName){
        super(deviceID, deviceName);
    }
    public void runDiagnostic(){
        System.out.println("light [" + deviceName + "] diagnostic complete.");
    }
}

class SmartCamera extends SmartDevice implements BatteryOperated{
    private int batteryLevel;
    public SmartCamera(String deviceID, String deviceName, int batterylevel){
        super(deviceID, deviceName);
        this.batteryLevel = batterylevel;

    }
    public void runDiagnostic(){
        System.out.println("camera [" + deviceName + "] diagnostic complete.");
    }
    public int getBatteryLevel(){
        return batteryLevel;
    }
    public void triggerRechargeAlert(){
        if(batteryLevel < 20){
            System.out.println("Camera [" + deviceName + "] battery low. Please recharge.");
        }
    }

}

class SmartLock extends SmartDevice implements BatteryOperated{
     private int batteryLevel;
    public SmartLock(String deviceID, String deviceName, int batterylevel){
        super(deviceID, deviceName);
        this.batteryLevel = batterylevel;

    }
    public void runDiagnostic(){
        System.out.println("lock [" + deviceName + "] diagnostic complete.");
    }
    public int getBatteryLevel(){
        return batteryLevel;
    }
    public void triggerRechargeAlert(){
        if(batteryLevel < 20){
            System.out.println("Lock [" + deviceName + "] battery low. Please recharge.");
        }
    }
}

class HomeHub{
     public void executeNightlyRoutine(SmartDevice[] devices){
        for(SmartDevice device : devices){
            device.runDiagnostic();
            if(device instanceof BatteryOperated){
                BatteryOperated batteryDevice = (BatteryOperated) device;
                if(batteryDevice.getBatteryLevel() < 20){
                batteryDevice.triggerRechargeAlert();
                }
            }
            System.out.println();
        }
     }

    public static void main(String[] args) {
        SmartDevice[] devices = new SmartDevice[]{
            new SmartLight("L1", "Living Room Light"),
            new SmartCamera("C1", "Front Door Camera", 15),
            new SmartLock("S1", "Main Door Lock", 25)
        };

        HomeHub hub = new HomeHub();
        hub.executeNightlyRoutine(devices);
    }
}