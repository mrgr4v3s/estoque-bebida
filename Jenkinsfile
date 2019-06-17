pipeline {
  agent any
  stages {
    stage('Execute Sonar Scan') {
      steps {
        withSonarQubeEnv(installationName: 'LocalSonar')
      }
    }
    stage('Quality Gate') {
       timeout(time: 1, unit: 'HOURS') { 
      def qg = waitForQualityGate()
      if (qg.status != 'OK') {
        error "Pipeline aborted due to quality gate failure: ${qg.status}"
      }
    }
  }
}
