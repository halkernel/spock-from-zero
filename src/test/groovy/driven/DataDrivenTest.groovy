package driven

import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenTest extends Specification{

    def "a to the power of b returns c"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c

        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }

    def "string a to upper case returns b"(String a, String b){
        expect:
        a.toUpperCase().equals(b)

        where:
        a           | b
        "My"        | "MY"
        "Name"      | "NAME"
        "is"        | "IS"
        "Methos"    | "METHOS"
    }


    //methods that were annotated with unroll will replace #a
    //and #b with the test results and values inputted
    //also, any failed test inside where won't prevent
    //the others to run
    @Unroll
    def "testing #a failed uppercase parsing to #b"(String a, String b){
        expect:
        a.toUpperCase().equals(b)

        where:
        a           | b
        "My"        | "MY"
        "Name"      | "NAME"
        "is"        | "IS"
        "Methos"    | "METHOS"
    }

}
