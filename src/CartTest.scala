/**
 * Created by hadoop on 20/07/15.
 */
object CartTest {

    /*
    3 Apples @ .6   standard
    1 Orange @ .25  standard
    Total cost = 2.05
     */
    def test001 () {

        val appleStrategy = new CartApp. ApplePriceStrategyStandard(.6)
        val orangeStrategy = new CartApp.OrangePriceStrategyStandard(.25)


        val cartTotal = CartApp.getCartTotal(appleStrategy, 3, orangeStrategy, 1)


        println("test001:  Cart total = %6.3g".format(cartTotal))

        assert (cartTotal == 2.05)

    }


    /*
    3 Apples @ .6   BuyOneGetOneFree
    1 Orange @ .25  3 for 2
    Total cost = 1.45
     */
    def test002 () {

        val appleStrategy = new CartApp. ApplePriceStrategyBuyOneGetOneFree(.6)
        val orangeStrategy = new CartApp.OrangePriceStrategy3for2(.25)


        val cartTotal = CartApp.getCartTotal(appleStrategy, 3, orangeStrategy, 1)


        println("test002:  Cart total = %6.3g".format(cartTotal))

        assert (cartTotal == 1.45)

    }


    /*
    4 Apples @ .6   BuyOneGetOneFree
    2 Orange @ .25  3 for 2
    Total cost = 1.45
     */
    def test003 () {



        val appleStrategy = new CartApp. ApplePriceStrategyBuyOneGetOneFree(.6)
        val orangeStrategy = new CartApp.OrangePriceStrategy3for2(.25)


        val cartTotal = CartApp.getCartTotal(appleStrategy, 4, orangeStrategy, 2)


        println("test003:  Cart total = %6.3g".format(cartTotal))

        assert (cartTotal == 1.7)

    }



    def main(args: Array[String]) {
        test001()
        test002()
        test003()
    }
}

