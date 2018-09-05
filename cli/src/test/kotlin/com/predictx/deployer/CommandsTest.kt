package com.predictx.deployer

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CommandsTest {


    @Test
    fun testArgumentsAdmitSeveralFormats() {
        val params = mutableListOf("Deploy", "DePloy")
        Command.processArguments(params)
        assertTrue(Command.commands.size == 1)
    }

}