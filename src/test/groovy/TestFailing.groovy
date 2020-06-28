import spock.lang.Specification

class TestFailing extends Specification{

    def "expect square is wrong, check out the stacktrace"(){
        expect:
        Math.sqrt(4) == 4
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
