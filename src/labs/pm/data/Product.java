package labs.pm.data;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;
import static labs.pm.data.Rating.*;

public class Product {
    private final int id;
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private final String name;
    private final BigDecimal price;
    private final Rating rating;

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, NOT_RATED);
    }

    public Product() {
        this(0, "no name", BigDecimal.ZERO);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }

    public Product applyRating(Rating newRating) {
        return new Product(this.id,this.name, this.price, newRating);
    }

    @Override
    public String toString() {
        return "id=" + id +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", rating=" + rating.getStars();
    }
}
