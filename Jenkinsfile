pipeline {
    agent any
    parameters {
        choice(name: 'Env', choices: ['dev', 'staging', 'production'], description: '测试环境')
        string(name: 'testCycle', defaultValue: 'Cycle-1', description: '测试周期')
        string(name: 'version', defaultValue: '1.0', description: '测试版本')
        choice(name: 'browser', choices: ['firefox', 'safari', 'chrome'], description: '浏览器')
        booleanParam(name: 'released', defaultValue: false, description: '是否已发布')
        booleanParam(name: 'currentRelease', defaultValue: false, description: '是否标记为发布')
        booleanParam(name: 'enablePTApi', defaultValue: false, description: '启用API')
        booleanParam(name: 'signOff', defaultValue: false, description: '启用签收')

        string(name: 'testSuiteName', defaultValue: 'defaultSuite', description: '测试套件名称')
        choice(name: 'runMode', choices: ['full', 'smoke', 'regression'], description: '测试运行模式')
    }
    environment {
        GIT_TOKEN = credentials('GiteeUserNamePass')  // Jenkins 配置 GitHub/GitLab/Gitee 的 API Token
    }
    stages {
        stage('Checkout Code') {
            steps {
                script {
                    checkout scm
                    env.GIT_REPO_URL = sh(script: "git config --get remote.origin.url", returnStdout: true).trim()

                    // 自动检测 Git 平台类型
                    if (env.GIT_REPO_URL.contains("github.com")) {
                        env.GIT_PLATFORM = "GitHub"
                        env.GIT_API_BASE = env.GIT_REPO_URL.replace("https://github.com", "https://api.github.com/repos").replace(".git", "")
                    } else if (env.GIT_REPO_URL.contains("gitlab.com")) {
                        env.GIT_PLATFORM = "GitLab"
                        def encodedRepo = java.net.URLEncoder.encode(env.GIT_REPO_URL.replace("https://gitlab.com/", "").replace(".git", ""), "UTF-8")
                        env.GIT_API_BASE = "https://gitlab.com/api/v4/projects/${encodedRepo}"
                    } else if (env.GIT_REPO_URL.contains("gitee.com")) {
                        env.GIT_PLATFORM = "Gitee"
                        env.GIT_API_BASE = env.GIT_REPO_URL.replace("https://gitee.com", "https://gitee.com/api/v5/repos").replace(".git", "")
                    } else {
                        error "Unsupported Git repository: ${env.GIT_REPO_URL}"
                    }

                    echo "Using Repository: ${env.GIT_REPO_URL}"
                    echo "Detected Git Platform: ${env.GIT_PLATFORM}"
                    echo "Git API Base: ${env.GIT_API_BASE}"
                }
            }
        }

       stages {
               stage('Update test_parameters.properties') {
                   steps {
                       script {
                           // 定义文件名变量
                           def propertiesFile = 'src/test/resources/test_parameters.properties'

                           // 使用 sed 命令更新 test_parameters.properties 文件
                           sh """
                               sed -i 's/^Env=.*/Env=${params.Env}/' ${propertiesFile}
                               sed -i 's/^testCycle=.*/testCycle=${params.testCycle}/' ${propertiesFile}
                               sed -i 's/^version=.*/version=${params.version}/' ${propertiesFile}
                               sed -i 's/^browser=.*/browser=${params.browser}/' ${propertiesFile}
                               sed -i 's/^released=.*/released=${params.released}/' ${propertiesFile}
                               sed -i 's/^currentRelease=.*/currentRelease=${params.currentRelease}/' ${propertiesFile}
                               sed -i 's/^enablePTApi=.*/enablePTApi=${params.enablePTApi}/' ${propertiesFile}
                               sed -i 's/^signOff=.*/signOff=${params.signOff}/' ${propertiesFile}
                               sed -i 's/^testSuiteName=.*/testSuiteName=${params.testSuiteName}/' ${propertiesFile}
                               sed -i 's/^runMode=.*/runMode=${params.runMode}/' ${propertiesFile}
                           """

                           // 打印更新后的 test_parameters.properties 文件内容（用于调试）
                           sh "cat ${propertiesFile}"
                       }
                   }
               }

       stage('Run TestNG Tests') {
            steps {
                script {
                // 解析用户输入的 XML 文件名，去除空格
                def testSuites = params.testSuiteName.tokenize(',').collect { it.trim() }.join(",")

                    sh """
                         mvn clean test -DsuiteXmlFiles=${testSuites}
                    """
                }
            }
        }

        stage('Check for Changes') {
            steps {
                script {
                    def changes = sh(script: "git status --porcelain", returnStdout: true).trim()
                    if (changes) {
                        echo "Changes detected, proceeding to commit and push..."
                    } else {
                        echo "No changes detected, skipping commit and push."
                        currentBuild.result = 'SUCCESS'
                        return
                    }
                }
            }
        }

        stage('Push Changes to Git') {
            steps {
                script {
                    def branchName = "testng-auto-update-${params.testCycle}-${params.version}-${new Date().format('yyyyMMdd-HHmmss')}"
                    sh """
                        git checkout -b ${branchName}
                        git add .
                        git commit -m "Auto-update TestNG test cases for ${params.Env}, Cycle: ${params.testCycle}, Version: ${params.version}"
                        git push origin ${branchName}
                    """

                    env.NEW_BRANCH = branchName
                }
            }
        }

        stage('Create Pull Request') {
            steps {
                script {
                    def prPayload = ""

                    if (env.GIT_PLATFORM == "GitHub") {
                        prPayload = """
                        {
                            "title": "Auto update TestNG tests for ${params.Env}, Cycle: ${params.testCycle}, Version: ${params.version}",
                            "head": "${env.NEW_BRANCH}",
                            "base": "main",
                            "body": "This is an auto-generated PR to merge TestNG updates"
                        }
                        """
                    } else if (env.GIT_PLATFORM == "GitLab") {
                        prPayload = """
                        {
                            "source_branch": "${env.NEW_BRANCH}",
                            "target_branch": "main",
                            "title": "Auto update TestNG tests for ${params.Env}, Cycle: ${params.testCycle}, Version: ${params.version}"
                        }
                        """
                    } else if (env.GIT_PLATFORM == "Gitee") {
                        prPayload = """
                        {
                            "title": "Auto update TestNG tests for ${params.Env}, Cycle: ${params.testCycle}, Version: ${params.version}",
                            "head": "${env.NEW_BRANCH}",
                            "base": "main",
                            "body": "This is an auto-generated PR to merge TestNG updates"
                        }
                        """
                    }

                    def prResponse = sh(script: """
                        curl -X POST -H "Authorization: token ${env.GIT_TOKEN}" \
                             -H "Content-Type: application/json" \
                             -d '${prPayload}' \
                             ${env.GIT_API_BASE}/pulls
                    """, returnStdout: true).trim()

                    echo "PR Response: ${prResponse}"
                }
            }
        }
    }
}
