package basic.web.app;

import java.io.*;
import java.util.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;

public class LottoTag extends SimpleTagSupport {

	private int digitCount = 6;
	private String digitVar;
	private Random rdm = new Random();

	public void setDigitCount(int value) { digitCount = value; }

	public void setDigitVar(String name) { digitVar = name; }

	@Override
	public void doTag() throws JspException, IOException {
		var context = super.getJspContext();
		var body = super.getJspBody();
		for(int i = 0; i < digitCount; ++i){
			int digitVal = rdm.nextInt(10);
			context.setAttribute(digitVar, digitVal);
			body.invoke(null);
		}
	}

}

