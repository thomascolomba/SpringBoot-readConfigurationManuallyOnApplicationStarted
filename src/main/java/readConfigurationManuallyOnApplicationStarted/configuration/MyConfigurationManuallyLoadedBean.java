package readConfigurationManuallyOnApplicationStarted.configuration;

import org.springframework.stereotype.Component;

@Component
public class MyConfigurationManuallyLoadedBean {
	private Integer myInt1;
	private Integer myInt2;
	public Integer getMyInt1() {
		return myInt1;
	}
	public void setMyInt1(Integer myInt1) {
		this.myInt1 = myInt1;
	}
	public Integer getMyInt2() {
		return myInt2;
	}
	public void setMyInt2(Integer myInt2) {
		this.myInt2 = myInt2;
	}
}
