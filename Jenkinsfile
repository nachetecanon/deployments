#!/usr/bin/env groovy
@Library('predictx-ci@develop')

def job = new  main.groovy.net.predictx.flow.GradleFlow(this)

job.exec({
    job.checkoutCode()

    if (!job.delegateMerge()) {

        stage("gradleCleanUnitTest") {
          job.gradle "clean build"
        }

        job.dockerBuild(null, "cli")

        job.dockerPush()
      }
})