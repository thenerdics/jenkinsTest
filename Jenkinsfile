pipeline {
    agent any
    checkout scm
    def updateversion = load("variables/vars/updateVersion.groovy")
    parameters{
        string(defaultValue:"increment",description:"What increment?", name:'increment')
    }
    tools { 
        maven 'jenkins-mani' 
        
    }
    stages {
        def choice = "${params.increment}"
        stage ('Maven increment') {
            steps {
                script {
                    println "${choice}"
                    updateversion.mavenIncrement()
                    def mvnVersion = sh (script: "mvn build-helper:parse-version | grep Building | cut -d ' ' -f4", returnStdout: true)
                    if (version){
                        println "Updated to version: ${mvnVersion}"
                        sh """
                        git config --global user.email "manvirbrar1988@gmail.com"
                        git config --global user.name "thenerdics"
                        git add .
                        git commit -am "Updated to version: ${mvnVersion}"
                        """
                    }
                }
                
            }
        }

        stage ('Node increment') {
            steps {
                checkout scm
                updateversion.npmIncrement(choice)
            }
        }
    }
}