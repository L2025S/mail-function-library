
If you want to import this to your App: 

# Add environment variables to your app
<br>
GMAIL_ADDRESS=your_gmail_address
<br>
GMAIL_APP_PASSWORD=your_gmail_app_password
<br>



# Add to the application.properties
<br>
spring.mail.username=${GMAIL_ADDRESS}
<br>
spring.mail.password=${GMAIL_APP_PASSWORD}
<br>


# Add settings.xml
