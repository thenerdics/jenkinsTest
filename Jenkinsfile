#!/usr/bin/env groovy


node {
    parameters {
        string(x: 'manvir', defaultValue: 'manvir', description: 'Who should I say hello to?')
    }
   def greeting = { String x, int y ->                                
    println "hey ${x} the value is ${y}"
    }
    greeting
}

