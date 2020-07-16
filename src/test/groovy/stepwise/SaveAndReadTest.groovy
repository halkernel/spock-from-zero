package stepwise

import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import org.apache.http.HttpResponse
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise //will execute the tests in the order they are declared
class SaveAndReadTest extends Specification{

    def baseUri = 'http://localhost:8080'
    def endpoint = '/persons'
    RESTClient restClient;

    @Shared //it shares the variable between the two tests that are using
    HttpResponse response

    def createPerson(){
        [ id:'1', age:'24', name:'Kennet', surname:'Calixto', email:'kennet.emerson@gmail.com' ]
    }

    def setup(){
        restClient = new RESTClient(this.baseUri, ContentType.JSON)
    }

    def 'should create a person'(){
        given:
        def person = this.createPerson()

        when:
        response = this.restClient.post(
                path: this.endpoint,
                body: person)

        then: 'validating response'
        response.getStatusLine().statusCode == 201

        and: 'validating response body'
        response.data.age == person.age.toInteger()
        response.data.name == person.name
        response.data.surname == person.surname
        response.data.email == person.email

    }

    def 'should get 200 when a resource is successfully found'(){
        given:
        def endpoint = endpoint + '/' + this.response.data.id

        when:
        HttpResponse response = this.restClient.get(
                path: endpoint)

        then: 'validating response'
        response.getStatusLine().statusCode == 200
    }



}
