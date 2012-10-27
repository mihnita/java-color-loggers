java-color-loggers
==================

Color console logging for log4j and jdk

## Usage

* Download the latest color-loggers jar from <a href="https://github.com/mihnita/java-color-loggers/downloads">downloads</a>
* Download <a href="http://jansi.fusesource.org/download.html">jansi-1.9.jar</a> - optional, see below<br />
(<code>jansi-1.9</code> is the latest one at this time, but I use nothing fancy, so I don't expect surprises with other versions)
* Make sure the jar(s) mentioned above are somewhere in the classpath (whatever method you are using for your project)

On Mac OS X, Linux, UNIX, or Windows with <a href="https://github.com/adoxa/ansicon/downloads">ansicon</a> you
can use <code>AnsiColorConsole*</code> flavors of the loggers, but if you want Windows without <code>ansicon</code>,
then you should use <code>JAnsiColorConsole*</code> and you also need <code>jansi</code>.

There are pros and cons for each option, I hope to write an article when I have some time.

### JDK

* In the java logging configuration file (default in <code>JAVA_HOME/lib/logging.properties</code>) use
* <code>com.colorlog.jdk.AnsiColorConsoleHandler</code> or <code>com.colorlog.jdk.JAnsiColorConsoleHandler</code>
as handler.<br />
They work the same as <code>java.util.logging.ConsoleHandler</code>.<br />
See an example in <code>src\test\resources\logJdk.properties</code>

That's all

### LOG4J

* In <code>log4j.properties</code> (or whatever config file you use for log4j) use </code>com.colorlog.log4j.AnsiColorConsoleAppender</code>
or <code>com.colorlog.log4j.JAnsiColorConsoleAppender</code> as appender.<br />
They work the same as org.apache.log4j.ConsoleAppender.<br />
See an example in <code>src\test\resources\log4j.properties</code>

That's all !

### SLF4J

Nothing special about it, you configure the logger "underneath it" (jdk or log4j).

## Building

* <code>mvn clean install</code>
