import org.junit.jupiter.api.Test;

public class HomeTask {

    @Test
    public void colculateCredit() {
        Double amount = 50.000;
        Double procentage = 15d;
        System.out.println("Start amount: " + amount);
        Double procentageAmount = amount * procentage / 100;
        System.out.println("Percentage amount: " + procentageAmount);
        Double resultAmount = amount + procentageAmount;
        System.out.println("Result amount: " + resultAmount);

    }

    @Test
    public void getStringLength() {
        String string = "Archibald archibaljdovich";
        int stringLength = string.length();
        System.out.println("String " + string + " contains " + stringLength + " letters.");
        String[] words = string.split(" ");
        System.out.println("words count " + words.length);

    }

    @Test
    public void colculateDistance() {
        int x1, x2, y1, y2;
        double distance;
        x1 = 1;
        y1 = 1;
        x2 = 4;
        y2 = 4;
        distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        System.out.println("distancebetween" + "(" + x1 + "," + y1 + ")," + "(" + x2 + "," + y2 + ")===>" + distance);
    }


}
