import org.junit.jupiter.api.Test;

public class JavaPractice { // nazvanie s boljwoj bukvi

    @Test
    public void firstJavaCode() {
        Double distance = 135.7;
        Double fuelAmount = 20.00;

        double ticketMonthPrize = 50.00;
        int ridesCount = 80;

        int zojaRidesCount = 2;



        Double consumption = fuelAmount / distance * 100;

        Double pricePerRide = calculatePricePerRide(ridesCount);

        Double pricePerRideForZoja = calculatePricePerRide(zojaRidesCount);

        System.out.println("Current fuel consumption is " + consumption +
                " but using troley it cost " + pricePerRide + " per month" + " and now Zoja spend "
                + pricePerRideForZoja + " per ride");

        int a = 15;
        int b = 18;

        String c = "15";
        String d = "18";

        System.out.println(a + b);
        System.out.println(c + d);

    }

    private double calculatePricePerRide (int ridesCount) {
       final double PRICE = 50.00;

       double pricePerRide = PRICE / ridesCount;
       return pricePerRide;
    }

}
