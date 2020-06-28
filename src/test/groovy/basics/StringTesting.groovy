package basics

import spock.lang.Specification





class StringTesting  extends Specification{

    def "uppercase from string should work fine"(){
        expect:
        "hey, listen".toUpperCase().equals("HEY, LISTEN")
    }


    def "substring should work fine"(){
        expect:
        "hello, kennet".substring(7).equals("kennet")
    }
}
