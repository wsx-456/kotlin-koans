package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {

    return customers.maxBy { it.orders.count() }
    // Return a customer whose order count is the highest among all customers
    todoCollectionTask()
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {

    return this.orderedProducts.toList().maxBy { it.price }
    // Return the most expensive product which has been ordered
    // todoCollectionTask()
}
