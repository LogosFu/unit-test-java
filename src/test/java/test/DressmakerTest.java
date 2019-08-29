package test;

import dressmaker.Dressmaker;
import dressmaker.Tshirt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("裁缝")
public class DressmakerTest {

    @BeforeEach
    public void beforeEach() {
        System.out.println("before");
    }

    @Test
    @DisplayName("如果使用蓝色的线，当裁缝 Andy 做一件 T恤，则得到一个蓝色的XL T恤")
    public void should_tailor_to_a_T_shirt_when_given_blue_needlework() {
        // Given
        Dressmaker dressmaker = new Dressmaker("Andy");
        // When
        Tshirt tshirt = dressmaker.tailor("BLUE");
        // Then
        assertEquals(tshirt, new Tshirt("XL", "BLUE"));
    }
}
