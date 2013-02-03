import bootcamp.demo.Author

class BootStrap {

    def init = { servletContext ->
        createSampleAuthors()
    }


    def destroy = {
    }

    void createSampleAuthors() {
        if (!Author.count()) {
            new Author(name: "Bond").save()
            new Author(name: "Batman").save()
        }
    }
}
