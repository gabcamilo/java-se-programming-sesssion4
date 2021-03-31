package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.math.RoundingMode.HALF_UP;

public class Food extends Product {
    private LocalDate bestBefore;

    public Food(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    @Override
    public LocalDate getBestBefore() {
        return bestBefore;
    }

    @Override
    public Product applyRating(Rating newRating) {
        return new Food(this.getId(),this.getName(), this.getPrice(), newRating, this.bestBefore);
    }

    @Override
    public BigDecimal getDiscount() {
        return (bestBefore.isEqual(LocalDate.now()))
                ? super.getDiscount() : BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return "Food {" +
                super.toString() +
                '}';
    }
}
