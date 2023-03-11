package cn.paper.book.refator.chapter1

import cn.paper.book.refactor.chapter1.Customer
import cn.paper.book.refactor.chapter1.Movie
import org.junit.Test

class CustomerTest {

    @Test
    fun testStatement() {
        val customer = Customer("qiaohaibin")
        customer.add(Movie("movie1"), 2)
        customer.add(Movie("movie2", Movie.TYPE_NEW_RELEASE), 5)
        customer.add(Movie("movie3", Movie.TYPE_CHILDRENS), 3)
        val result = customer.statement()
        println("$result")
    }

}