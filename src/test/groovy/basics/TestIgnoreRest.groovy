package basics

import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

class TestIgnoreRest extends Specification{

    @IgnoreRest //it can be used in more than one test
    def "expect square is wrong, check out the stacktrace"(){
        expect:
        Math.sqrt(4) == 2
    }

    //Math.sqrt(4) == 4
    //     |       |
    //     2.0     false

    def "expect number is null, check out the stacktrace"(){
        Double val = null
        expect:
        Math.sqrt(val.intValue()) == 2
    }


    def "comparison is wrong, check out the stacktrace"(){
        expect:
        1 == 2
    }


}
