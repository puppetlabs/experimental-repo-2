workflowJob('experimental_experimental-repo-2_workflow') {
  scm {
    git('git@github.com:puppetlabs/experimental-repo-2.git')
  }
  triggers {
    scm('H/5 * * * *')
  }
  definition {
    cpsSCm {
      scm {
        git('git@github.com:puppetlabs/experimental-repo-2.git')
      }
      scriptPath('Jenkinsfile')
    }
  }
}
