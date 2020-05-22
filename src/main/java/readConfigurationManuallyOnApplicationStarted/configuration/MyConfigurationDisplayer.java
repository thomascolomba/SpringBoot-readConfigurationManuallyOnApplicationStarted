package readConfigurationManuallyOnApplicationStarted.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyConfigurationDisplayer implements ApplicationListener<ApplicationReadyEvent> {
	@Autowired
	MyConfigurationManuallyLoadedBean myJsonConf;
	
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		System.out.println("Will display the configuration from both myConfiguration1.json and myConfiguration2.json in src/main/resources/");
		System.out.println(myJsonConf.getMyInt1());
		System.out.println(myJsonConf.getMyInt2());
	}
}