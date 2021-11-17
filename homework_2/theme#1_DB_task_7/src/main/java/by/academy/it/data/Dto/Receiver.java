package by.academy.it.data.Dto;

public class Receiver {
    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "  |  " + getNum() + "  |  " + getName()+ "  |  ";
    }
}
