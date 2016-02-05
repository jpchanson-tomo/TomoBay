package tomoBay.model.services;
import java.util.concurrent.Callable;

import tomoBay.exceptions.ServiceException;
import tomoBay.model.dataTypes.ServerStatus;
/**
 * Allows the system to only accept runnable's that implement this
 * interface rather than all runnables. As well as providing an interface that all abstract 
 * service should conform to.
 * 
 * There are two varieties of AbstractService Derived Type: an unconfigured Service and a configured
 * service. for an unconfigured service ignore the setConfig method as the service will ignore it
 * anyway.
 * 
 * for a configured service it is necessary to provide an AbstractConfiguration object in order
 * for it to work properly
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractService implements Callable<String>
{
	/**
	 * The individual services equivalent of main
	 */
	public String call() throws ServiceException
	{
		ServerStatus.RunLevel runLevel = ServerStatus.getStatus();
		if(runLevel == ServerStatus.RunLevel.RUNNING) {return this.onRunning();}
		else if(runLevel == ServerStatus.RunLevel.PAUSED) {return this.onPaused();}
		else if(runLevel == ServerStatus.RunLevel.STOPPED) {return this.onStopped();}
		else {return this.onError();}
	}
	
	/**
	 * sets the configuration for this service. Not all services require configuration, see the
	 * documentation for individual services.
	 * @param config the AbstractConfiguration concrete object applicable to the concrete service.
	 */
	public abstract <E> void setConfig(AbstractConfiguration<E> config);
	
	protected abstract String onRunning() throws ServiceException;
	
	protected abstract String onPaused() throws ServiceException;
	
	protected abstract String onStopped() throws ServiceException;
	
	protected abstract String onError() throws ServiceException;
}
