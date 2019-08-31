package test.dressmaker;

import dressmaker.Dressmaker;
import dressmaker.Tshirt;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("裁缝")
public class DressmakerTest {

    @Test
    @DisplayName("如果使用蓝色的线，当裁缝 Andy 做一件 T恤，则得到一个红色的XL T恤")
    public void should_tailor_to_a_T_shirt_when_given_red_needlework() {
        String size = "XL";
        // Given
        Dressmaker dressmaker = new Dressmaker("Andy");
        // When
        Tshirt tshirt = dressmaker.tailor(size, "RED");
        // Then
        assertEquals(tshirt, new Tshirt(size, "RED"));
    }

    @ParameterizedTest(name="如果使用蓝色的线，当裁缝 Andy 做一件 T恤，则得到一个蓝色的{0} T恤")
    @ValueSource(strings = { "XL", "XXL" })
    public void should_tailor_to_a_T_shirt_when_given_blue_needlework(String size) {
        // Given
        Dressmaker dressmaker = new Dressmaker("Andy");
        // When
        Tshirt tshirt = dressmaker.tailor(size, "BLUE");
        // Then
        assertEquals(tshirt, new Tshirt(size, "BLUE"));
    }

    @ParameterizedTest(name="如果使用蓝色的线，当裁缝 Andy 做一件 T恤，则得到一个{1}的{0} T恤")
    @CsvSource({ "XL, BLUE", "XXL, RED" })
    public void should_tailor_to_a_T_shirt_when_given_needlework(String size, String color) {
        // Given
        Dressmaker dressmaker = new Dressmaker("Andy");
        // When
        Tshirt tshirt = dressmaker.tailor(size, color);
        // Then
        assertEquals(tshirt, new Tshirt(size, color));
    }

    @Test
    @Disabled
    @DisplayName("跳过失败测试")
    public void should_fail() {
        fail("一定会失败");
    }

    @RepeatedTest(value = 10, name = "{displayName}{currentRepetition}/{totalRepetitions}次")
    @DisplayName("重复Case：")
    public void repeat_10_times(RepetitionInfo repetitionInfo){
        System.out.println(repetitionInfo.getCurrentRepetition());
    }
}
