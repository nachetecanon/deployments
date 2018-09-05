package com.predictx.deployer

import spock.lang.Specification

class CommanderSpec extends Specification {
    def 'commands should be filled if the correct ones are provided'() {
        given:
        def params = List.of("Deploy", "DePloy")
        params=List.of("")
        def expectedResult = List.of("DEPLOY")
        when:
        Command.processArguments(params)

        then:
        expectedResult == Command.commands


    }
}