package ecommerce;

public class BuyerRepository {
    public Buyer getUserByEmail(String email) {
        System.out.println("查询数据库！");
        return null;
    };

    public void save(Buyer buyer) {
        System.out.println("保持用户，插入数据库！");
    }
}
