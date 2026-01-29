package Adapter;

public class XMLtoJSONAdapter implements JSONService {

    private XMLService xmlService;

    public XMLtoJSONAdapter(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public void processJSON(String jsonData) {
        // Convert JSON to XML (giả lập)
        String xmlData = convertJSONtoXML(jsonData);
        xmlService.processXML(xmlData);
    }

    private String convertJSONtoXML(String json) {
        return "<xml>" + json + "</xml>";
    }
}
