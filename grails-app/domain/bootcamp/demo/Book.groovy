package bootcamp.demo

class Book {

    String title
    String description
    Date publishedDate

    Author author

    static constraints = {
        title(blank: false, nullable: false)
        description(nullable: true)
        publishedDate(nullable: true)
        author(nullable: true)
    }

    static mapping = {
        publishedDate(type: 'date')
    }
}
