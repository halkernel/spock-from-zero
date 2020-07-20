package integTest

import com.spock.SpockStudyingApplication
import com.spock.controller.PersonController
import com.spock.model.Person
import com.spock.repository.PersonRepository
import com.spock.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import spock.lang.Specification
import spock.lang.Stepwise

@SpringBootTest(classes = SpockStudyingApplication.class)
@Stepwise
class PersonControllerTest extends Specification {

    @Autowired
    PersonController controller

    @Autowired
    PersonRepository repository

    @Autowired
    PersonService service;

    def createPerson(){
        Person person = new Person()
        person.setId(1)
        person.setAge(24)
        person.setName("Kennet")
        person.setSurname("Calixto")
        person.setEmail("kennet.emerson@gmail.com")
        return person
    }

    def 'should return 204 when no person is found'() {
        when:
        def resposta = controller.getPersons()

        then:
        resposta.statusCode == HttpStatus.NO_CONTENT
        !resposta.body
    }

    def 'should return 400 when payload is not present or invalid'() {
        when:
        def resposta = controller.createPerson(new Person())

        then:
        resposta.statusCode == HttpStatus.BAD_REQUEST
    }

    def 'should return 201 when person is created correctly'(){
        given:
        def person = createPerson()

        when:
        def response = controller.createPerson(person)

        then:
        response.statusCode == HttpStatus.CREATED
        response.body.properties == person.properties
    }


}

