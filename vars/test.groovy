#!/usr/bin/env groovy
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
	    // Clean workspace before doing anything
	    deleteDir()

	    try {
	        println "TESTS"
	    } catch (err) {
	        throw err
	    }
    }
}

