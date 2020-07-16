package restful

import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import org.apache.http.HttpResponse
import spock.lang.Specification


class PersonControllerTest extends Specification{

    def baseUri = 'http://localhost:8080'
    def endpoint = '/persons'
    RESTClient restClient;

    def createPerson(){
        [ id:'1', age:'24', name:'Kennet', surname:'Calixto', email:'kennet.emerson@gmail.com' ]
    }

    def setup(){
        restClient = new RESTClient(this.baseUri, ContentType.JSON)
        restClient.getClient().getParams().setParameter("http.socket.timeout", new Integer(10000))
    }

    def 'should create a person'(){
        given:
        def person = this.createPerson()

        when:
        HttpResponse response = this.restClient.post(
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

    def 'should get 400 when a person attempted to be created with invalid payload'(){
        given: 'age contains invalid value in order to throw 400'
        def person = [id:'1', age:'age', name:'Kennet', surname:'Calixto', email:'kennet.emerson@gmail.com']

        when:
        this.restClient.post(
                path: this.endpoint,
                body: person)

        then: 'validating response'
        HttpResponseException ex = thrown(HttpResponseException)
        ex.statusCode == 400

    }

    def 'should get 405 when a person is tried to be created with a PUT instead of a POST'(){
        given: 'age contains invalid value in order to throw 405'
        def person = createPerson()

        when:
        this.restClient.put(
                path: this.endpoint,
                body: person)

        then: 'validating response'
        HttpResponseException ex = thrown(HttpResponseException)
        ex.statusCode == 405

    }

    def 'should get 404 when a resource does not exist'(){
        given:
        def endpoint = endpoint + '/5'

        when:
        this.restClient.get(path: endpoint)

        then: 'validating response'
        HttpResponseException ex = thrown(HttpResponseException)
        ex.statusCode == 404

    }

    //TODO get a list of persons and validate if fields are instance of




}
