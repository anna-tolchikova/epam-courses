
    <jsp:directive.page contentType="text/html;charset=UTF-8" language="java" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <html>
    <head>
        <title>Bye</title>

        <link href="../css/auth_style.css" rel="stylesheet" type="text/css" />
        <link rel="icon" href="https://github.com/fluidicon.png" type="image/x-icon"/>


    </head>

    <body>

    <div id="login">
        <form name="LoginForm" action="ParsersServlet" method="post">
            <fieldset class="clearfix">
                <p><span class="fontawesome-user"></span><input type="text" name="login" value="Логин" onBlur="if(this.value == '') this.value = 'Логин'" onFocus="if(this.value == 'Логин') this.value = ''" required /></p> <!-- JS because of IE support; better: placeholder="Username" -->
                <p><span class="fontawesome-lock"></span><input type="password"  name="password" value="Пароль" onBlur="if(this.value == '') this.value = 'Пароль'" onFocus="if(this.value == 'Пароль') this.value = ''" required /></p> <!-- JS because of IE support; better: placeholder="Password" -->

                <c:if test="${ not empty errorLoginPassMessage}">
                    <p style="color: red;">${errorLoginPassMessage}</p>
                </c:if>

                <c:if test="${ not empty wrongAction}">
                    <p style="color: red;">${wrongAction}</p>
                </c:if>

                <c:if test="${ not empty nullPage}">
                    <p style="color: red;">${nullPage}</p>
                </c:if>


                <p><input type="submit" value="ВОЙТИ"/></p>
                <input type="hidden" name="command" value="login" />

            </fieldset>
        </form>
       <!-- <p>Нет аккаунта? &nbsp;&nbsp;<a href="#">Регистрация</a><span class="fontawesome-arrow-right"></span></p>-->
    </div>

    </body>

    </html>
