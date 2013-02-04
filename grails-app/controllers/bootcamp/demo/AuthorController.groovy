package bootcamp.demo

import demo.bootcamp.ForgotPassword

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
        render("Done")
    }

    //http://localhost:8080/Controllers-II/author/multipleDomain?book.title=grails-from-multipledomain&author.name= author-multipledomain
    def multipleDomain() {
        Book book = new Book(params['book'])
        Author author = new Author(params['author'])
        render("Book :: ${book.title} -- Author :: ${author.name}")
    }

    def commandObj = { RegisterCommand registerCommand, ForgotPassword forgotPasswordComm ->
        render("Hello")
    }
}

class RegisterCommand {
    String email

    static constraints = {
        email(email: true, nullable: false)
    }
}
