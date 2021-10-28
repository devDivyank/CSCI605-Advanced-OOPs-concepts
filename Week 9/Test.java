public class Test {
    public static void onlyOneType(){
        ListClass<Square> squareList = new ListClass<>();
        squareList.addSameType(new Square());
        squareList.addSameType(new Cube());            // won't be added
        squareList.addSameType(new Square());
        squareList.addSameType(new DCube());           // won't be added
        squareList.print();
    }

    public static void allTypes(){
        ListClass<Line> newList = new ListClass<>();
        newList.addAnyType(new Line());
        newList.addAnyType(new Square());
        newList.addAnyType(new Cube());
        newList.addAnyType(new DCube());
//        newList.addAnyType(new Object());              // won't be added
        newList.print();
    }
    
    public static void cube3DCubeSumMethod(){
        ListClass<Cube> cubeList = new ListClass<>();
        cubeList.addSameType(new Cube());
        ListClass.sum1(cubeList);
//        ListClass.sum2(cubeList);                        // does not compile

        ListClass<DCube> dCubeList = new ListClass<>();
        dCubeList.addSameType(new DCube());
        ListClass.sum1(dCubeList);
//        ListClass.sum2(dCubeList);                 // does not compile
    }

    public static void lineSquareSumMethod(){
        ListClass<Square> squareList = new ListClass<>();
        squareList.addSameType(new Square());
        ListClass.sum2(squareList);
//        ListClass.sum1(squareList);                  // does not compile

        ListClass<Line> lineList = new ListClass<>();
        lineList.addSameType(new Line());
        ListClass.sum2(lineList);
//        ListClass.sum1(lineList);                     // does not compile
    }

    public static void main(String[] args) {
        onlyOneType();
//        allTypes();
//        cube3DCubeSumMethod();
//        lineSquareSumMethod();
    }
}
