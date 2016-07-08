def value_stream = "experimental"
def group_name = "puppetlabs"
def project_name = "experimental-repo-2"
def branch_api = new URL("https://api.github.com/repos/${group_name}/${project_name}/branches")
def branches = new groovy.json.JsonSlurper().parse(branch_api.newReader())

branches.each {
  def branch_name = it.name

  pipelineJob('${value_stream}_${project}_workflow') {
    scm {
      git('git@github.com:${group_name}/${project_name}.git')
    }
    triggers {
      upstream('${value_stream}_experimental-repo-1_workflow_${branch_name}')
      scm('H/5 * * * *')
    }
    definition {
      cpsScm {
        scm {
          git('git@github.com:${group_name}/${project_name}.git')
        }
        scriptPath('Jenkinsfile')
      }
    }
  }
}
