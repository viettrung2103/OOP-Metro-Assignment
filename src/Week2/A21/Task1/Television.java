package Week2.A21.Task1;

public class Television {
    private int channel;
    private boolean isOn;

    public Television(){
        this.channel =0;
        this.isOn = false;
    }
    public void setChannel(int channel){
        if (channel > 10){
            channel = 1;
        }
        this.channel = channel;
    }

    public boolean isOn(){
        return this.isOn == true;
    }

    public int getChannel(){
        return this.channel;
    }

    public void pressOnOff(){
        this.isOn = !this.isOn;
    }
}
