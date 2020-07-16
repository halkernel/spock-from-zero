package timeout

import com.spock.general.Calculate
import spock.lang.Specification
import spock.lang.Timeout

import java.util.concurrent.TimeUnit

class TimeoutTest extends Specification{

    @Timeout(value = 3, unit = TimeUnit.MINUTES)
    def "timeout test"(){
        given:
        def exp = 4

        when:
        def res = Calculate.calculateMean(4,4)

        then:
        res == exp
    }

}
