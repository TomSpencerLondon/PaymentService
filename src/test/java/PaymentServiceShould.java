import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class PaymentServiceShould {
  private PaymentService paymentService;

  @Mock
  private PaymentGateway paymentGateway;
  private User user = Mockito.mock(User.class);

  @BeforeEach
  void setUp() {
    paymentService = new PaymentService(paymentGateway, user);
  }

  @Test
  void sends_payment_to_payment_gateway() throws CustomMissingUserException {
    paymentService.submit();
    verify(paymentGateway).submit();
  }

  @Test
  void missing_user_throws_exception() throws CustomMissingUserException {
    PaymentService missingUserPaymentService = new PaymentService(paymentGateway, null);

    assertThrows(CustomMissingUserException.class, () -> {
      missingUserPaymentService.submit();
    });
  }
}
