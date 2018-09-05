package com.predict.deployer

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CliApplication : CommandLineRunner {
    private val logger = LoggerFactory.getLogger("com.predict.deployer.CliApplication")

    override fun run(vararg args: String?) {
        args?.iterator().forEachRemaining {
            logger.info("param $it")
        }

    }
}

