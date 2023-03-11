package cn.paper.book.refactor.chapter1

class Customer(var name: String, private val rentalList: MutableList<Rental> = arrayListOf()) {

    fun add(movie: Movie, daysRented: Int) {
        add(Rental(movie, daysRented))
    }

    fun add(rental: Rental) {
        rentalList.add(rental)
    }

    fun statement(): String {
        var totalAmount = 0.0
        var frequentRenterPoints = 0

        val result = StringBuilder()
        result.append("Rental Record for $name\n")

        val rentalList = rentalList.toList()
        for (rental in rentalList) {

            var amount = 0.0

            when (rental.movie.type) {
                Movie.TYPE_REGULAR -> {
                    amount += 2
                    if (rental.daysRented > 2) {
                        amount += (rental.daysRented - 2) * 1.5
                    }
                }
                Movie.TYPE_NEW_RELEASE -> {
                    amount += rental.daysRented * 3
                }
                Movie.TYPE_CHILDRENS -> {
                    amount += 1.5
                    if (rental.daysRented > 3) {
                        amount += (rental.daysRented - 3) * 1.5
                    }
                }
            }

            frequentRenterPoints++
            if (rental.movie.type == Movie.TYPE_NEW_RELEASE && rental.daysRented > 1) {
                frequentRenterPoints++
            }

            result.append("\t${rental.movie.title}\t${amount}\n")
            totalAmount += amount
        }

        result.append("Amount owed is ${totalAmount}\n")
        result.append("You earned ${frequentRenterPoints} frequent renter points")
        return result.toString()
    }
}