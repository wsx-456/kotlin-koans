package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {

    val ordered = this.orders.flatMap { it.products }.toSet()
    return ordered
    // Return all products this customer has ordered
    //todoCollectionTask()
}

val Shop.allOrderedProducts: Set<Product> get() {

    return this.customers.flatMap { it.orderedProducts }.toSet()
    // Return all products that were ordered by at least one customer
    //todoCollectionTask()
}
