package exception

import spock.lang.Specification
import com.spock.CalculateAge

class ExpectedExceptionTest extends Specification{

    def calculateAge = new CalculateAge()

    def "expected IllegalArgumentException thrown when age is 0"(){
        given:
        def age = 0

        when:
        calculateAge.isUnderAge(age)

        then:
        thrown(IllegalArgumentException)
    }

    //exception with more details
    def "expected IllegalArgumentException thrown when age is invalid"(){
        given:
        def age = -20

        when:
        calculateAge.isUnderAge(age)

        then:
        def ex = thrown(IllegalArgumentException)
        ex.message == "Age cannot be $age"
    }

}
