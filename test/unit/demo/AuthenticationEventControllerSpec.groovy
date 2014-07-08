package demo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(AuthenticationEventController)
class AuthenticationEventControllerSpec extends Specification {

    void "Test that the index redirects for non-ajax calls"() {
        when:
        controller.index()

        then:
        response.redirectedUrl == '/main'
    }

    void "Test that index renders template for ajax calls"() {
        given:
        request.makeAjaxRequest()
        views['/authenticationEvent/_index.gsp'] = 'my template text'

        when:
        controller.index()

        then:
        response.contentAsString == 'my template text'
    }
}
