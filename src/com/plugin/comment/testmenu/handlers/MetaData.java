package com.plugin.comment.testmenu.handlers;

import java.time.LocalDate;

public class MetaData {

	final String ORGANIZATION_NAME = "GENPACT";
	final String CLASS_NAME = "MAIN";
	final String PROJECT_NAME = "TEST_POC";
	final String DESCRIPTION = "This is a demo project to understand the working of plugins in eclipse";
	final String VERSION_NUMBER = "0.01";
	final String CURRENT_DATE = LocalDate.now().toString();
	final String AUTHOR_NAME = "CORETEAM_GENAI";
	final String WEBSITE = "www.genpact.com";
	final String EMAIL = "id@genpact.com";
	final String COPYRIGHT_YEAR = "2022";
	final String OPTIONAL = "No information";

	final String DOCUMENTINFO = " \r\n" + "\r\n" + "/**\r\n" + "* Organization:" + ORGANIZATION_NAME + "\r\n" + "*\r\n"
			+ "* This Java class, " + CLASS_NAME + ", is part of the " + PROJECT_NAME + " project\r\n"
			+ "* developed and maintained by " + ORGANIZATION_NAME + ".\r\n" + "*\r\n" + "* Description:\r\n" + "*"
			+ DESCRIPTION + "\r\n" + "*\r\n" + "* Version: " + VERSION_NUMBER + "\r\n"
			+ "* [Optional: Include version information if applicable.]\r\n" + "*\r\n" + "* Author: " + AUTHOR_NAME
			+ "\r\n"
			+ "* [Optional: Include the name of the author, especially if different from the organization.]\r\n"
			+ "*\r\n" + "* Date: " + CURRENT_DATE + "\r\n"
			+ "* [Optional: Include the date of creation or the last update.]\r\n" + "*\r\n"
			+ "* Contact Information:\r\n" + "* - Website: " + WEBSITE + "\r\n" + "* - Email: " + EMAIL + "\r\n"
			+ "*\r\n" + "* Copyright (c) " + COPYRIGHT_YEAR + ORGANIZATION_NAME + "\r\n"
			+ "* All rights reserved. Unauthorized copying of this file, via any medium, is\r\n"
			+ "* strictly prohibited. Proprietary and confidential.\r\n" + "*\r\n" + "* " + OPTIONAL + "\r\n" + "*/";
}
