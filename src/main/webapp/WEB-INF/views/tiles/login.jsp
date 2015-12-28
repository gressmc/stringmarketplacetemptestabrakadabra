<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrapper">

    <div id="login" class="formInput">
        <c:url value="/static/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" name="loginform" method="post">
            <h1>Enter</h1>
            <input type="hidden" name="action" value="dologin"/>

            <p>
                <label for="username_signin" class="uname">Your login</label>
                <input id="username_signin" name="j_username" placeholder="Login"
                       required="required" type="text"
                       value="seller"/><br/>
            </p>

            <p>
                <label for="password_signin" class="upass">Your password</label>
                <input id="password_signin" name="j_password" placeholder="Password"
                       required="required" type="password"
                       value="seller"/><br/>
            </p>

            <p class="button">
                <input value="Enter" id="submit_enter" type="submit"/>
                <input value="Join us" class="reg_toggle_log" type="button"/>
            </p>
        </form>
        <form action="${pageContext.servletContext.contextPath}/guest" method="post">
            <input type="hidden" name="action" value="guest"/>

            <p class="button">
                <input value="Guest" id="guest_enter" type="submit"/>
            </p>
        </form>
        <p align="center" class="message"><%= request.getAttribute("validationmessage") %>
        </p>
    </div>

    <div id="register" class="formInput">
        <form action="${pageContext.servletContext.contextPath}/registration" name="regform" method="post">
            <input type="hidden" name="action" value="doregister"/>

            <h1>Register</h1>
            <p>
                <label for="username_signup" class="uname">Your login</label>
                <input id="username_signup" name="username_signup" required="required"
                       type="text" placeholder="Login"/>
            </p>

            <p>
                <label for="name_signup" class="uname">Your name</label>
                <input id="name_signup" name="name_signup" required="required"
                       type="text" placeholder="ФИО"/>
            </p>

            <p>
                <label for="lastname_signup" class="uname">Your last name</label>
                <input id="lastname_signup" name="lastname_signup" required="required"
                       type="text" placeholder="ФИО"/>
            </p>

            <p>
                <label for="useraddres_signup" class="uname">Your address</label>
                <input id="useraddres_signup" name="useraddres_signup"
                       required="required" type="text" placeholder="Billing Address"/>
            </p>

            <p>
                <label for="emailsignup" class="umail">Your e-mail</label>
                <input id="emailsignup" name="emailsignup" required="required"
                       type="email" placeholder="address@my.com"
                       pattern="[\w-_.]+)@((?:[\w]+\.)+)([a-zA-Z]{2,4}"/>
            </p>

            <p>
                <label for="password_signup" class="upass">Your password</label>
                <input id="password_signup" name="password_signup" required="required"
                       type="password" placeholder="Password"/>
            </p>

            <p>
                <label for="password_signup_confirm" class="upass">Re-enter password</label>
                <input id="password_signup_confirm" name="password_signup_confirm"
                       required="required" type="password" placeholder="Password"/>
            </p>

            <p class="button">
                <input value="Register" type="submit"/>
                <input value="Already with us?" class="reg_toggle_log" type="button"/>
            </p>
        </form>
        <p align="center" class="message"><%= request.getAttribute("validationmessage") %>
        </p>
    </div>
</div>