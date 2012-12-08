webapp-template-spring
======================

Spring webapp template

# Back End

- Spring Java Configuration

- Servlet 3.0 Java Configuration

- Utf-8 encoding enabled

- Environemnt Profile specific setups

# Environment Support



-- Profile		Environment				Server		Setup
------------------------------------------------
-- local		Local Development		Jetty		HSQLDB
-- dev			Development				Jetty		MySQL
-- test			Test					Jetty		MySQL
-- int 			Integration				Jetty		MySQL
-- demo 		Demo					Jetty		MySQL
-- stage 		Staging					Jetty		MySQL
-- prod 		Production				Jetty		MySQL



# Logging

-- Colorful logs with logback.

-- Username included in logs through Logback MDC

-- Logs Rolled around every day

-- Environment Specific loggings


# Security

- Spring Sequrity with Remember Me functionality



# Testing

- JUnit 4.11 with Hamcrest 1.3 and FEST ?.? asserts to enchase test readability

- Selenium 2/WebDriver Testing Framework

-- Page Object Pattern Test Structure

-- Bot Style Test to enchase test readability




# Front End

-- Wicket

-- Spring MVC

--- Thymeleaf Templates (with Apache Tiles)

--- JSP 3.0 (with Apache Tiles)

-- Versioned css

-- Uses Compass/Sass css preprocessor configured with Maven

-- Style Guides based on Twitter Bootstrap/jQuery UI/JQuery Plugins

-- (Yeoman ???)

-- JavaScript Libraries Included by default

--- Twitter Bootstrap as Primary Framework

--- jQuery UI as Secondary Framework

--- jQuery

--- Underscore.js



# TODO

-- All that is missing from above mentioned features

- JMX support

-- Add Logback JMX

-- Add Spring JMX

-- Add Secured Builtin JMX Web Interface supprot with JMiniX

- Web Interface to see logs www.appname.org/logs

- Add Coding Conventions, Design Conventions and Design Guides

- Using JSR 303 Validation

- Usning Spring Conversion Service with language translations

- Provide Login example

- Provide User Management example

-enable sass/compass maven
