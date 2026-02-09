import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();

        System.out.print("Enter vessel details (vesselId:vesselName:averageSpeed:vesselType): ");
        String input = sc.nextLine();

        String[] data = input.split(":");

        Vessel vessel = new Vessel(
                data[0],
                data[1],
                Double.parseDouble(data[2]),
                data[3]
        );

        util.addVesselPerformance(vessel);
        System.out.println("Vessel Added Successfully");

        System.out.print("Enter Vessel ID to search:");
        String searchId = sc.nextLine();

        Vessel result = util.getVesselById(searchId);

        if (result != null) {
            System.out.println("Vessel ID: " + result.getVesselId());
            System.out.println("Vessel Name: " + result.getVesselName());
            System.out.println("Average Speed: " + result.getAverageSpeed());
            System.out.println("Vessel Type: " + result.getVesselType());
        } else {
            System.out.println("Vessel Not Found");
        }

        System.out.println("High Performance Vessel Details:");
        List<Vessel> highList = util.getHighPerformanceVessels();

        for (Vessel v : highList) {
            System.out.println("Vessel ID: " + v.getVesselId());
            System.out.println("Vessel Name: " + v.getVesselName());
            System.out.println("Average Speed: " + v.getAverageSpeed());
            System.out.println("Vessel Type: " + v.getVesselType());
        }
    }
}
