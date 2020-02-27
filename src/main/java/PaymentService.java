public class PaymentService {
  private PaymentGateway paymentGateway;
  public PaymentService(PaymentGateway paymentGateway, User user) {
    this.paymentGateway = paymentGateway;
  }

  public void submit() {
    paymentGateway.submit();
  }
}