package bootcamp.demo

class AuthorController {

    def scaffold = true

    def addBooks() {
        Author author = Author.get(params.id ?: 1)
        [author: author]

    }

    //http://localhost:8080/Controllers-II/author/saveBooks/1?books[0].title=java
    //http://localhost:8080/Controllers-II/author/saveBooks/1?books[0].title=java&books[3].title=grails - will ad one more book
    //http://localhost:8080/Controllers-II/author/saveBooks/1?books[0].title=java&books[5].title=grails - error
    def saveBooks() {
        Author author = Author.get(params.id ?: 1)
        author.properties = params
        author.save()
        author.books.each {
            println "#### ${it.title}"
        }
        render(author.books.size())
    }
}
