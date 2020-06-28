package basics

import spock.lang.Specification



class CollectionsTest  extends Specification{

    //these tests are going to fail
    //check out the stacktrace to understand

    def "check equality of two lists"(){
        expect:
        def list1 = ["hey", "listen"]
        def list2 = ["hey", "mister"]
        list1 == list2
    }

    def "check equality of maps"(){
        expect:
        def map1 = ["kennet":21, "emerson":24]
        def map2 = ["kennet":21, "emerson":25]
        map1 == map2
    }
}
