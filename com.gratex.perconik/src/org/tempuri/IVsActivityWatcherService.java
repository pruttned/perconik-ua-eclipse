
package org.tempuri;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;
import com.gratex.perconik.iactivitysvc.IdeCheckinDto;
import com.gratex.perconik.iactivitysvc.IdeCodeOperationDto;
import com.gratex.perconik.iactivitysvc.IdeDocumentOperationDto;
import com.gratex.perconik.iactivitysvc.IdeFindOperationDto;
import com.gratex.perconik.iactivitysvc.IdeProjectOperationDto;
import com.gratex.perconik.iactivitysvc.IdeStateChangeDto;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IVsActivityWatcherService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    com.gratex.perconik.iactivitysvc.ObjectFactory.class,
    org.tempuri.ObjectFactory.class
})
public interface IVsActivityWatcherService {


    /**
     * 
     * @param eventDto
     * @return
     *     returns javax.xml.ws.Response<org.tempuri.NotifyIdeStateChangeResponse>
     */
    @WebMethod(operationName = "NotifyIdeStateChange", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeStateChange")
    @RequestWrapper(localName = "NotifyIdeStateChange", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeStateChange")
    @ResponseWrapper(localName = "NotifyIdeStateChangeResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeStateChangeResponse")
    public Response<NotifyIdeStateChangeResponse> notifyIdeStateChangeAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeStateChangeDto eventDto);

    /**
     * 
     * @param asyncHandler
     * @param eventDto
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "NotifyIdeStateChange", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeStateChange")
    @RequestWrapper(localName = "NotifyIdeStateChange", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeStateChange")
    @ResponseWrapper(localName = "NotifyIdeStateChangeResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeStateChangeResponse")
    public Future<?> notifyIdeStateChangeAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeStateChangeDto eventDto,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<NotifyIdeStateChangeResponse> asyncHandler);

    /**
     * 
     * @param eventDto
     */
    @WebMethod(operationName = "NotifyIdeStateChange", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeStateChange")
    @RequestWrapper(localName = "NotifyIdeStateChange", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeStateChange")
    @ResponseWrapper(localName = "NotifyIdeStateChangeResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeStateChangeResponse")
    public void notifyIdeStateChange(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeStateChangeDto eventDto);

    /**
     * 
     * @param eventDto
     * @return
     *     returns javax.xml.ws.Response<org.tempuri.NotifyIdeDocumentOperationResponse>
     */
    @WebMethod(operationName = "NotifyIdeDocumentOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeDocumentOperation")
    @RequestWrapper(localName = "NotifyIdeDocumentOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeDocumentOperation")
    @ResponseWrapper(localName = "NotifyIdeDocumentOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeDocumentOperationResponse")
    public Response<NotifyIdeDocumentOperationResponse> notifyIdeDocumentOperationAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeDocumentOperationDto eventDto);

    /**
     * 
     * @param asyncHandler
     * @param eventDto
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "NotifyIdeDocumentOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeDocumentOperation")
    @RequestWrapper(localName = "NotifyIdeDocumentOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeDocumentOperation")
    @ResponseWrapper(localName = "NotifyIdeDocumentOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeDocumentOperationResponse")
    public Future<?> notifyIdeDocumentOperationAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeDocumentOperationDto eventDto,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<NotifyIdeDocumentOperationResponse> asyncHandler);

    /**
     * 
     * @param eventDto
     */
    @WebMethod(operationName = "NotifyIdeDocumentOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeDocumentOperation")
    @RequestWrapper(localName = "NotifyIdeDocumentOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeDocumentOperation")
    @ResponseWrapper(localName = "NotifyIdeDocumentOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeDocumentOperationResponse")
    public void notifyIdeDocumentOperation(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeDocumentOperationDto eventDto);

    /**
     * 
     * @param eventDto
     * @return
     *     returns javax.xml.ws.Response<org.tempuri.NotifyIdeProjectOperationResponse>
     */
    @WebMethod(operationName = "NotifyIdeProjectOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeProjectOperation")
    @RequestWrapper(localName = "NotifyIdeProjectOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeProjectOperation")
    @ResponseWrapper(localName = "NotifyIdeProjectOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeProjectOperationResponse")
    public Response<NotifyIdeProjectOperationResponse> notifyIdeProjectOperationAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeProjectOperationDto eventDto);

    /**
     * 
     * @param asyncHandler
     * @param eventDto
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "NotifyIdeProjectOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeProjectOperation")
    @RequestWrapper(localName = "NotifyIdeProjectOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeProjectOperation")
    @ResponseWrapper(localName = "NotifyIdeProjectOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeProjectOperationResponse")
    public Future<?> notifyIdeProjectOperationAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeProjectOperationDto eventDto,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<NotifyIdeProjectOperationResponse> asyncHandler);

    /**
     * 
     * @param eventDto
     */
    @WebMethod(operationName = "NotifyIdeProjectOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeProjectOperation")
    @RequestWrapper(localName = "NotifyIdeProjectOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeProjectOperation")
    @ResponseWrapper(localName = "NotifyIdeProjectOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeProjectOperationResponse")
    public void notifyIdeProjectOperation(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeProjectOperationDto eventDto);

    /**
     * 
     * @param eventDto
     * @return
     *     returns javax.xml.ws.Response<org.tempuri.NotifyIdeCheckinResponse>
     */
    @WebMethod(operationName = "NotifyIdeCheckin", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeCheckin")
    @RequestWrapper(localName = "NotifyIdeCheckin", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCheckin")
    @ResponseWrapper(localName = "NotifyIdeCheckinResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCheckinResponse")
    public Response<NotifyIdeCheckinResponse> notifyIdeCheckinAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeCheckinDto eventDto);

    /**
     * 
     * @param asyncHandler
     * @param eventDto
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "NotifyIdeCheckin", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeCheckin")
    @RequestWrapper(localName = "NotifyIdeCheckin", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCheckin")
    @ResponseWrapper(localName = "NotifyIdeCheckinResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCheckinResponse")
    public Future<?> notifyIdeCheckinAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeCheckinDto eventDto,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<NotifyIdeCheckinResponse> asyncHandler);

    /**
     * 
     * @param eventDto
     */
    @WebMethod(operationName = "NotifyIdeCheckin", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeCheckin")
    @RequestWrapper(localName = "NotifyIdeCheckin", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCheckin")
    @ResponseWrapper(localName = "NotifyIdeCheckinResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCheckinResponse")
    public void notifyIdeCheckin(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeCheckinDto eventDto);

    /**
     * 
     * @param eventDto
     * @return
     *     returns javax.xml.ws.Response<org.tempuri.NotifyIdeCodeOperationResponse>
     */
    @WebMethod(operationName = "NotifyIdeCodeOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeCodeOperation")
    @RequestWrapper(localName = "NotifyIdeCodeOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCodeOperation")
    @ResponseWrapper(localName = "NotifyIdeCodeOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCodeOperationResponse")
    public Response<NotifyIdeCodeOperationResponse> notifyIdeCodeOperationAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeCodeOperationDto eventDto);

    /**
     * 
     * @param asyncHandler
     * @param eventDto
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "NotifyIdeCodeOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeCodeOperation")
    @RequestWrapper(localName = "NotifyIdeCodeOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCodeOperation")
    @ResponseWrapper(localName = "NotifyIdeCodeOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCodeOperationResponse")
    public Future<?> notifyIdeCodeOperationAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeCodeOperationDto eventDto,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<NotifyIdeCodeOperationResponse> asyncHandler);

    /**
     * 
     * @param eventDto
     */
    @WebMethod(operationName = "NotifyIdeCodeOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeCodeOperation")
    @RequestWrapper(localName = "NotifyIdeCodeOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCodeOperation")
    @ResponseWrapper(localName = "NotifyIdeCodeOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeCodeOperationResponse")
    public void notifyIdeCodeOperation(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeCodeOperationDto eventDto);

    /**
     * 
     * @param eventDto
     * @return
     *     returns javax.xml.ws.Response<org.tempuri.NotifyIdeFindOperationResponse>
     */
    @WebMethod(operationName = "NotifyIdeFindOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeFindOperation")
    @RequestWrapper(localName = "NotifyIdeFindOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeFindOperation")
    @ResponseWrapper(localName = "NotifyIdeFindOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeFindOperationResponse")
    public Response<NotifyIdeFindOperationResponse> notifyIdeFindOperationAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeFindOperationDto eventDto);

    /**
     * 
     * @param asyncHandler
     * @param eventDto
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "NotifyIdeFindOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeFindOperation")
    @RequestWrapper(localName = "NotifyIdeFindOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeFindOperation")
    @ResponseWrapper(localName = "NotifyIdeFindOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeFindOperationResponse")
    public Future<?> notifyIdeFindOperationAsync(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeFindOperationDto eventDto,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<NotifyIdeFindOperationResponse> asyncHandler);

    /**
     * 
     * @param eventDto
     */
    @WebMethod(operationName = "NotifyIdeFindOperation", action = "http://tempuri.org/IVsActivityWatcherService/NotifyIdeFindOperation")
    @RequestWrapper(localName = "NotifyIdeFindOperation", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeFindOperation")
    @ResponseWrapper(localName = "NotifyIdeFindOperationResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NotifyIdeFindOperationResponse")
    public void notifyIdeFindOperation(
        @WebParam(name = "eventDto", targetNamespace = "http://tempuri.org/")
        IdeFindOperationDto eventDto);

}