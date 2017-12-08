Sample code with using [Byte Buddy](http://bytebuddy.net/#/) and [Java Agent](https://docs.oracle.com/javase/8/docs/api/java/lang/instrument/package-summary.html).

## usage

run `com.jyukutyo.Main` class.

Java agent changes `toString` method globally before class loading, so toString method of Main class returns a fixed valud "transformed".
