package Week2.A21.Task3;

public class CoffeeMaker {
    private boolean status;
    private String type;
    private int amount;

    public CoffeeMaker( String type, int amount) {
        this.status = false;
        this.type = type;
        this.amount = amount;
    }

    public void pressOnOff() {
        this.status = !this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getType() {
        return this.type;
    }

    public int getAmount() {
        return this.amount;
    }

    public boolean isOn() {
        return this.status == true;
    }

    public void setAmount(int amount) {
        if (this.isOn() & (this.getAmount()+amount <= 80)) {
            this.amount = amount;
        }
    }

    public void printStatus(){
        String statusText = "off";
        if (this.isOn()){
            statusText = "on";
        }
        System.out.println("Coffee maker is "+statusText);
    }
    public void printType(){
        System.out.println("Coffee type is "+this.getType());
    }
    public void printAmount(){
        System.out.println("Coffee amount is "+this.getAmount());
    }



}
