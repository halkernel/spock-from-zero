package mocking

import com.spock.general.Calculate
import com.spock.general.SayMyName
import spock.lang.Specification

class Mocking extends Specification{

    def sayMyName = new SayMyName(new Calculate())

    def "test mocking of return"(){

        given:
        def errorMessage = "Name is null"
        sayMyName.myNameIs(null, 19) >> {
            throw new NullPointerException(errorMessage)
        }

        when:
        sayMyName.myNameIs(null, 19)

        then:
        def ex = thrown(NullPointerException)
        ex.message == errorMessage
        ex.class == NullPointerException

    }

    def "test call of mocking methods"(){
        given:
        def calculateAge = Mock(Calculate)
        def myName = new SayMyName(calculateAge)

        when:
        myName.myNameIs("Kennet", 24)

        then:
        1 * calculateAge.isUnderAge(24)
    }


}
