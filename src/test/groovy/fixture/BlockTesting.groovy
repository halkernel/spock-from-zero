package fixture

import spock.lang.Specification





class BlockTesting extends Specification{


    def "the order of testing"() {
        //both setup: or given: works here but setup doesn't works
        //with given:, when: and then:

        //given:
        //when it is necessary to configure an specific scenario
        //for a single test case, it is done inside here
        //cannot be used with :setup

        //when:
        //the block where the event to be tested must be executed
        //the first block to be executed after given:
        //cannot be used with setup:

        //and:
        //can be used after any block

        //then:
        //then: cannot be used along with setup:
        //used combined with when or the and: blocks

    }

        //expect: cannot be used with given: and when:
        //always alone or after setup

        //cleanup: //after everything


        //so, considering these blocks above, there are two kinds
        //of patterns that can be adopted for phase-test, these are
        //four-phase and three-phase, for four-phase-test they are:

        //def "four phase test execution"(){
        //setup:
        //and:
        //expect:
        //cleanup:
        //}

        //the three-phase-test is a block made of given -> when -> then:

    def "three phase test execution sample"(){
        given:
        int a = 2;
        int expec = 4;

        when:
        int exp = Math.pow(a,a)

        then:
        exp == expec
    }

}


