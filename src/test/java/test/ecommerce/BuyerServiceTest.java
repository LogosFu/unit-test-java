package test.ecommerce;

import ecommerce.Buyer;
import ecommerce.BuyerRepository;
import ecommerce.BuyerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("买家 Service")
public class BuyerServiceTest {

    @Test
    @DisplayName("当注册时，如果提供相同的Email，则注册失败")
    public void should_fail_when_given_a_same_email() {
        // Given
        BuyerRepository buyerRepository = mock(BuyerRepository.class);
        when(buyerRepository.getUserByEmail("abc@sina.com")).thenReturn(new Buyer());

        BuyerService buyerService = new BuyerService(buyerRepository);
        Buyer buyer = new Buyer();
        buyer.setEmail("abc@sina.com");
        // When
        Exception exception = assertThrows(Exception.class,
                () -> buyerService.register(buyer));
        // Then
        assertEquals("已经存在相同的邮箱，请重新输入。", exception.getMessage());
    }

    @Test
    @DisplayName("当注册时，如果买家提供的信息正常，则注册成功")
    public void should_success_save_when_given_a_normal_buyer() throws Exception {
        // Given
        BuyerRepository buyerRepository = mock(BuyerRepository.class);
        when(buyerRepository.getUserByEmail(anyString())).thenReturn(null);

        BuyerService buyerService = new BuyerService(buyerRepository);
        Buyer buyer = new Buyer();
        buyer.setEmail("abc@sina.com");
        // When
        buyerService.register(buyer);
        // Then
        verify(buyerRepository).save(buyer);
    }
}
