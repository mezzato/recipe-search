[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for org.recipesearch:recipe-search-hibernatesearch:jar:0.0.1-SNAPSHOT
[WARNING] The expression ${pom.groupId} is deprecated. Please use ${project.groupId} instead.
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for org.recipesearch:recipe-search-web:war:0.0.1-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-resources-plugin is missing. @ line 33, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-surefire-plugin is missing. @ line 22, column 12
[WARNING] The expression ${pom.groupId} is deprecated. Please use ${project.groupId} instead.
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for org.recipesearch:recipe-search-webservices:war:0.0.1-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-resources-plugin is missing. @ line 241, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-surefire-plugin is missing. @ line 230, column 12
[WARNING] The expression ${pom.groupId} is deprecated. Please use ${project.groupId} instead.
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO] 
[INFO] Recipe Search Example
[INFO] recipe-search-core
[INFO] lambico-search-hibernatesearch
[INFO] Parancoe Based Web Search Application
[INFO] Simple CXF JAX-RS webapp service using spring configuration
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Recipe Search Example 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO] 
[INFO] Recipe Search Example ............................. FAILURE [0.003s]
[INFO] recipe-search-core ................................ SKIPPED
[INFO] lambico-search-hibernatesearch .................... SKIPPED
[INFO] Parancoe Based Web Search Application ............. SKIPPED
[INFO] Simple CXF JAX-RS webapp service using spring configuration  SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.298s
[INFO] Finished at: Sat Jul 14 03:10:49 CEST 2012
[INFO] Final Memory: 3M/15M
[INFO] ------------------------------------------------------------------------
[ERROR] Unknown lifecycle phase "recipe-search-webservices". You must specify a valid lifecycle phase or a goal in the format <plugin-prefix>:<goal> or <plugin-group-id>:<plugin-artifact-id>[:<plugin-version>]:<goal>. Available lifecycle phases are: validate, initialize, generate-sources, process-sources, generate-resources, process-resources, compile, process-classes, generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, test-compile, process-test-classes, test, prepare-package, package, pre-integration-test, integration-test, post-integration-test, verify, install, deploy, pre-clean, clean, post-clean, pre-site, site, post-site, site-deploy. -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/LifecyclePhaseNotFoundException
