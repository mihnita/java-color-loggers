java-color-loggers
==================

Color console logging for log4j and jdk

## Usage

* Download the latest color-loggers jar from <a href="https://github.com/mihnita/java-color-loggers/releases">releases</a> or build them yourself
* Download <a href="https://fusesource.github.io/jansi/download.html">jansi-1.17.1.jar</a> - optional, see below<br />
(<code>jansi-1.17.1</code> is the latest one at this time, but I use nothing fancy, so I don't expect surprises with other versions)
* Make sure the jar(s) mentioned above are somewhere in the classpath (whatever method you are using for your project)

On Mac OS X, Linux, UNIX, most (all) the consoles support ANSI escapes.

On Windows this is a bit more complitated. ANSI escapes work out of the box in Windows 10.
On older versions you can use the <a href="https://conemu.github.io/">ConEmu console</a>,
or the standard Windows console with <a href="https://github.com/adoxa/ansicon/downloads">ansicon</a> and the <code>AnsiColorConsole*</code> flavors of the loggers. But if you want the standard Windows console without <code>ansicon</code>, then you should use <code>JAnsiColorConsole*</code> and you also need <code>jansi</code>.

There are pros and cons for each option, I hope to write an article when I have some time.

---

### JDK (or JUL, `java.util.logging`)

* In the java logging configuration file (default in <code>JAVA_HOME/lib/logging.properties</code>) use
* <code>com.mihnita.colorlog.jdk.AnsiColorConsoleHandler</code> or <code>com.mihnita.colorlog.jdk.JAnsiColorConsoleHandler</code>
as handler.<br />
They work the same as <code>java.util.logging.ConsoleHandler</code>.<br />
See an example in <code>src/test/resources/logJdk.properties</code>

---

### Log4j

* In <code>log4j.properties</code> (or whatever config file you use for log4j) use <code>com.mihnita.colorlog.log4j.AnsiColorConsoleAppender</code>
or <code>com.mihnita.colorlog.log4j.JAnsiColorConsoleAppender</code> as appender.<br />
They work the same as <code>org.apache.log4j.ConsoleAppender</code>.<br />
See an example in <code>src/test/resources/log4j.properties</code> or <code>src/test/resources/log4j.xml</code>

---

### Logback

* Logback already allows for colored output using jansi, but does not allow configuring the colors. But now you can.
In <code>logback.xml</code> (or whatever config file you use for Logback) find the appender that uses
<code>ch.qos.logback.core.ConsoleAppender</code>, find the <code>encoder</code> element, and add a <code>class</code> attribute
with the value of <code>com.mihnita.colorlog.logback.ColorPatternLayoutEncoder</code>.<br />
And as children of the <code>encoder</code> element you can add the following elements to configure the colors:
 * <code>&lt;errorColor&gt;1;31&lt;/errorColor&gt;</code>
 * <code>&lt;warningColor&gt;1;33&lt;/warningColor&gt;</code>
 * <code>&lt;infoColor&gt;32&lt;/infoColor&gt;</code>
 * <code>&lt;debugColor&gt;36&lt;/debugColor&gt;</code>
 * <code>&lt;traceColor&gt;1;30&lt;/traceColor&gt;</code>

The values should be valid ANSI escape sequences, without the {esc}[ and the without the final 'm'.<br>
See an example in <code>src/test/resources/logback.xml</code>

---

### Log4j 2

Log4j 2 supports colors out of the box:
https://logging.apache.org/log4j/2.x/manual/layouts.html#enable-jansi

---

### SLF4J

Nothing special about it, you configure the logger "underneath it" (jdk or log4j or logback).

---

## Status

**Build:** [![Build Status](https://travis-ci.org/mihnita/java-color-loggers.png)](https://travis-ci.org/mihnita/java-color-loggers)

**DepShield:** ![DepShield Status](https://depshield.sonatype.org/badges/mihnita/java-color-loggers/depshield.svg)

---

## Building

* <code>mvn clean install</code>

But maven (or maybe junit?) highjacks the output of the test.
So not all the lines that would normally be colored are colored in the maven test.
The best way to try things is to run the tests in ColorLogTest.java as a normal application
against the final jar (with the 3rd party jars in "the right place").
