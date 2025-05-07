// TEAM MEMBERS:

// Abhinav Veeragandham - G01515455
// Pranav Vangavety - G01511443
// Charan Sri Sai Devalla - G01504177
// Bhogeswara Pathakamudi - G01507114
// Durga Shankar Kondaveeti - G01510533

package com.assignment4;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentSurveyApplication.class);
	}

}
