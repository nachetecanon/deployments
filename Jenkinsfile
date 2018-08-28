#!/usr/bin/env groovy
@Library('predictx-ci@develop')

def job = new  main.groovy.net.predictx.flow.GradleFlow(this)

job.exec({
    job.checkoutCode()
})