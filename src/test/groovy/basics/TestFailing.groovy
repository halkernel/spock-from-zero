package basics

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class TestFailing extends Specification{

    @Ignore
    def "expect square is wrong, check out the stacktrace"(){
        expect:
        Math.sqrt(4) == 4
    }

    //Math.sqrt(4) == 4
    //     |       |
    //     2.0     false

    @Ignore
    def "expect number is null, check out the stacktrace"(){
        Double val = null
        expect:
        Math.sqrt(val.intValue()) == 2
    }

    @Ignore
    def "comparison is wrong, check out the stacktrace"(){
        expect:
        1 == 2
    }


}
