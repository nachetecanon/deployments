package com.predictx.deployer

import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("CliApplication")

/**
 * allowed commands
 */
enum class CommandType {
    DEPLOY
}

val errorMsg = "Invalid argument. You must provide one of: ${CommandType.values()}"


class CliApplication {
    fun main(args: Array<String>) {
        Command.processArguments(args.toMutableList())
    }

}

/**
 * static class representing the commands introduced into the application
 */
class Command {
    companion object {
        val commands : Array<CommandType> = emptyArray()
        /**
         * fills the commands list of permitted commands
         * exits with exception if no args passed or
         */
        fun processArguments(args: MutableList<String>) {
            try {
                args.iterator().forEachRemaining {
                    commands.plusElement(CommandType.valueOf(it))
                }
            } catch (e: Exception) {
                logger.error(errorMsg)
            }
            require(commands.isNotEmpty()) {
                errorMsg
            }
        }
    }
}


