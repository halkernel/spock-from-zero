package fixture

import spock.lang.Specification

class FixtureOrder extends Specification{

    /*
    *   Execution order is:
    *   setupSpec
    *   setup
    *       then the test method is executed
    *   cleanup
    *   if isThereAnyTestToBeExecuted
    *       goto setupSpec
    *   cleanUpSpec
    */

    def setupSpec(){}

    def setup(){}

    def "testin method"(){

    }

    def cleanup(){}

    def cleanupSpec(){}


}
