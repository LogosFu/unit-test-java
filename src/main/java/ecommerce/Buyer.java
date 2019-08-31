package ecommerce;

import java.math.BigDecimal;

public class Buyer {

    private BigDecimal balance = new BigDecimal(0);
    private int integral = 0;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void recharge(BigDecimal amount) throws Exception {
        if (amount.compareTo(new BigDecimal(0)) < 0) {
            throw new Exception("充值金额不能小于 0");
        }
        this.balance.add(amount);
        this.integral += amount.intValue();
    }

    public int getIntegral() {
        return this.integral;
    }

    public String getEmail() {
        return email;
    }
}
