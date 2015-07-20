import scala.collection.immutable.List
import scala.collection.immutable.List

object CartApp {


    val Apple = "Apple"
    val Orange = "Orange"

    val shoppingcartItems = List(Apple, Apple, Orange, Apple)






    class ApplePriceStrategy(price: Double)  {
        def total(noOfApples: Int): Double = {

            noOfApples * price
        }
    }




    class OrangePriceStrategy(price: Double)  {

        def total(noOfOranges: Int): Double = {

            noOfOranges * price
        }

    }


    //Set the price for applces for current day
    def selectApplePriceStrategyForDay() = {

        new ApplePriceStrategy(.6)
    }


    //Set the price for oranges for current day
    def selectOrangePriceStrategyForDay() = {

        new OrangePriceStrategy(.25)
    }


    //Calculate cart total = sum of (apples* prices) + sum of (oranges * prices)
    def getCartTotal(applePriceStrategy: ApplePriceStrategy, apples: Int, orangePriceStrategy: OrangePriceStrategy, oranges: Int) = {

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