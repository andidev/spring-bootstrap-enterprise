import ch.qos.logback.classic.html.HTMLLayout
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender
import ch.qos.logback.core.encoder.LayoutWrappingEncoder
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import org.andidev.logging.logback.CustomPatternLayout

import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.INHERITED
import static ch.qos.logback.classic.Level.TRACE
import static ch.qos.logback.classic.Level.WARN

scan()
def USER_HOME = "/Users/anders"
appender("console", ConsoleAppender) {
  target = "System.out"
  encoder("enc", LayoutWrappingEncoder) {
    layout(CustomPatternLayout) {
      param = 
    }
  }
}
appender("file", RollingFileAppender) {
  file = "target/logs/server.log"
  encoder("enc", LayoutWrappingEncoder) {
    layout(CustomPatternLayout) {
      param = 
    }
  }
  rollingPolicy(TimeBasedRollingPolicy) {
    fileNamePattern = "target/logs/server-%d{yyyy-MM-dd}.%i.gz"
    maxHistory = 10
    timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP) {
      maxFileSize = "25MB"
    }
  }
}
appender("html-file", FileAppender) {
  file = "target/logs/server.log.html"
  encoder(LayoutWrappingEncoder) {
    layout(HTMLLayout) {
      pattern = '%d{"HH:mm ss"}%mdc%thread%logger%level%message'
    }
  }
}
logger("org.springframework", INHERITED)
logger("org.hibernate", INHERITED)
logger("jdbc.sqlonly", INHERITED)
logger("jdbc.sqltiming", INHERITED)
logger("jdbc.audit", ERROR)
logger("jdbc.resultset", ERROR)
logger("jdbc.connection", ERROR)
logger("log4jdbc.debug", ERROR)
logger("org.andidev", TRACE)
root(WARN, ["console", "file", "html-file"])