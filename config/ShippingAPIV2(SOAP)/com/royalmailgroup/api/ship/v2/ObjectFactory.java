
package com.royalmailgroup.api.ship.v2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.royalmailgroup.soap.extensions.v1.ExceptionDetails;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.royalmailgroup.api.ship.v2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Request2DItemIDRangeRequest_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "request2DItemIDRangeRequest");
    private final static QName _PrintManifestResponse_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "printManifestResponse");
    private final static QName _UpdateShipmentResponse_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "updateShipmentResponse");
    private final static QName _Request1DRangesResponse_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "request1DRangesResponse");
    private final static QName _PrintDocumentResponse_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "printDocumentResponse");
    private final static QName _CreateManifestResponse_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "createManifestResponse");
    private final static QName _Request1DRangesRequest_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "request1DRangesRequest");
    private final static QName _ExceptionDetails_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "exceptionDetails");
    private final static QName _ComplementaryName_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "complementaryName");
    private final static QName _CreateShipmentResponse_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "createShipmentResponse");
    private final static QName _CancelShipmentRequest_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "cancelShipmentRequest");
    private final static QName _CreateManifestRequest_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "createManifestRequest");
    private final static QName _PrintManifestRequest_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "printManifestRequest");
    private final static QName _PrintDocumentRequest_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "printDocumentRequest");
    private final static QName _CreateShipmentRequest_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "createShipmentRequest");
    private final static QName _PrintLabelRequest_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "printLabelRequest");
    private final static QName _Request2DItemIDRangeResponse_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "request2DItemIDRangeResponse");
    private final static QName _CancelShipmentResponse_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "cancelShipmentResponse");
    private final static QName _UpdateShipmentRequest_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "updateShipmentRequest");
    private final static QName _PrintLabelResponse_QNAME = new QName("http://www.royalmailgroup.com/api/ship/V2", "printLabelResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.royalmailgroup.api.ship.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateShipmentResponse }
     * 
     */
    public CreateShipmentResponse createCreateShipmentResponse() {
        return new CreateShipmentResponse();
    }

    /**
     * Create an instance of {@link PrintManifestRequest }
     * 
     */
    public PrintManifestRequest createPrintManifestRequest() {
        return new PrintManifestRequest();
    }

    /**
     * Create an instance of {@link PrintDocumentResponse }
     * 
     */
    public PrintDocumentResponse createPrintDocumentResponse() {
        return new PrintDocumentResponse();
    }

    /**
     * Create an instance of {@link Request1DRangesResponse }
     * 
     */
    public Request1DRangesResponse createRequest1DRangesResponse() {
        return new Request1DRangesResponse();
    }

    /**
     * Create an instance of {@link UpdateShipmentResponse }
     * 
     */
    public UpdateShipmentResponse createUpdateShipmentResponse() {
        return new UpdateShipmentResponse();
    }

    /**
     * Create an instance of {@link Request1DRangesRequest }
     * 
     */
    public Request1DRangesRequest createRequest1DRangesRequest() {
        return new Request1DRangesRequest();
    }

    /**
     * Create an instance of {@link Request2DItemIDRangeRequest }
     * 
     */
    public Request2DItemIDRangeRequest createRequest2DItemIDRangeRequest() {
        return new Request2DItemIDRangeRequest();
    }

    /**
     * Create an instance of {@link Request2DItemIDRangeResponse }
     * 
     */
    public Request2DItemIDRangeResponse createRequest2DItemIDRangeResponse() {
        return new Request2DItemIDRangeResponse();
    }

    /**
     * Create an instance of {@link PrintLabelRequest }
     * 
     */
    public PrintLabelRequest createPrintLabelRequest() {
        return new PrintLabelRequest();
    }

    /**
     * Create an instance of {@link CreateManifestRequest }
     * 
     */
    public CreateManifestRequest createCreateManifestRequest() {
        return new CreateManifestRequest();
    }

    /**
     * Create an instance of {@link CreateManifestResponse }
     * 
     */
    public CreateManifestResponse createCreateManifestResponse() {
        return new CreateManifestResponse();
    }

    /**
     * Create an instance of {@link PrintManifestResponse }
     * 
     */
    public PrintManifestResponse createPrintManifestResponse() {
        return new PrintManifestResponse();
    }

    /**
     * Create an instance of {@link PrintLabelResponse }
     * 
     */
    public PrintLabelResponse createPrintLabelResponse() {
        return new PrintLabelResponse();
    }

    /**
     * Create an instance of {@link CancelShipmentRequest }
     * 
     */
    public CancelShipmentRequest createCancelShipmentRequest() {
        return new CancelShipmentRequest();
    }

    /**
     * Create an instance of {@link CreateShipmentRequest }
     * 
     */
    public CreateShipmentRequest createCreateShipmentRequest() {
        return new CreateShipmentRequest();
    }

    /**
     * Create an instance of {@link UpdateShipmentRequest }
     * 
     */
    public UpdateShipmentRequest createUpdateShipmentRequest() {
        return new UpdateShipmentRequest();
    }

    /**
     * Create an instance of {@link PrintDocumentRequest }
     * 
     */
    public PrintDocumentRequest createPrintDocumentRequest() {
        return new PrintDocumentRequest();
    }

    /**
     * Create an instance of {@link CancelShipmentResponse }
     * 
     */
    public CancelShipmentResponse createCancelShipmentResponse() {
        return new CancelShipmentResponse();
    }

    /**
     * Create an instance of {@link LabelData }
     * 
     */
    public LabelData createLabelData() {
        return new LabelData();
    }

    /**
     * Create an instance of {@link BaseRequest }
     * 
     */
    public BaseRequest createBaseRequest() {
        return new BaseRequest();
    }

    /**
     * Create an instance of {@link Barcode1DRange }
     * 
     */
    public Barcode1DRange createBarcode1DRange() {
        return new Barcode1DRange();
    }

    /**
     * Create an instance of {@link ContentDetail }
     * 
     */
    public ContentDetail createContentDetail() {
        return new ContentDetail();
    }

    /**
     * Create an instance of {@link ContentDetails }
     * 
     */
    public ContentDetails createContentDetails() {
        return new ContentDetails();
    }

    /**
     * Create an instance of {@link ServiceEnhancements }
     * 
     */
    public ServiceEnhancements createServiceEnhancements() {
        return new ServiceEnhancements();
    }

    /**
     * Create an instance of {@link AllCompletedShipments }
     * 
     */
    public AllCompletedShipments createAllCompletedShipments() {
        return new AllCompletedShipments();
    }

    /**
     * Create an instance of {@link Contact }
     * 
     */
    public Contact createContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link Parcel }
     * 
     */
    public Parcel createParcel() {
        return new Parcel();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link Shipment }
     * 
     */
    public Shipment createShipment() {
        return new Shipment();
    }

    /**
     * Create an instance of {@link ManifestShipments }
     * 
     */
    public ManifestShipments createManifestShipments() {
        return new ManifestShipments();
    }

    /**
     * Create an instance of {@link CompletedShipments }
     * 
     */
    public CompletedShipments createCompletedShipments() {
        return new CompletedShipments();
    }

    /**
     * Create an instance of {@link LabelImages }
     * 
     */
    public LabelImages createLabelImages() {
        return new LabelImages();
    }

    /**
     * Create an instance of {@link ManifestShipment }
     * 
     */
    public ManifestShipment createManifestShipment() {
        return new ManifestShipment();
    }

    /**
     * Create an instance of {@link LocalisedAddress }
     * 
     */
    public LocalisedAddress createLocalisedAddress() {
        return new LocalisedAddress();
    }

    /**
     * Create an instance of {@link ItemIDRange }
     * 
     */
    public ItemIDRange createItemIDRange() {
        return new ItemIDRange();
    }

    /**
     * Create an instance of {@link Items }
     * 
     */
    public Items createItems() {
        return new Items();
    }

    /**
     * Create an instance of {@link ServiceRange }
     * 
     */
    public ServiceRange createServiceRange() {
        return new ServiceRange();
    }

    /**
     * Create an instance of {@link Parcels }
     * 
     */
    public Parcels createParcels() {
        return new Parcels();
    }

    /**
     * Create an instance of {@link CompletedManifests }
     * 
     */
    public CompletedManifests createCompletedManifests() {
        return new CompletedManifests();
    }

    /**
     * Create an instance of {@link CancelShipments }
     * 
     */
    public CancelShipments createCancelShipments() {
        return new CancelShipments();
    }

    /**
     * Create an instance of {@link InternationalInfo }
     * 
     */
    public InternationalInfo createInternationalInfo() {
        return new InternationalInfo();
    }

    /**
     * Create an instance of {@link ServiceReference }
     * 
     */
    public ServiceReference createServiceReference() {
        return new ServiceReference();
    }

    /**
     * Create an instance of {@link ServiceReferences }
     * 
     */
    public ServiceReferences createServiceReferences() {
        return new ServiceReferences();
    }

    /**
     * Create an instance of {@link CompletedShipmentInfo }
     * 
     */
    public CompletedShipmentInfo createCompletedShipmentInfo() {
        return new CompletedShipmentInfo();
    }

    /**
     * Create an instance of {@link CompletedCancelShipments }
     * 
     */
    public CompletedCancelShipments createCompletedCancelShipments() {
        return new CompletedCancelShipments();
    }

    /**
     * Create an instance of {@link CompletedManifestInfo }
     * 
     */
    public CompletedManifestInfo createCompletedManifestInfo() {
        return new CompletedManifestInfo();
    }

    /**
     * Create an instance of {@link Shipments }
     * 
     */
    public Shipments createShipments() {
        return new Shipments();
    }

    /**
     * Create an instance of {@link CompletedCancelInfo }
     * 
     */
    public CompletedCancelInfo createCompletedCancelInfo() {
        return new CompletedCancelInfo();
    }

    /**
     * Create an instance of {@link RequestedShipment }
     * 
     */
    public RequestedShipment createRequestedShipment() {
        return new RequestedShipment();
    }

    /**
     * Create an instance of {@link ServiceRanges }
     * 
     */
    public ServiceRanges createServiceRanges() {
        return new ServiceRanges();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request2DItemIDRangeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "request2DItemIDRangeRequest")
    public JAXBElement<Request2DItemIDRangeRequest> createRequest2DItemIDRangeRequest(Request2DItemIDRangeRequest value) {
        return new JAXBElement<Request2DItemIDRangeRequest>(_Request2DItemIDRangeRequest_QNAME, Request2DItemIDRangeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintManifestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "printManifestResponse")
    public JAXBElement<PrintManifestResponse> createPrintManifestResponse(PrintManifestResponse value) {
        return new JAXBElement<PrintManifestResponse>(_PrintManifestResponse_QNAME, PrintManifestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateShipmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "updateShipmentResponse")
    public JAXBElement<UpdateShipmentResponse> createUpdateShipmentResponse(UpdateShipmentResponse value) {
        return new JAXBElement<UpdateShipmentResponse>(_UpdateShipmentResponse_QNAME, UpdateShipmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request1DRangesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "request1DRangesResponse")
    public JAXBElement<Request1DRangesResponse> createRequest1DRangesResponse(Request1DRangesResponse value) {
        return new JAXBElement<Request1DRangesResponse>(_Request1DRangesResponse_QNAME, Request1DRangesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintDocumentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "printDocumentResponse")
    public JAXBElement<PrintDocumentResponse> createPrintDocumentResponse(PrintDocumentResponse value) {
        return new JAXBElement<PrintDocumentResponse>(_PrintDocumentResponse_QNAME, PrintDocumentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateManifestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "createManifestResponse")
    public JAXBElement<CreateManifestResponse> createCreateManifestResponse(CreateManifestResponse value) {
        return new JAXBElement<CreateManifestResponse>(_CreateManifestResponse_QNAME, CreateManifestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request1DRangesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "request1DRangesRequest")
    public JAXBElement<Request1DRangesRequest> createRequest1DRangesRequest(Request1DRangesRequest value) {
        return new JAXBElement<Request1DRangesRequest>(_Request1DRangesRequest_QNAME, Request1DRangesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "exceptionDetails")
    public JAXBElement<ExceptionDetails> createExceptionDetails(ExceptionDetails value) {
        return new JAXBElement<ExceptionDetails>(_ExceptionDetails_QNAME, ExceptionDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "complementaryName")
    public JAXBElement<String> createComplementaryName(String value) {
        return new JAXBElement<String>(_ComplementaryName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateShipmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "createShipmentResponse")
    public JAXBElement<CreateShipmentResponse> createCreateShipmentResponse(CreateShipmentResponse value) {
        return new JAXBElement<CreateShipmentResponse>(_CreateShipmentResponse_QNAME, CreateShipmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelShipmentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "cancelShipmentRequest")
    public JAXBElement<CancelShipmentRequest> createCancelShipmentRequest(CancelShipmentRequest value) {
        return new JAXBElement<CancelShipmentRequest>(_CancelShipmentRequest_QNAME, CancelShipmentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateManifestRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "createManifestRequest")
    public JAXBElement<CreateManifestRequest> createCreateManifestRequest(CreateManifestRequest value) {
        return new JAXBElement<CreateManifestRequest>(_CreateManifestRequest_QNAME, CreateManifestRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintManifestRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "printManifestRequest")
    public JAXBElement<PrintManifestRequest> createPrintManifestRequest(PrintManifestRequest value) {
        return new JAXBElement<PrintManifestRequest>(_PrintManifestRequest_QNAME, PrintManifestRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintDocumentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "printDocumentRequest")
    public JAXBElement<PrintDocumentRequest> createPrintDocumentRequest(PrintDocumentRequest value) {
        return new JAXBElement<PrintDocumentRequest>(_PrintDocumentRequest_QNAME, PrintDocumentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateShipmentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "createShipmentRequest")
    public JAXBElement<CreateShipmentRequest> createCreateShipmentRequest(CreateShipmentRequest value) {
        return new JAXBElement<CreateShipmentRequest>(_CreateShipmentRequest_QNAME, CreateShipmentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintLabelRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "printLabelRequest")
    public JAXBElement<PrintLabelRequest> createPrintLabelRequest(PrintLabelRequest value) {
        return new JAXBElement<PrintLabelRequest>(_PrintLabelRequest_QNAME, PrintLabelRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request2DItemIDRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "request2DItemIDRangeResponse")
    public JAXBElement<Request2DItemIDRangeResponse> createRequest2DItemIDRangeResponse(Request2DItemIDRangeResponse value) {
        return new JAXBElement<Request2DItemIDRangeResponse>(_Request2DItemIDRangeResponse_QNAME, Request2DItemIDRangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelShipmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "cancelShipmentResponse")
    public JAXBElement<CancelShipmentResponse> createCancelShipmentResponse(CancelShipmentResponse value) {
        return new JAXBElement<CancelShipmentResponse>(_CancelShipmentResponse_QNAME, CancelShipmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateShipmentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "updateShipmentRequest")
    public JAXBElement<UpdateShipmentRequest> createUpdateShipmentRequest(UpdateShipmentRequest value) {
        return new JAXBElement<UpdateShipmentRequest>(_UpdateShipmentRequest_QNAME, UpdateShipmentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintLabelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.royalmailgroup.com/api/ship/V2", name = "printLabelResponse")
    public JAXBElement<PrintLabelResponse> createPrintLabelResponse(PrintLabelResponse value) {
        return new JAXBElement<PrintLabelResponse>(_PrintLabelResponse_QNAME, PrintLabelResponse.class, null, value);
    }

}
