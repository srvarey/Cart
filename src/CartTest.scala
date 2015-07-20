/**
 * Created by hadoop on 20/07/15.
 */
object CartTest {

    /*
    3 Apples @ .6   
    1 Orange @ .25  
    Total cost = 2.05
     */
    def test001 () {

        val appleStrategy = new CartApp. ApplePriceStrategy(.6)
        val orangeStrategy = new CartApp.OrangePriceStrategy(.25)


        val cartTotal = CartApp.getCartTotal(appleStrategy, 3, orangeStrategy, 1)


        println("test001:  Cart total = %6.3g".format(cartTotal))

        assert (cartTotal == 2.05)

    }




    def main(args: Array[String]) {
        test001()
    }
}
