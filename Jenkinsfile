pipeline {
  agent any
  stages {
    stage('development') {
      steps {
        echo 'this is dev'
      }
    }

    stage('QA') {
      steps {
        echo 'this will run tests'
      }
    }

    stage('deployment') {
      steps {
        echo 'This will deploy the code'
      }
    }

  }
}