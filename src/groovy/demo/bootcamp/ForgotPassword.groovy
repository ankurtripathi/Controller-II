package demo.bootcamp

import grails.validation.Validateable

/**
 * Created with IntelliJ IDEA.
 * User: ankur
 * Date: 4/2/13
 * Time: 6:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Validateable
class ForgotPassword {

    String email

    static constraints = {
        email(email: true)
    }
}
