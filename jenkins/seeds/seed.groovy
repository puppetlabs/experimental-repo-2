def value_stream = "experimental"
def owner_name = "waynr"
def project_name = "experimental-repo-2"
def branch_name = "master"

println " P_GIT_BRANCH_NAME = ${P_GIT_BRANCH_NAME}"

pipelineJob("${value_stream}_${project_name}_workflow") {
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
        git("git@github.com:${owner_name}/${project_name}.git")
      }
      scriptPath("jenkins/pipelines/pipe-1.groovy")
    }
  }
}
