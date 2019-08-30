package test.ecommerce;

import ecommerce.Buyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("买家")
public class BuyerTest {

    @Test
    @DisplayName("当充值时，如果金额小于0，则抛出异常")
    public void should_fail_when_recharge_given_money_is_less_than_zero() {
        Buyer buyer = new Buyer();
        Exception exception = assertThrows(Exception.class,
                () -> buyer.recharge(new BigDecimal(-10))
        );
        assertEquals("充值金额不能小于 0", exception.getMessage());
    }

    @Test
    @DisplayName("当充值时，如果金额是10元，则积分为 10")
    public void should_integration_10_when_recharge_given_10_yuan() throws Exception {
        Buyer buyer = new Buyer();
        buyer.recharge(new BigDecimal(10));
        assertEquals(10, buyer.getIntegral());
    }
}
