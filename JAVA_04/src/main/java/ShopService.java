class ShopService {
    private ShopService() {}

    private static ShopService instance = new ShopService();

    static ShopService getInstance() {
        return instance;
    }
}

class ShopServiceExample {
    public static void main(String[] args){
          ShopService obj1 = ShopService.getInstance();
          ShopService obj2 = ShopService.getInstance();

          if(obj1 == obj2) {
              System.out.println("같은 객체이다.");
          }
          else{
              System.out.println("다른 객체이다.");
          }
    }
}