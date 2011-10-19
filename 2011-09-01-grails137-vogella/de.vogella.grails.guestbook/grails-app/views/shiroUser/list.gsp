
<%@ page import="de.vogella.grails.guestbook.ShiroUser" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'shiroUser.label', default: 'ShiroUser')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'shiroUser.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="username" title="${message(code: 'shiroUser.username.label', default: 'Username')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'shiroUser.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'shiroUser.email.label', default: 'Email')}" />
                        
<%--                            <g:sortableColumn property="passwordHash" title="${message(code: 'shiroUser.passwordHash.label', default: 'Password Hash')}" />--%>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${shiroUserInstanceList}" status="i" var="shiroUserInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${shiroUserInstance.id}">${fieldValue(bean: shiroUserInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: shiroUserInstance, field: "username")}</td>
                        
                            <td>${fieldValue(bean: shiroUserInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: shiroUserInstance, field: "email")}</td>
                        
<%--                            <td>${fieldValue(bean: shiroUserInstance, field: "passwordHash")}</td>--%>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${shiroUserInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
