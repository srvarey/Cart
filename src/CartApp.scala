import scala.collection.immutable.List
import scala.collection.immutable.List

object CartApp {


    val Apple = "Apple"
    val Orange = "Orange"

    val shoppingcartItems = List(Apple, Apple, Orange, Apple)


    //Added for part 2
    trait PriceStrategy {
        def total(noOfApples: Int): Double
    }


    class ApplePriceStrategyBuyOneGetOneFree(price: Double) extends PriceStrategy {
        override def total(noOfApples: Int): Double = {

            var total = 0.0;

            val pairs : Int = noOfApples / 2;


            total = pairs * price;

            if (noOfApples % 2 == 1)
            {
                total += price;
            }

            total
        }
    }


    class ApplePriceStrategyStandard(price: Double) extends PriceStrategy {
        override def total(noOfApples: Int): Double = {

            noOfApples * price
        }
    }


    class OrangePriceStrategy3for2(price: Double) extends PriceStrategy {
        override def total(noOfOranges: Int): Double = {

            var total = 0.0;
            var oddOnes = 0;
            var threes = noOfOranges / 3;


            if (noOfOranges % 3 == 1) {
                oddOnes = 1;
            }
            else if (noOfOranges % 3 == 2) {
                oddOnes = 2;
            }


            total = threes * 2 * price;

            if (oddOnes == 1)
                total += price;

            else if (oddOnes == 2)
                total += 2 * price;


            return total;
        }

    }


    class OrangePriceStrategyStandard(price: Double) extends PriceStrategy {
        override def total(noOfOranges: Int): Double = {

            noOfOranges * price
        }

    }


    def selectApplePriceStrategyForDay(): PriceStrategy = {

        //        new ApplePriceStrategyStandard(.6)
        new ApplePriceStrategyBuyOneGetOneFree(.6)
    }


    def selectOrangePriceStrategyForDay(): PriceStrategy = {

        //        new OrangePriceStrategyStandard(.25)
        new OrangePriceStrategy3for2(.25)
    }


    def getCartTotal(applePriceStrategy: PriceStrategy, apples: Int, orangePriceStrategy: PriceStrategy, oranges: Int) = {
        val appleTotal = applePriceStrategy.total(apples)
        val orangeTotal = orangePriceStrategy.total(oranges)
        appleTotal + orangeTotal

    }


    def runapp  {


        val apples = shoppingcartItems.filter(_ == Apple)

        val oranges = shoppingcartItems.filter(_ == Orange)


        val appleStrategy = selectApplePriceStrategyForDay()
        val orangeStrategy = selectOrangePriceStrategyForDay()


        val cartTotal = getCartTotal(appleStrategy, apples.length, orangeStrategy, oranges.length)


        println("Cart total = %6.3g".format(cartTotal))


    }


    def main(args: Array[String]) {
        runapp
    }
}
