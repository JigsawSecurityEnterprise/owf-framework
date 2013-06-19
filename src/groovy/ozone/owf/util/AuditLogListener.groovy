package ozone.owf.util

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.ozoneplatform.auditing.hibernate.AbstractAuditLogListener
import ozone.owf.grails.services.AccountService
import org.springframework.web.context.request.RequestContextHolder
import javax.servlet.http.HttpServletRequest

class AuditLogListener extends AbstractAuditLogListener {

    GrailsApplication grailsApplication
    AccountService accountService

    @Override
    public boolean doLogging() {
        return true
    }

    @Override
    public boolean doObjectAccessLogging(){
        return false
    }

    @Override
    public String getApplicationVersion() {
        return grailsApplication.metadata['app.version']
    }

    @Override
    public String getUserName() {
        return accountService.getLoggedInUsername()
    }

    @Override
    public String getHostClassification() {
        return "UNKNOWN";
    }

    @Override
    public HttpServletRequest getRequest()
    {
        return RequestContextHolder?.getRequestAttributes()?.getRequest()
    }
}