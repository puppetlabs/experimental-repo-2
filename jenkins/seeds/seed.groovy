def value_stream = "experimental"
def owner_name = "waynr"
def project_name = "experimental-repo-2"
def branch_name = "${P_GIT_BRANCH_NAME}"

pipelineJob("${value_stream}_${project_name}_workflow_${branch_name}") {
  scm {
    git("git@github.com:${owner_name}/${project_name}.git")
  }
  triggers {
    upstream("${value_stream}_experimental-repo-1_workflow")
    scm("H/5 * * * *")
  }
  definition {
    cpsScm {
      scm {
        git {
          remote {
            name("github")
            url("git@github.com:${owner_name}/${project_name}.git")  
          }
          branch(branch_name)
        }
      }
      scriptPath("jenkins/pipelines/pipe-1.groovy")
    }
  }
}
