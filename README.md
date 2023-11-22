# maventestng

test if the toast "Registration failed" is desplayed 

1. Navigate to - http://training.skillo-bg.com:4200/posts/all
2. Click on "LogIn button" - //*[@id='nav-link-login']
3. Assert that the URL is right - http://training.skillo-bg.com:4200/users/login 
4. Click on "Register" button - //*[contains(text(),'Register')]
4.a. Assert that the URL is right - http://training.skillo-bg.com:4200/users/register
4.b. Assert "Sign up" is shown - .h4
5. Enter Username - //*[@formcontrolname='username']
6. Enter email - //*[@formcontrolname='email']
7. Enter Password - //*[@formcontrolname='password']
8. Enter Confirm Password - //*[@id='defaultRegisterPhonePassword'] 
9. Click on "Sign in" button - //*[@id='sign-in-button'] 
10. Check if the toast for "Registration faild" is displayed - //*[@id='toast-container']
