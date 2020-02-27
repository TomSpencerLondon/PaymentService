import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class PaymentServiceShould {
  private PaymentService paymentService;

  @Mock
  private PaymentGateway paymentGateway;
  private User user;

  @BeforeEach
  void setUp() {
    paymentService = new PaymentService(paymentGateway, user);
  }

  @Test
  void sends_payment_to_payment_gateway() {
    paymentService.submit();
    verify(paymentGateway).submit();
  }
}
