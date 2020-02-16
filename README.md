java-color-loggers
==================

Color console logging for log4j and jdk

## Usage

* Download the latest color-loggers jar from [releases](https://github.com/mihnita/java-color-loggers/releases) or build them yourself
* Download [jansi-1.18.jar](https://fusesource.github.io/jansi/download.html) - optional, see below<br />
(`jansi-1.18` is the latest one at this time, but I use nothing fancy, so I don't expect surprises with other versions)
* Make sure the jar(s) mentioned above are somewhere in the `classpath` (whatever method you are using for your project)

On Mac OS X, Linux, UNIX, most (all?) the consoles support ANSI escapes.

ANSI escapes work out of the box in Windows 10.

On older Windows versions you can use the [ConEmu console](https://conemu.github.io/),
or the standard Windows console with [ansicon](https://github.com/adoxa/ansicon/downloads/)
and the `AnsiColorConsole*` flavors of the loggers.
But if you want the standard Windows console without `ansicon`,
then you should use `JAnsiColorConsole*` and you also need `jansi`.

There are pros and cons for each option, I hope to write an article when I have some time.

---

### JDK (or JUL, `java.util.logging`)

In the java logging configuration file (default in `$JAVA_HOME/lib/logging.properties`)
use `com.mihnita.colorlog.jdk.AnsiColorConsoleHandler`
or `com.mihnita.colorlog.jdk.JAnsiColorConsoleHandler` as handler.

They work the same as `java.util.logging.ConsoleHandler`.

See an example in `src/test/resources/logJdk.properties`

---

### Log4j

In `log4j.properties` (or whatever config file you use for log4j)
use `com.mihnita.colorlog.log4j.AnsiColorConsoleAppender`
or `com.mihnita.colorlog.log4j.JAnsiColorConsoleAppender` as appender.

They work the same as `org.apache.log4j.ConsoleAppender`.

See an example in `src/test/resources/log4j.properties` or `src/test/resources/log4j.xml`

---

### Logback

Logback already allows for colored output using jansi, but does not allow configuring the colors.
But now, with `java-color-loggers`, you can.

In `logback.xml` (or whatever config file you use for Logback) find the appender that
uses `ch.qos.logback.core.ConsoleAppender`, find the `encoder` element, and add a `class`
attribute with the value of `com.mihnita.colorlog.logback.ColorPatternLayoutEncoder`.

And as children of the `encoder` element you can add the following elements to configure the colors:
```
 <errorColor>1;31</errorColor>
 <warningColor>1;33</warningColor>
 <infoColor>32</infoColor>
 <debugColor>36</debugColor>
 <traceColor>1;30</traceColor>
 ```

The values should be valid ANSI escape sequences, without the `{esc}[` and without the final `m`.

See an example in `src/test/resources/logback.xml`

---

### Log4j 2

Log4j 2 supports colors out of the box, see
https://logging.apache.org/log4j/2.x/manual/layouts.html#enable-jansi

---

### SLF4J

Nothing special about it, you configure the logger “underneath it”
(`jdk` or `log4j` or `logback`).

---

## Status

**Build:** [![Build Status](https://travis-ci.org/mihnita/java-color-loggers.png)](https://travis-ci.org/mihnita/java-color-loggers)

**DepShield:** ![DepShield Status](https://depshield.sonatype.org/badges/mihnita/java-color-loggers/depshield.svg)

---

## Building

```
mvn clean install
```

But `maven` (or maybe `junit`?) “hijacks” the output of the test.
So not all the lines that would normally be colored are colored in the `maven` test.
The best way to try things is to run the tests in `ColorLogTest.java` as a normal
application against the final jar (with the 3rd party jars in “the right place”).
