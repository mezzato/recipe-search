[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for org.recipesearch:recipe-search-core:jar:1.0-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-resources-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 307, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 288, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-surefire-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 296, column 12
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for org.recipesearch:recipe-search-hibernatesearch:jar:1.0-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-resources-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 307, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 288, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-surefire-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 296, column 12
[WARNING] The expression ${pom.groupId} is deprecated. Please use ${project.groupId} instead.
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for org.recipesearch:recipe-search-web:war:1.0-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-resources-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 307, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 288, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-surefire-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 296, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-war-plugin is missing. @ line 26, column 12
[WARNING] The expression ${pom.groupId} is deprecated. Please use ${project.groupId} instead.
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for org.recipesearch:recipe-search-webservices:war:1.0-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-resources-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 307, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 288, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-surefire-plugin is missing. @ org.recipesearch:recipe-search:1.0-SNAPSHOT, C:\Users\AE14665\workspace\recipe-search\pom.xml, line 296, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-war-plugin is missing. @ line 25, column 12
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for org.recipesearch:recipe-search:pom:1.0-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-resources-plugin is missing. @ line 307, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 288, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-surefire-plugin is missing. @ line 296, column 12
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO] 
[INFO] Recipe Search Example
[INFO] recipe-search Core
[INFO] lambico-search-hibernatesearch
[INFO] Parancoe Based Web Search Application
[INFO] recipe-search Web Service Application
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Recipe Search Example 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO] 
[INFO] Recipe Search Example ............................. FAILURE [0.168s]
[INFO] recipe-search Core ................................ SKIPPED
[INFO] lambico-search-hibernatesearch .................... SKIPPED
[INFO] Parancoe Based Web Search Application ............. SKIPPED
[INFO] recipe-search Web Service Application ............. SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.494s
[INFO] Finished at: Sat Jul 14 18:08:19 CEST 2012
[INFO] Final Memory: 4M/15M
[INFO] ------------------------------------------------------------------------
[ERROR] Unknown lifecycle phase "recipe-search-webservices". You must specify a valid lifecycle phase or a goal in the format <plugin-prefix>:<goal> or <plugin-group-id>:<plugin-artifact-id>[:<plugin-version>]:<goal>. Available lifecycle phases are: validate, initialize, generate-sources, process-sources, generate-resources, process-resources, compile, process-classes, generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, test-compile, process-test-classes, test, prepare-package, package, pre-integration-test, integration-test, post-integration-test, verify, install, deploy, pre-site, site, post-site, site-deploy, pre-clean, clean, post-clean. -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/LifecyclePhaseNotFoundException
