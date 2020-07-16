package basics

import spock.lang.IgnoreIf
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.util.environment.OperatingSystem

import java.nio.file.Files

class TestIgnoreIf extends Specification{

    @IgnoreIf({System.getProperty('os.name').contains('Linux')})
    def "expect square is wrong, check out the stacktrace"(){
        expect:
        println System.getProperty('os.name')
        Math.sqrt(4) == 2
    }

    //{test got from: https://farenda.com/spock/flexibly-ignore-tests-in-spock-framework/}
    @IgnoreIf({ !jvm.java8Compatible })
    def 'should run only when JDK is compatible with Java 8'() {
        expect:
        System.properties['java.version'] == '1.8.0_251'
    }

    @IgnoreIf({OperatingSystem.Family.LINUX.properties['SHELL']=='/bin/sh'})
    def 'test not executed if the shell is /bin/bash'() {
        expect:
        Math.sqrt(9) == 3
    }



}
