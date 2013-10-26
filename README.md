multipartfile
=============
A simple maven project using spring to handle upload of multipart form data

Setting up:
mvn clean install --> installs all spring jars

Deploy:
After deploying in tomcat, project will accept post request at url : http://localhost:8080/fileapp/
method:post
content:multipart/form-data
requestParams: file, enterpriseId, userId


Testing:
1)Use the html file under src/main/resources to upload file.
2)The uploaded file will be created as <enterprise>_<userid>.txt . Path of the file creation can be specified in config.properties directory parameter.
