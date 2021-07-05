# Login system. Spring Security
Login system with email veryfication and some other basic db functionality

- **The project uses [MailDev](https://github.com/maildev/maildev)(requires [Node.js](https://nodejs.org/en/)).** Go to the links for setting up.  
- **Do not forget to configure _application.context_(src\main\resources) and _SpringConfig_(src/main/java/com.fuser.english)**  
- All url is secured _except_ (/registration/*)  
- You can **_change secured url_** in java config security file (package security -> config).


# Usage
For testing functionality use [Postman](https://go.postman.co/build)
- **POST Request for user registration** (returns confirmation token):   ![image](https://user-images.githubusercontent.com/43929105/124458427-a13e1c80-dd95-11eb-974a-53cdc329581c.png)
- **GET Request for email confirmation** or use the link in the letter you received in MailDev:   ![image](https://user-images.githubusercontent.com/43929105/124458263-6dfb8d80-dd95-11eb-9848-a53d61da4a60.png)
