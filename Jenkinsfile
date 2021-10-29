pipeline {

    agent any

    triggers {
        cron('H */8 * * *')
        pollSCM('* * * * *')
    }

    stages {
        stage('Checkout') {
            steps { 
                checkout changelog: true, poll: true, scm: [$class: 'GitSCM', branches: [[name: '*/master']], browser: [$class: 'BitbucketWeb', repoUrl: 'https://web.com/blah'], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git', url: 'https://github.com/SONGYI-chen123/shop.git']]]
            }
        }
        stage('Unit & Integration Tests') {
            steps {
                script {
                    try {
                        sh './gradlew clean test --no-daemon' //run a gradle task
                    } finally {
                        junit '**/build/test-results/test/*.xml' //make the junit test results available in any case (success & failure)
                    }
                }
            }
        }
        stage('deploy') {
            steps {
                echo 'deploy'
            }
        }
    }
}