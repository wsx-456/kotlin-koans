package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    // todoCollectionTask()
    // this.orders.flatMap { it.products }.toSet()
    // customers.filter { it.orders.flatMap { it.products }.toSet().contains(product)}
    return customers.filter { it.orderedProducts.contains(product) }.toSet()
    //return customers.filter
}


fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {

    val ordered = customers.flatMap { it.orderedProducts }
    ordered.

    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    todoCollectionTask()
}
