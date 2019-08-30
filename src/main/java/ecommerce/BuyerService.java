package ecommerce;

public class BuyerService {

    private BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public void register(Buyer buyer) throws Exception {
        Buyer tempBuyer = buyerRepository.getUserByEmail(buyer.getEmail());
        if (tempBuyer != null) {
            throw new Exception("已经存在相同的邮箱，请重新输入。");
        }

        buyerRepository.save(buyer);
    }
}
