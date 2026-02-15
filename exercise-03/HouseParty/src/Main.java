//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    House house = new House(20.5, 30.0, 4, "123 Main St, Springfield");
    house.printTotalArea();
    house.report();
    House house2 = new House(15.0, 25.0, 3, "456 Elm St, Springfield");
    house2.printTotalArea();
    house2.report();
    House house3 = new House(10.0, 20.0, 2, "789 Oak St, Springfield");
    house3.printTotalArea();
    house3.report();
}
