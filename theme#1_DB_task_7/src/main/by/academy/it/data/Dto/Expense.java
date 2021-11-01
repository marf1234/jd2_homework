package src.main.by.academy.it.data.Dto;

public class Expense {
    private int num;
    private String paydate;
    private String receiver;
    private double value;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "  |  " + getNum() + "  |  " + getPaydate() + "  |  " + getReceiver() + "  |  " + getValue() + "  |  ";
    }

}
