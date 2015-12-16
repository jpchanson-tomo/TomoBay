/**
 * This package contains all the classes relevant to the Individual Item Refresh Service, this
 * service re queries the eBay API for item data specific to a particular listing.
 * 
 * The purpose of this is: when a user makes a mistake the system will pick up on that mistake,
 * however the BasicEbayUpdateService will not then pick up on any fixes as it concentrates purely
 * on new data. This service allows changes to individual listings to be picked up by the application.
 * @author Jan P.C. Hanson
 *
 */
package tomoBay.model.services.individualItemRefreshService;