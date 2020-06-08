package _reflection.Proxy.static_proxy;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/23
 */

//接口
interface ClothFactory{
    void productCloth();
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void productCloth() {
        System.out.println("Nike p !");
    }
}

//代理类
class ProxyFactory implements ClothFactory{

    ClothFactory cf;

    public ProxyFactory(ClothFactory cf){
        this.cf = cf ;
    }

    @Override
    public void productCloth() {
        System.out.println("Proxy 执行 !");
        cf.productCloth();
    }
}

public class test_Static_Proxy {
    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ProxyFactory factory = new ProxyFactory(nikeClothFactory);
        factory.productCloth();
    }
}
