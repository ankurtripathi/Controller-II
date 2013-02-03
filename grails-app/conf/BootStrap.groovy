import bootcamp.demo.Author
import bootcamp.demo.Book

class BootStrap {

    def init = { servletContext ->
        createSampleAuthors()
        createSampleBooks()
    }


    def destroy = {
    }

    void createSampleAuthors() {
        if (!Author.count()) {
            new Author(name: "Bond").save()
            new Author(name: "Batman").save()
        }
    }

    void createSampleBooks() {
        if (!Book.count()) {
            5.times {
                new Book(title: "Book - ${it}").save()
            }
        }
    }
}
