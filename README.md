Example on how to manually populate a bean with 2 json configuration files with Spring Boot.<br/>
<br/>
How to compile and execute :<br/>
mvn package<br/>
java -jar ./target/readConfigurationManuallyOnApplicationStarted-0.0.1-SNAPSHOT.jar<br/>
<br/>
<br/>
<br/>
---myConfiguration1.json :<br/>
{<br/>
&nbsp;&nbsp;"myInt1":1234<br/>
}<br/>
---myConfiguration2.json :<br/>
{<br/>
&nbsp;&nbsp;"myInt2":5678<br/>
}<br/>
---MyConfigurationManuallyLoadedBean.java<br/>
private Integer myInt1;<br/>
private Integer myInt2;<br/>
+getters and setters<br/>
---MyConfigurationManualLoader.java<br/>
@Autowired<br/>
MyConfigurationManuallyLoadedBean myJsonConf;<br/>
onApplicationEvent(ApplicationStartedEvent event){<br/>
...<br/>
loadJsonConfigurationIntoBean("myConfiguration1.json", myJsonConf);<br/>
loadJsonConfigurationIntoBean("myConfiguration2.json", myJsonConf);<br/>
...<br/>
loadJsonConfigurationIntoBean(String jsonResourceName, Object beanToPopulate) {<br/>
&nbsp;&nbsp;InputStream stream = this.getClass().getClassLoader().getResourceAsStream(jsonResourceName);<br/>
&nbsp;&nbsp;new MyNullAwareBeanUtilBean().copyProperties(beanToPopulate, new ObjectMapper().readValue(stream, beanToPopulate.getClass()));<br/>
---MyConfigurationDisplayer.java<br/>
To display the configuration actually read.<br/>
<br/>
<br/>
The application is meant to manually(without using @PropertySource) read the content of 2 json configuration files and aggregate them on a given object then display that object in the terminal.<br/>
