public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------check Vehicle class-----------------------");
        Vehicle v = new Vehicle("3FDS9DFF8FSD7",4,"Moby");
        System.out.println(v.getSerialNumber());
        System.out.println(v.addFuel(3.3));
        System.out.println(v.goTo(3.3,3.3));
        v.printInfo();

        System.out.println("-------------------check OnRoad class-----------------------");
        OnRoad or = new OnRoad("FDFL8KMFSDLKM6",2,"Sporty",6,2);
        System.out.println(or.goTo(3.3,3.5));
        System.out.println(or.addFuel(25.67));
        or.printInfo();

        System.out.println("-------------------check OnWater class-----------------------");
        OnWater ow = new OnWater("F8GFDG86D87GGD",20,"Wavess",2,2000);
        System.out.println(ow.goTo(3.3,3.5));
        System.out.println(ow.addFuel(40.67));
        ow.printInfo();

        System.out.println("-------------------check OnAir class-----------------------");
        OnAir oa = new OnAir("GJR96GDF98DF9ND",120,"Bluesky",4,false);
        System.out.println(oa.goTo(3.3,3.5));
        System.out.println(oa.addFuel(3000.67));
        oa.printInfo();
        
    }
}

