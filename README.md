
If you want to import this to your App: 

#Add environment variables to your app
<br>
EMAIL_ADDRESS=your_gmail_address
<br>
EMAIL_PASSWORD=your_gmail_app_password
<br>



#Add to the application.properties
<br>
spring.mail.username=${EMAIL_ADDRESS}
<br>
##spring.mail.password=${EMAIL_PASSWORD}
<br>

