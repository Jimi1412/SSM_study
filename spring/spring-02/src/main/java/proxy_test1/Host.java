package proxy_test1;

//真实角色，房东
public class Host implements Rent{

    @Override
    public void rent() {
        System.out.println("房东出租他的小黑屋...");
    }
}
