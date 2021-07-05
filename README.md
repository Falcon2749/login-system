# Login system. Spring Security
Login system with email veryfication and some other basic db functionality

- **The project uses [MailDev](https://github.com/maildev/maildev)(requires [Node.js](https://nodejs.org/en/)).** Go to the links for setting up.  
- **Do not forget to configure _application.context_(src\main\resources) and _SpringConfig_(src/main/java/com.fuser.english)**  
- All url is secured _except_ (/registration/*)  
- You can **_change secured url_** in java config security file (package security -> config).


# Usage
For testing functionality use [Postman](https://go.postman.co/build)
- Request **for user registration**: ![image](https://user-images.githubusercontent.com/43929105/124457765-d85ffe00-dd94-11eb-83c2-3ed8d8d05250.png)
