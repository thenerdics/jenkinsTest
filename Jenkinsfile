pipeline {
    agent any
    parameters{
        string(defaultValue:"increment",description:"What increment?", name:'increment')
    }
    tools { 
        maven 'jenkins-mani' 
        
    }
    stages {
        stage ('Maven increment') {
            steps {
                script {
                    checkout scm
                    def updateversion = load("variables/vars/updateVersion.groovy")
                    def choice = "${params.increment}"

                    println "${choice}"
                    updateversion.mavenIncrement()
                    def mvnVersion = sh (script: "mvn build-helper:parse-version | grep Building | cut -d ' ' -f4", returnStdout: true)
                    if (mvnVersion){
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
                script {
                    checkout scm
                    updateversion.npmIncrement(choice)
                }
            }
        }
    }
}