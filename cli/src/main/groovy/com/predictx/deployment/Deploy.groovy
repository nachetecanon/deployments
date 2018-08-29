package com.predictx.deployment

import groovy.cli.Option
import groovy.cli.Unparsed
import groovy.cli.commons.CliBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

import java.nio.file.Path
import java.nio.file.Paths

@Component
class Deploy{
    private final static Logger logger = LoggerFactory.getLogger(Deploy)

    void run(String... args) throws Exception {
        println "Deployment: $args"
        def cli = new CliBuilder(usage: "deploy [param=value...]")
        def spec = cli.parseFromSpec(DeployCommand, args)
        if (spec.help()) cli.usage()
        logger.info("Deployment dir: {}", spec.deploymentDir())
        logger.info("GCP credentials: {}", spec.gcpCredentialsFile())
        logger.info("Deployment parameters: {}", spec.deploymentParameters())
    }

    interface DeployCommand {
        @Option(shortName='h', description='Display Usage') Boolean help()
        @Option(shortName='d', description='Deployment Directory', convert = { Paths.get(it) }) Path deploymentDir()
        @Option(shortName='c', description='Gcp credentials file location', convert = { Paths.get(it) }) Path gcpCredentialsFile()
        @Unparsed (description = "Deployment parameters") List deploymentParameters()
    }
}
