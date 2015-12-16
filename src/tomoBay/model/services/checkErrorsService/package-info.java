/**
 * This package contains all the classes necessary for the checkErrors service. This service
 * goes through all the uninvoiced orders and checks to see if all the items contain sufficient
 * valid data i.e. a valid brand and valid part number. marking them as errors if it finds an
 * item lacking in either of these areas.
 * @author Jan P.C. Hanson
 *
 */
package tomoBay.model.services.checkErrorsService;