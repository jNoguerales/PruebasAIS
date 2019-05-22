pipeline{
  agent any
  
  stages {
    stage('Compile Stage){
      steps{
        withMaven(maven : 'M3'){
          sh 'mvn clean compile'
        }
      }
      
      stage('Test Stage'){
        steps {
          withMaven(maven : 'M3'){
            sh 'mvn test'
          }
        }
      }
      
      stage('Deployment Stage'){
        steps {
          withMaven(maven : 'M3'){
            sh 'mvn deploy'
          }
        }
      }
    }
  
  
  }
}
