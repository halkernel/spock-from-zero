import spock.lang.Specification





//every spock test must be a subclass of specification
class MathTest extends Specification{


    def "one is equal to one"(){
        expect:
        1 == 1
    }

    def "pow of 2"(){
        expect:
        Math.pow(2,2) == 4
    }

    def "square root of 4"(){
        expect:
        Math.sqrt(4) == 2
    }

    //executing an specific class
    //mvn -Dtest=MathTest test
    //gradle -Dtest.single=MathTest test



}
