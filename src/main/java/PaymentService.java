public class PaymentService {
  private PaymentGateway paymentGateway;
  private User user;

  public PaymentService(PaymentGateway paymentGateway, User user) {
    this.paymentGateway = paymentGateway;
    this.user = user;
  }

  public void submit() throws CustomMissingUserException {
    if(user == null){
      throw new CustomMissingUserException();
    }
    paymentGateway.submit();
  }
}