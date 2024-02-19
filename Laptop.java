package homework_6;

public class Laptop {
    int id;
    String brand;
    int ram;
    int hdd;
    String operation_system;
    String colour;
    @Override
    public String toString() {
        return brand + ':' + '\n'+
                "RAM - " + ram + "Gb" +
                " HDD - " + hdd + "Gb" +
                " Operation system - '" + operation_system + '\'' +
                ", colour - '" + colour + '\'';
    }
}