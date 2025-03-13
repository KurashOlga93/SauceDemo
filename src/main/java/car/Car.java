package car;

import jdk.jfr.Enabled;
import lombok.*;
import org.testng.Assert;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Car {
    public String mark;
    public String model;

    public static void main(String[] args) {
        Car car0 = Car.builder()
                .mark("BMW")
                .build();
        Car car1 = new Car("BMW", "1");
        Car car2 = new Car("BMW", "2");

        Assert.assertEquals(car1, car2);
    }
}
