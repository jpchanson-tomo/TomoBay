/**
 * This package contains all classes and sub packages relevant to Services that can be run 
 * by the system, Ways of creating the services and ways to run them i.e. scheduled or triggered.
 * 
 * Scheduled services run intermittantly at set intervals (measured from the end of the previous
 * run)
 * 
 * Triggered services run as they are requested.
 * 
 * Both ways of running services have their own thread pool. The scheduled services threadpool
 * should be set to the number of services in the services queue. Whereas the triggered services
 * thread pool should be set to a value that makes sense for the hardware that it is being run on.
 * 
 * This package also contains the ServiceFactory which, like other factories in this application
 * is creates objects as specified by an internal enum which defines accepteable input values.
 * @author Jan P.C. Hanson
 *
 */
package tomoBay.model.services;