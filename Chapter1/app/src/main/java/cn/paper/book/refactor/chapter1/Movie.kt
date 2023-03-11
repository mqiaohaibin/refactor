package cn.paper.book.refactor.chapter1

data class Movie(var title: String, var type: Int = TYPE_REGULAR) {

    companion object {
        const val TYPE_REGULAR = 0
        const val TYPE_NEW_RELEASE = 1
        const val TYPE_CHILDRENS = 2
    }
}