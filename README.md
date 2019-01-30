# CodeAnalyzer
A RESTful service that analyzes code style for more than 10 popular languages. Made with Java + Spring framework.


RESTful Server usage: "java -jar RESTfulCommentAnalyzer.jar"

Supported Languages:
- Java
- Scala
- Objective C
- Javascript
- Swift
- Python
- HTML
- CSS
- Ruby
- Perl

* I have deployed the RESTful API to Azure, you can access it from http://api.code.markyhzhang.com/submit/
* If you want to run it locally, access it from http://localhost:8080/submit/

* MAKE SURE THE ENDPOINT IS "submit/" not "submit" don't forget the "/"

Sample RESTful Request :
{
  "fileName": "test.java",
  "base64EncodedData": "LyoKd293bwp3b3dvb3cKICovCgogLy9UT0RPIHN0dWZmCiBTeXN0ZW0ub3V0LnByaW50bG4oIndvd28iKSAvL3dvd293b293b3dvdzsKCiAvL3dvd293b293b3d3"
}

*** Make sure you send in the data with base64 encoded

Sample Response:
{"totalLineCnt":9,"singleCommentLinesCnt":3,"blockCommentCnt":1,"blockCommentLinesCnt":4,"todoCnt":1,"totalCommentCnt":7}
