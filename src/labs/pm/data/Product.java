package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;
import static labs.pm.data.Rating.*;

public abstract class Product {
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

    public abstract Product applyRating(Rating newRating);

    // defaults bestBefore date for "today" when there is no specialization of this method in the subclasses
    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return "id=" + id +
               ", name='" + name + '\'' +
               ", price=" + price.subtract(getDiscount()) +
               ", rating=" + rating.getStars() +
               "best before=" + getBestBefore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o instanceof Product) {
        if (o != null && getClass() == o.getClass()) {
            final Product other = (Product) o;
            return this.id == other.id && Objects.equals(this.name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
