fun main() {
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
   return when(bid)
   {
    null -> minimumPrice
    else -> bid.amount
   }
//   Soltion (return bid?.amount ?: minimumPrice )
}

// Output

// Item A is sold at 5000.
// Item B is sold at 3000.