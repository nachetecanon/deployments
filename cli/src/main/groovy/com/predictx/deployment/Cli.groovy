package com.predictx.deployment

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.util.Assert

@SpringBootApplication(scanBasePackages = "com.predictx.deployment")
class Cli implements CommandLineRunner{
    private final static Logger logger = LoggerFactory.getLogger(Cli)

    static void main(String[] args) {
        SpringApplication.run(Cli, args)
    }

    @Autowired
    Deploy deploy

    @Override
    void run(String... args) throws Exception {
        Assert.isTrue(args && Commands.values().any{it.name() == args.first()}, "Invalid argument. You must provide one of: ${Commands.values()}")
        switch (Commands.valueOf(args.first())) {
            case Commands.deploy: deploy.run(args.tail()); break
        }
    }

    enum Commands {
        deploy
    }
}
