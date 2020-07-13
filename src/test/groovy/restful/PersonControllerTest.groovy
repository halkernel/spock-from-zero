package restful

import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import org.apache.http.HttpResponse
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
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

    def 'should get 400 ao when a person attempted to be created with invalid payload'(){
        given: 'age contains invalid value in order to throw 400'
        def person = [id:'1', age:'age', name:'Kennet', surname:'Calixto', email:'kennet.emerson@gmail.com']

        when:
        HttpResponseException response = this.restClient.post(
                path: this.endpoint,
                body: person)

        then: 'validating response'
        thrown(HttpResponseException)
        print( response)



    }



}
