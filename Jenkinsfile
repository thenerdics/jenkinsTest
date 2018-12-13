#!/usr/bin/env groovy


try {
    pipelineJob('example') {
        definition {
            cps {
                script(readFileFromWorkspace('project-a-workflow.groovy'))
                sandbox()
            }
        }
    }
} catch (exc) {
    echo 'Something failed, I should sound the klaxons!'
    currentBuild.result = 'FAILEDZZZZ'
}