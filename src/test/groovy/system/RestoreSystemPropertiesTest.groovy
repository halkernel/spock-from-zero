package system

import spock.lang.See
import spock.lang.Specification
import spock.util.environment.OperatingSystem
import spock.util.environment.RestoreSystemProperties

class RestoreSystemPropertiesTest extends Specification{

    @RestoreSystemProperties //test got from:
    @See('http://spockframework.org/spock/docs/1.1-rc-1/all_in_one.html') //it accepts an array and it is used to indicate references on web, articles i.e.
    def "determines family based on os.name system property"() {
        given:
        System.setProperty('os.name', 'Windows 7')

        expect:
        OperatingSystem.current.family == OperatingSystem.Family.WINDOWS
    }


    def "check if the os.name is Linux after restore"() {
        expect:
        OperatingSystem.current.family == OperatingSystem.Family.LINUX
    }

}
