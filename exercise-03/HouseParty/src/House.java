public class House {
    public double length;
    public double width;
    public int bedRooms;
    public String address;

    public House(double length, double width, int bedRooms, String address) {
        this.length = length;
        this.width = width;
        this.bedRooms = bedRooms;
        this.address = address;
    }

    public void printTotalArea() {
        double area = this.length * this.width;
        System.out.println(String.format("Total area is %.2f square footage", area));
    }

    public void report() {
        System.out.println(String.format("Length: %.2f, width: %.2f,\nNumber of bedrooms: %d,\nThe address is: %s", this.length, this.width, this.bedRooms, this.address));
    }
}
