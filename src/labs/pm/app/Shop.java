package labs.pm.app;

import labs.pm.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Shop {
    public static void main(String... args) {
        Product p1 = new Drink(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR);
        Product p2 = new Drink(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FIVE_STAR);
        Product p3 = new Food(103, "Cake", BigDecimal.valueOf(3.99),Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = new Food(105, "Cookie", BigDecimal.valueOf(3.99),Rating.TWO_STAR, LocalDate.now());
        Product p5 = p1.applyRating(Rating.THREE_STAR);
        Product p6 = new Drink(104, "Chocolate", BigDecimal.valueOf(3.99),Rating.FIVE_STAR);
        Product p7 = new Food(104, "Chocolate", BigDecimal.valueOf(3.99),Rating.FIVE_STAR, LocalDate.now());

        //getBestBefore is not polymorphic, so to invoke it safely it is necessary to verify its type
        if(p3 instanceof Food){
            LocalDate bestBefore = ((Food)p3).getBestBefore();
            System.out.println(bestBefore);
        }


        System.out.println(p6.equals(p7));
        System.out.println(p5.equals(p1));

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);

    }
}
