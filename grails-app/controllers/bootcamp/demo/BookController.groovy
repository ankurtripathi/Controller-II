package bootcamp.demo

class BookController {

    def scaffold = true

    //http://localhost:8080/Controllers-II/book/saveWithParamsConstructor?title=grails
    //http://localhost:8080/Controllers-II/book/saveWithParamsConstructor?description=grails - Error should be printed
    def saveWithParamsConstructor() {
        Book book = new Book(params)
        if (!book.validate()) {
            book.errors.allErrors.each {
                println it
            }
        }
        book.save()
        redirect action: 'list'
    }

    //http://localhost:8080/Controllers-II/book/saveWithProperties?title=grails-properties
    //http://localhost:8080/Controllers-II/book/saveWithProperties?id=1&title=grails-properties-updated
    def saveWithProperties() {
        Book book = new Book()
        if (params.id) {
            book = Book.get(params.id)
        }
        book.properties = params
        book.save()
        redirect action: 'list'
    }

    //http://localhost:8080/Controllers-II/book/saveWithBindData?title=grails-exclude&description=exclude-demo
    def saveWithBindData() {
        Book book = new Book()
        bindData(book, params, [exclude: 'description'])
        book.save()
        redirect action: 'list'
    }

    //http://localhost:8080/Controllers-II/book/paramConversionMethods?age=10&names=obama&names=osama&dob=3-12-2012
    def paramConversionMethods() {
        println "Data type of params.age : " + params.age?.class
        Integer age = params.int("age")

        println "Data type of params.names : " + params.names?.class
        List names = params.list('names')

        println "Data type of params.dob : " + params.dob?.class
        Date dob = params.date('dob', 'dd-MM-yyyy')

        println "Age: ${age}"
        println "Names : ${names}"
        println "Date of Birth : " + dob
        render("Done !!!")
    }

    //http://localhost:8080/Controllers-II/book/bindParamsToArguments?age=10&name=salman
    def bindParamsToArguments(Integer age, String name) {
        println "Age: ${age}"
        println "Name : ${name}"
        render("Age $age - Name $name")
    }

    //http://localhost:8080/Controllers-II/book/dateBinding?title=grails-date&publishedDate=2-12-2012
    //Error demo as well removing bindData and binding with implicit constructor, message.properties date format ?
    def dateBinding() {
        Book book = new Book()
        bindData(book, params, [exclude: 'publishedDate'])
        println "Published Date in book ${book.publishedDate}"
        book.publishedDate = params.date('publishedDate', 'dd-MM-yyyy')
        book.save()
        redirect action: 'list'
    }

    //http://localhost:8080/Controllers-II/book/addAuthor?title=grails-date&author.id=1
    def addAuthor() {
        Book book = new Book(params)
        book.save()
        redirect(action: 'list')
    }

}
