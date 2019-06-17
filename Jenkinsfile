pipeline {
  agent any
  stages {
    stage('Execute Sonar Scan') {
      steps {
        withSonarQubeEnv(installationName: 'sonar', credentialsId: 'estoque-sonar')
      }
    }
    stage('') {
      steps {
        waitForQualityGate(credentialsId: 'estoque-sonar', abortPipeline: true)
      }
    }
  }
}