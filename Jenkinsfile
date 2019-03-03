
pipeline {
    agent any
    parameters{
        choice(description:"What increment?", name:'increment', choices: ['major','minor','patch'])
    }
    tools { 
        maven 'jenkins-mani' 
        nodejs 'nodejs-mani'
        
    }
    stages {
        stage ('Maven increment') {
            steps {
                script {
                    checkout scm
                    sh 'git stash && git pull'
                    def updateversion = load("variables/vars/updateVersion.groovy")
                    def choice = "${params.increment}"

                    println "${choice}"
                    updateversion.mavenIncrement()
                    def mvnVersion = sh (script: "mvn build-helper:parse-version | grep Building | cut -d ' ' -f4", returnStdout: true)
                    if (mvnVersion){
                        println "Maven package updated to version: ${mvnVersion}"
                        sh """
                            git config --global user.email "manvirbrar1988@gmail.com"
                            git config --global user.name "thenerdics"
                            git add .
                            git commit -am "Mvn pdated to version: ${mvnVersion}"
                        """
                    }
                }
                deleteDir()
            }
        }
        stage ('Node increment') {
            steps {
                script {
                    checkout scm
                    def updateversion = load("variables/vars/updateVersion.groovy")
                    sh 'git stash && git pull'
                    def choice = "${params.increment}"
                    try {
                        updateversion.npmIncrement(choice)
                    }catch(e){
                        println "Something went wrong:\n${e}"
                    }
                    String npmVersion = sh ( script: "cat ./package.json | grep -i version | cut -d ':' -f2 | tr -d '\"'", returnStdout: true )
                    if (npmVersion){
                        echo "Npm package updated to version:${npmVersion}"
                    }
                }
                deleteDir()
            }
        }
    }
}