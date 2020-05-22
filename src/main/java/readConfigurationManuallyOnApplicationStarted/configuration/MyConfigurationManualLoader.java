package readConfigurationManuallyOnApplicationStarted.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import readConfigurationManuallyOnApplicationStarted.util.MyNullAwareBeanUtilBean;

@Component
public class MyConfigurationManualLoader implements ApplicationListener<ApplicationStartedEvent>{

	@Autowired
	MyConfigurationManuallyLoadedBean myJsonConf;
	
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		loadJsonConfigurationFilesIntoASingleBean();
	}
	
	private void loadJsonConfigurationFilesIntoASingleBean() {
		try {
			loadJsonConfigurationIntoBean("myConfiguration1.json", myJsonConf);
			loadJsonConfigurationIntoBean("myConfiguration2.json", myJsonConf);
		} catch (IllegalAccessException | InvocationTargetException | IOException e) {
			// I could log this
			e.printStackTrace();
		}
	}
	
	private void loadJsonConfigurationIntoBean(String jsonResourceName, Object beanToPopulate) throws JsonParseException, JsonMappingException, IllegalAccessException, InvocationTargetException, IOException {
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream(jsonResourceName);
		new MyNullAwareBeanUtilBean().copyProperties(beanToPopulate, new ObjectMapper().readValue(stream, beanToPopulate.getClass()));
	}
}
